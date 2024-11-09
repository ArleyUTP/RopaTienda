package Persistencia;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import Abstrac.DAO;
import Modelo.Usuario;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO extends DAO<Usuario> {

    public void crearUsuario(Usuario usuario) {
        try (Connection con = getconection(); CallableStatement cs = con.prepareCall("EXEC CrearUsuario ?,?,?,?,?,?,?,?,?,?")) {

            cs.setString(1, usuario.getNombre());
            cs.setString(2, usuario.getApellido());
            cs.setString(3, usuario.getDni());
            cs.setString(4, usuario.getCorreo());
            cs.setString(5, usuario.getUsuario());
            cs.setString(6, usuario.getClave());
            cs.setString(7, usuario.getEstado());
            cs.setString(8, usuario.getRol());
            cs.setDate(9, usuario.getFechaNacimiento());
            cs.setString(10, usuario.getFoto());
            cs.executeUpdate();
            mensaje("Usuario Creado");
        } catch (SQLException e) {
            manejarError("Error al registrar usuario", e);
        }
    }

    public Usuario obtenerUsuarioPorId(int id) {
        Usuario usuario = null;
        try (Connection con = getconection(); CallableStatement cs = con.prepareCall("EXEC ObtenerUsuarioPorId ?")) {
            cs.setInt(1, id);
            try (ResultSet rs = cs.executeQuery()) {
                if (rs.next()) {
                    usuario = new Usuario(
                            rs.getString("nombre"),
                            rs.getString("apellido"),
                            rs.getString("dni"),
                            rs.getString("correo"),
                            rs.getString("usuario"),
                            rs.getString("clave"),
                            rs.getString("estado"),
                            rs.getString("rol"),
                            rs.getDate("fecha_nacimiento"),
                            rs.getString("foto")
                    );
                    usuario.setIdUsuario(rs.getInt("id"));
                    usuario.setFechaCreacion(rs.getDate("fecha_creacion"));
                }
            }

        } catch (SQLException e) {
            manejarError("Error al obtener el usuario", e);
        }
        return usuario;
    }

    public void actualizarUsuario(Usuario usuario) {
        try (Connection con = getconection(); CallableStatement cs = con.prepareCall("EXEC ActualizarUsuario ?,?,?,?,?,?,?,?,?,?,?")) {
            cs.setInt(1, usuario.getIdUsuario());
            cs.setString(2, usuario.getNombre());
            cs.setString(3, usuario.getApellido());
            cs.setString(4, usuario.getDni());
            cs.setString(5, usuario.getCorreo());
            cs.setString(6, usuario.getUsuario());
            cs.setString(7, usuario.getClave());
            cs.setString(8, usuario.getEstado());
            cs.setString(9, usuario.getRol());
            System.out.println("El valor de la fecha al actulizar el usuario es: " + usuario.getFechaNacimiento());
            cs.setDate(10, usuario.getFechaNacimiento()); // Conversión correcta de fecha
            System.out.println("El valor de la ruta de la foto en ActualizarUsuario es: " + usuario.getFoto());
            cs.setString(11, usuario.getFoto()); // Ruta de la imagen
            cs.executeUpdate();
            mensaje("Usuario actualizado correctamente");
        } catch (SQLException e) {
            manejarError("Error al actualizar el usuario", e);
        }
    }

    public List<Usuario> obtenerTodosLosUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();

        String sql = "EXEC ObtenerTodosLosUsuarios"; // Llamada al procedimiento almacenado
        try (Connection con = getconection(); CallableStatement cs = con.prepareCall(sql); ResultSet rs = cs.executeQuery()) {
            while (rs.next()) {
                Usuario usuario = new Usuario(
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("dni"),
                        rs.getString("correo"),
                        rs.getString("usuario"),
                        null, // Clave no se necesita para mostrar en la tabla
                        rs.getString("estado"),
                        rs.getString("rol"),
                        rs.getDate("fecha_nacimiento"),
                        rs.getString("foto")
                );
                usuario.setIdUsuario(rs.getInt("id"));
                usuario.setFechaCreacion(rs.getDate("fecha_creacion"));
                usuarios.add(usuario);
            }

        } catch (SQLException e) {
            manejarError("Error al obtener los usuarios", e);
        }
        return usuarios;
    }
    public void eliminar(int id){
        
    }
}
