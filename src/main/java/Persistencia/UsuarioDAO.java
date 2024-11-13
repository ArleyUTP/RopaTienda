package Persistencia;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import Abstrac.DAO;
import Modelo.Usuario;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class UsuarioDAO extends DAO<Usuario> {

    public void crearUsuario(Usuario usuario) {
        System.out.println("El parametro pasado de usuario para crear usuario es: "+usuario.toString()
        );
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
            int cant = cs.executeUpdate();
            System.out.println("El ejecutado es: "+cant);
            mensaje("Usuario Creado");
        } catch (SQLException e) {
            manejarError("Error al registrar usuario", e);
        }
    }

    public Usuario obtenerUsuarioPorId(int id) {
        Usuario usuario = null;
        try (Connection con = getconection(); CallableStatement cs = con.prepareCall("EXEC SP_ObtenerUsuarioPorId ?")) {
            cs.setInt(1, id);
            try (ResultSet rs = cs.executeQuery()) {
                if (rs.next()) {
                    usuario = new Usuario();
                    usuario.setNombre( rs.getString("nombre"));
                    usuario.setApellido(rs.getString("apellido"));
                    usuario.setDni(rs.getString("dni"));
                    usuario.setCorreo(rs.getString("correo"));
                    usuario.setUsuario(rs.getString("usuario"));
                    usuario.setClave(rs.getString("clave"));
                    usuario.setEstado(rs.getString("estado"));
                    usuario.setRol(rs.getString("rol"));
                    usuario.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                    usuario.setFoto(rs.getString("foto"));
                    usuario.setid(rs.getInt("id"));
                    usuario.setFechaCreacion(rs.getDate("fecha_creacion"));
                }
            }
        } catch (SQLException e) {
            manejarError("Error al obtener el usuario", e);
        }
        return usuario;
    }

    public void actualizarUsuario(Usuario usuario) {
        try (Connection con = getconection(); CallableStatement cs = con.prepareCall("EXEC SP_ActualizarUsuario ?,?,?,?,?,?,?,?,?,?,?")) {
            cs.setInt(1, usuario.getid());
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
        List<Usuario> usuarios = listarTodo("SP_ObtenerTodosLosUsuarios");
        return usuarios;
    }


    public void eliminar(Usuario usuario) {
       
    }

    public void buscarUsuarios(JTextField txt_buscador, JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Borra todas las filas actuales
        String usuarioBuscado = txt_buscador.getText();
        
        try (Connection con = getconection();
             CallableStatement cs = con.prepareCall("EXEC BuscarUsuario ?")) {
            cs.setString(1, usuarioBuscado);
            try (ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    Usuario usuario = new Usuario(); // Crear un nuevo objeto Usuario para cada fila
                    usuario.setid(rs.getInt("id"));
                    usuario.setNombre(rs.getString("nombre"));
                    usuario.setApellido(rs.getString("apellido"));
                    usuario.setDni(rs.getString("dni"));
                    usuario.setCorreo(rs.getString("correo"));
                    usuario.setUsuario(rs.getString("usuario"));
                    usuario.setEstado(rs.getString("estado"));
                    usuario.setRol(rs.getString("rol"));
                    usuario.setFoto(rs.getString("foto"));
                    
                    model.addRow(new Object[]{
                        false,
                        usuario.getid(),
                        usuario, // Cambié 'usuario' por 'usuario.getNombre()'
                        usuario.getApellido(),
                        usuario.getDni(),
                        usuario.getCorreo(),
                        usuario.getUsuario(),
                        usuario.getRol()
                    });
                }
            }
        } catch (SQLException e) {
            manejarError("Error al buscar usuarios", e); // Cambiado para usar manejarError
        }
        
        table.setModel(model);
    }

    @Override
    public Usuario parsear(ResultSet rs) {
        Usuario usuario = new Usuario();
        try {
            usuario.setid(rs.getInt("id"));
            usuario.setNombre(rs.getString("nombre"));
            usuario.setApellido(rs.getString("apellido"));
            usuario.setDni(rs.getString("dni"));
            usuario.setCorreo(rs.getString("correo"));
            usuario.setUsuario(rs.getString("usuario"));
            usuario.setEstado(rs.getString("estado"));
            usuario.setRol(rs.getString("rol"));
            usuario.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
            usuario.setFoto(rs.getString("foto"));
            usuario.setFechaCreacion(rs.getDate("fecha_creacion"));
            return usuario;
        } catch (SQLException e) {
            manejarError("Error al parsear el ResultSet", e);
        }
        return null;
    }
}
