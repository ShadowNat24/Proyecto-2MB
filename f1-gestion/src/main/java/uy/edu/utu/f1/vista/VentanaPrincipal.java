package uy.edu.utu.f1.vista;

import uy.edu.utu.f1.persistencia.RepositorioGenerico;
import uy.edu.utu.f1.persistencia.RepositorioGenerico.Columna;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/** Ventana principal Swing para trabajar directamente con la base de datos. */
public class VentanaPrincipal extends JFrame {
    private final RepositorioGenerico repositorio = new RepositorioGenerico();
    private final JComboBox<String> selectorTabla = new JComboBox<>();
    private final JTable tablaDatos = new JTable();
    private final JPanel formulario = new JPanel(new GridBagLayout());
    private final JPanel botones = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private final List<Columna> columnas = new ArrayList<>();
    private final Map<String, JTextField> campos = new LinkedHashMap<>();
    private Map<String, Object> clavesOriginales = new LinkedHashMap<>();

    public VentanaPrincipal() {
        setTitle("F1 Gestión - Panel de administración");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1100, 700);
        setLocationRelativeTo(null);
        construirInterfaz();
        cargarTablas();
    }

    private void construirInterfaz() {
        JPanel superior = new JPanel(new FlowLayout(FlowLayout.LEFT));
        superior.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        superior.add(new JLabel("Tabla:"));
        superior.add(selectorTabla);
        JButton recargar = new JButton("Recargar");
        recargar.addActionListener(e -> cargarDatos());
        superior.add(recargar);
        selectorTabla.addActionListener(e -> cargarTablaSeleccionada());

        formulario.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        tablaDatos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablaDatos.getSelectionModel().addListSelectionListener(e -> cargarFilaSeleccionada());

        JButton nuevo = new JButton("Nuevo / Limpiar");
        JButton guardar = new JButton("Guardar");
        JButton actualizar = new JButton("Actualizar");
        JButton eliminar = new JButton("Eliminar");
        nuevo.addActionListener(e -> limpiarFormulario());
        guardar.addActionListener(e -> insertar());
        actualizar.addActionListener(e -> actualizar());
        eliminar.addActionListener(e -> eliminar());
        botones.add(nuevo);
        botones.add(guardar);
        botones.add(actualizar);
        botones.add(eliminar);

        JPanel ladoDerecho = new JPanel(new BorderLayout());
        ladoDerecho.add(new JScrollPane(formulario), BorderLayout.CENTER);
        ladoDerecho.add(botones, BorderLayout.SOUTH);

        JSplitPane contenido = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                new JScrollPane(tablaDatos), ladoDerecho);
        contenido.setResizeWeight(0.65);

        add(superior, BorderLayout.NORTH);
        add(contenido, BorderLayout.CENTER);
    }

    private void cargarTablas() {
        selectorTabla.removeAllItems();
        for (String tabla : repositorio.obtenerTablas()) {
            selectorTabla.addItem(tabla);
        }
        if (selectorTabla.getItemCount() > 0) {
            selectorTabla.setSelectedIndex(0);
        }
    }

    private void cargarTablaSeleccionada() {
        String tabla = (String) selectorTabla.getSelectedItem();
        if (tabla == null) return;
        try {
            columnas.clear();
            columnas.addAll(repositorio.obtenerColumnas(tabla));
            construirFormulario();
            cargarDatos();
        } catch (Exception e) {
            mostrarError(e);
        }
    }

    private void construirFormulario() {
        formulario.removeAll();
        campos.clear();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4);
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        int fila = 0;
        for (Columna columna : columnas) {
            JLabel etiqueta = new JLabel(columna.nombre() + (columna.autoincremental() ? " (auto)" : ""));
            JTextField campo = new JTextField(22);
            campo.setToolTipText("Tipo SQL: " + columna.tipoTexto());
            if (columna.autoincremental()) campo.setEnabled(false);
            gbc.gridx = 0;
            gbc.gridy = fila;
            gbc.weightx = 0;
            formulario.add(etiqueta, gbc);
            gbc.gridx = 1;
            gbc.weightx = 1;
            formulario.add(campo, gbc);
            campos.put(columna.nombre(), campo);
            fila++;
        }
        gbc.gridx = 0;
        gbc.gridy = fila;
        gbc.gridwidth = 2;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        formulario.add(new JPanel(), gbc);
        formulario.revalidate();
        formulario.repaint();
    }

    private void cargarDatos() {
        String tabla = (String) selectorTabla.getSelectedItem();
        if (tabla == null) return;
        try {
            List<Map<String, Object>> filas = repositorio.listar(tabla);
            String[] nombres = columnas.stream().map(Columna::nombre).toArray(String[]::new);
            Object[][] datos = new Object[filas.size()][nombres.length];
            for (int i = 0; i < filas.size(); i++) {
                for (int j = 0; j < nombres.length; j++) {
                    datos[i][j] = filas.get(i).get(nombres[j]);
                }
            }
            tablaDatos.setModel(new javax.swing.table.DefaultTableModel(datos, nombres) {
                @Override
                public boolean isCellEditable(int row, int column) { return false; }
            });
            limpiarFormulario();
        } catch (Exception e) {
            mostrarError(e);
        }
    }

    private void cargarFilaSeleccionada() {
        int fila = tablaDatos.getSelectedRow();
        if (fila < 0) return;
        clavesOriginales = new LinkedHashMap<>();
        try {
            List<String> claves = repositorio.obtenerClavesPrimarias((String) selectorTabla.getSelectedItem());
            for (int i = 0; i < columnas.size(); i++) {
                String nombre = columnas.get(i).nombre();
                Object valor = tablaDatos.getValueAt(fila, i);
                JTextField campo = campos.get(nombre);
                if (campo != null) campo.setText(valor == null ? "" : valor.toString());
                if (claves.contains(nombre)) clavesOriginales.put(nombre, valor);
            }
        } catch (Exception e) {
            mostrarError(e);
        }
    }

    private Map<String, Object> leerFormulario(boolean incluirAutoincrementales) throws Exception {
        Map<String, Object> valores = new LinkedHashMap<>();
        for (Columna columna : columnas) {
            if (!incluirAutoincrementales && columna.autoincremental()) continue;
            JTextField campo = campos.get(columna.nombre());
            valores.put(columna.nombre(), repositorio.convertir(campo.getText(), columna));
        }
        return valores;
    }

    private void insertar() {
        try {
            repositorio.insertar((String) selectorTabla.getSelectedItem(), leerFormulario(false));
            cargarDatos();
            JOptionPane.showMessageDialog(this, "Registro guardado correctamente.");
        } catch (Exception e) {
            mostrarError(e);
        }
    }

    private void actualizar() {
        try {
            if (clavesOriginales.isEmpty()) throw new Exception("Seleccioná primero un registro.");
            repositorio.actualizar((String) selectorTabla.getSelectedItem(), leerFormulario(true), clavesOriginales);
            cargarDatos();
            JOptionPane.showMessageDialog(this, "Registro actualizado correctamente.");
        } catch (Exception e) {
            mostrarError(e);
        }
    }

    private void eliminar() {
        try {
            if (clavesOriginales.isEmpty()) throw new Exception("Seleccioná primero un registro.");
            int respuesta = JOptionPane.showConfirmDialog(this, "¿Eliminar el registro seleccionado?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (respuesta != JOptionPane.YES_OPTION) return;
            repositorio.eliminar((String) selectorTabla.getSelectedItem(), clavesOriginales);
            cargarDatos();
            JOptionPane.showMessageDialog(this, "Registro eliminado correctamente.");
        } catch (Exception e) {
            mostrarError(e);
        }
    }

    private void limpiarFormulario() {
        clavesOriginales = new LinkedHashMap<>();
        tablaDatos.clearSelection();
        for (Columna columna : columnas) {
            JTextField campo = campos.get(columna.nombre());
            campo.setText("");
        }
    }

    private void mostrarError(Exception e) {
        JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void iniciar() {
        SwingUtilities.invokeLater(() -> new VentanaPrincipal().setVisible(true));
    }
}
