package Abstrac;

import java.sql.*;
import javax.swing.JOptionPane;

public class DAO<T> {

    protected Connection getconection() {
        String url = "jdbc:sqlserver://localhost:1433;database=TiendaDeRopas;encrypt=false";
        String username = "sa";
        String password = "12345";
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            manejarError("Error al conectar a la base de datos", e);
        }
        return null;
    }

    protected void manejarError(String mensaje, Exception e) {
        System.err.println(mensaje + " : " + e.getMessage());
    }
        protected void mensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Informacion", JOptionPane.INFORMATION_MESSAGE);
    }
}
