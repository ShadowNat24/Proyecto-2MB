package uy.edu.utu.f1.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/** Conexión centralizada a la base MySQL local del proyecto. */
public final class ConexionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/f1_gestion?useSSL=false&serverTimezone=UTC";
    private static final String USUARIO = "root";
    private static final String CLAVE = "";

    private ConexionBD() {
    }

    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CLAVE);
    }

    public static boolean probarConexion() {
        try (Connection ignored = obtenerConexion()) {
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}
