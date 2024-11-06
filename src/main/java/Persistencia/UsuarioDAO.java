package Persistencia;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import Abstrac.DAO;
import Modelo.Usuario;

public class UsuarioDAO extends DAO<Usuario>{
    
public void crearUsuario(Usuario usuario) {
    try (Connection con = getconection();
         CallableStatement cs = con.prepareCall("EXEC CrearUsuario ?,?,?,?,?,?,?,?")) {

        cs.setString(1, usuario.getNombre());
        cs.setString(2, usuario.getApellido());
        cs.setString(3, usuario.getDni());
        cs.setString(4, usuario.getCorreo());
        cs.setString(5, usuario.getEstado());
        cs.setString(6, usuario.getRol());
        cs.setDate(7, new java.sql.Date(usuario.getFechaNacimiento().getTime())); // Conversión correcta de fecha
        cs.setString(8, usuario.getFoto());  // Almacena la ruta de la imagen en la columna de la base de datos

        cs.executeUpdate();
        mensaje("Usuario Creado");

    } catch (SQLException e) {
        manejarError("Error al registrar usuario", e);
    }
}

}
