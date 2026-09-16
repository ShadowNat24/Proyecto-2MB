package uy.edu.utu.f1.persistencia;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/** Persistencia sencilla y reutilizable para las tablas del esquema F1. */
public class RepositorioGenerico {
    private static final Set<String> TABLAS_PERMITIDAS = Set.of(
            "proveedor", "escuderia", "piloto", "auto", "circuito",
            "temporada", "gran_premio", "participacion_temporada", "resultado"
    );

    public List<String> obtenerTablas() {
        return new ArrayList<>(TABLAS_PERMITIDAS);
    }

    public List<Columna> obtenerColumnas(String tabla) throws SQLException {
        validarTabla(tabla);
        List<Columna> columnas = new ArrayList<>();
        try (Connection cn = ConexionBD.obtenerConexion()) {
            DatabaseMetaData meta = cn.getMetaData();
            try (ResultSet rs = meta.getColumns(cn.getCatalog(), null, tabla, null)) {
                while (rs.next()) {
                    columnas.add(new Columna(
                            rs.getString("COLUMN_NAME"),
                            rs.getInt("DATA_TYPE"),
                            rs.getString("TYPE_NAME"),
                            "YES".equalsIgnoreCase(rs.getString("IS_NULLABLE")),
                            "YES".equalsIgnoreCase(rs.getString("IS_AUTOINCREMENT"))
                    ));
                }
            }
        }
        return columnas;
    }

    public List<String> obtenerClavesPrimarias(String tabla) throws SQLException {
        validarTabla(tabla);
        List<String> claves = new ArrayList<>();
        try (Connection cn = ConexionBD.obtenerConexion()) {
            DatabaseMetaData meta = cn.getMetaData();
            try (ResultSet rs = meta.getPrimaryKeys(cn.getCatalog(), null, tabla)) {
                while (rs.next()) {
                    claves.add(rs.getString("COLUMN_NAME"));
                }
            }
        }
        return claves;
    }

    public List<Map<String, Object>> listar(String tabla) throws SQLException {
        validarTabla(tabla);
        List<Map<String, Object>> filas = new ArrayList<>();
        String sql = "SELECT * FROM " + tabla;
        try (Connection cn = ConexionBD.obtenerConexion();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            ResultSetMetaData meta = rs.getMetaData();
            while (rs.next()) {
                Map<String, Object> fila = new LinkedHashMap<>();
                for (int i = 1; i <= meta.getColumnCount(); i++) {
                    fila.put(meta.getColumnName(i), rs.getObject(i));
                }
                filas.add(fila);
            }
        }
        return filas;
    }

    public void insertar(String tabla, Map<String, Object> valores) throws SQLException {
        validarTabla(tabla);
        if (valores.isEmpty()) {
            throw new SQLException("No hay datos para insertar.");
        }
        String columnas = String.join(", ", valores.keySet());
        String signos = String.join(", ", java.util.Collections.nCopies(valores.size(), "?"));
        String sql = "INSERT INTO " + tabla + " (" + columnas + ") VALUES (" + signos + ")";
        ejecutar(sql, valores.values().toArray());
    }

    public void actualizar(String tabla, Map<String, Object> valores, Map<String, Object> claves) throws SQLException {
        validarTabla(tabla);
        if (claves.isEmpty()) {
            throw new SQLException("La tabla no tiene una clave primaria identificable.");
        }
        StringBuilder sql = new StringBuilder("UPDATE ").append(tabla).append(" SET ");
        List<Object> parametros = new ArrayList<>();
        boolean primero = true;
        for (Map.Entry<String, Object> entrada : valores.entrySet()) {
            if (claves.containsKey(entrada.getKey())) {
                continue;
            }
            if (!primero) sql.append(", ");
            sql.append(entrada.getKey()).append(" = ?");
            parametros.add(entrada.getValue());
            primero = false;
        }
        if (primero) {
            throw new SQLException("No hay campos modificables.");
        }
        sql.append(" WHERE ");
        primero = true;
        for (Map.Entry<String, Object> entrada : claves.entrySet()) {
            if (!primero) sql.append(" AND ");
            sql.append(entrada.getKey()).append(" = ?");
            parametros.add(entrada.getValue());
            primero = false;
        }
        ejecutar(sql.toString(), parametros.toArray());
    }

    public void eliminar(String tabla, Map<String, Object> claves) throws SQLException {
        validarTabla(tabla);
        if (claves.isEmpty()) {
            throw new SQLException("La tabla no tiene una clave primaria identificable.");
        }
        StringBuilder sql = new StringBuilder("DELETE FROM ").append(tabla).append(" WHERE ");
        List<Object> parametros = new ArrayList<>();
        boolean primero = true;
        for (Map.Entry<String, Object> entrada : claves.entrySet()) {
            if (!primero) sql.append(" AND ");
            sql.append(entrada.getKey()).append(" = ?");
            parametros.add(entrada.getValue());
            primero = false;
        }
        ejecutar(sql.toString(), parametros.toArray());
    }

    public Object convertir(String texto, Columna columna) throws SQLException {
        if (texto == null || texto.isBlank()) {
            return null;
        }
        try {
            return switch (columna.tipoSql()) {
                case Types.INTEGER, Types.SMALLINT, Types.TINYINT -> Integer.valueOf(texto.trim());
                case Types.BIGINT -> Long.valueOf(texto.trim());
                case Types.DECIMAL, Types.NUMERIC -> new BigDecimal(texto.trim());
                case Types.DOUBLE, Types.FLOAT, Types.REAL -> Double.valueOf(texto.trim());
                case Types.DATE -> java.sql.Date.valueOf(LocalDate.parse(texto.trim()));
                case Types.BOOLEAN, Types.BIT -> Boolean.valueOf(texto.trim());
                default -> texto;
            };
        } catch (RuntimeException e) {
            throw new SQLException("Valor inválido para " + columna.nombre() + ": " + texto, e);
        }
    }

    private void ejecutar(String sql, Object[] parametros) throws SQLException {
        try (Connection cn = ConexionBD.obtenerConexion();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            for (int i = 0; i < parametros.length; i++) {
                ps.setObject(i + 1, parametros[i]);
            }
            ps.executeUpdate();
        }
    }

    private void validarTabla(String tabla) throws SQLException {
        if (!TABLAS_PERMITIDAS.contains(tabla)) {
            throw new SQLException("Tabla no permitida: " + tabla);
        }
    }

    public record Columna(String nombre, int tipoSql, String tipoTexto, boolean aceptaNulo, boolean autoincremental) {
    }
}
