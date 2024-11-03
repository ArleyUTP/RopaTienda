package Persistencia;

import Abstrac.DAO;
import Modelo.Usuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class LoginDAO extends DAO<Usuario> {


    public LoginDAO() {
    }

    public boolean esUsuarioAdmin(String usuario, String clave) {
        try (Connection con = getconection(); CallableStatement cs = con.prepareCall("EXEC VerificarAdmin ?, ?")) {
            cs.setString(1, usuario);
            cs.setString(2, clave);

            try (ResultSet rs = cs.executeQuery()) {
                if (rs.next()) {
                    String rol = rs.getString("rol");
                    return "admin".equalsIgnoreCase(rol);
                }
            }
        } catch (SQLException e) {
            manejarError("Error al verificar el rol del usuario", e);
        }
        return false;
    }

    public Usuario validarCredenciales(String usuario, String clave) {
        Usuario usuarioAutenticado = null;
        try (Connection con = getconection(); CallableStatement cs = con.prepareCall("EXEC validarCredenciales ?,?")) {
            cs.setString(1, usuario);
            cs.setString(2, clave);
            try (ResultSet rs = cs.executeQuery();) {
                if (rs.next()) {
                    String estado = rs.getString("estado");
                    if ("activo".equalsIgnoreCase(estado)) {
                        usuarioAutenticado = new Usuario(
                                rs.getInt("id"),
                                rs.getString("nombre"), rs.getString("apellido"),
                                usuario, estado, rs.getString("rol"));
                        mensaje("Credenciales correctas");
                    } else {
                        mensaje("El estado de esta cuenta es inactivo");
                    }
                }
            }
        } catch (Exception e) {
            manejarError("Error al validar credenciales", e);
        }
        return usuarioAutenticado;
    }
    public  void agregarUsuarioRecordado(String usuario){
        try(Connection con = getconection();CallableStatement cs = con.prepareCall("EXEC InsertarUsuarioRecordado ?")) {
            cs.setString(1, usuario);
            cs.executeUpdate();
        } catch (SQLException e) {
            manejarError("Error al agregar usuario recordado", e);
        }
    }
    public List<Usuario> obtenerUsuariosRecordados(){
        List<Usuario> usuariosRecordados = new ArrayList<>();
        try (Connection con = getconection();CallableStatement cs = con.prepareCall("EXEC ObtenerUsuariosRecordados")){
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                Usuario usuario = new Usuario();
                usuario.setUsuario(rs.getString("usuario"));
                usuariosRecordados.add(usuario);
            }
        } catch (Exception e) {
            manejarError("Error al obtener usuarios recordados", e);
        }
        return usuariosRecordados;
    }
    public void eliminarUsuarioRecordado(String usuario){
        try(Connection con = getconection();CallableStatement cs = con.prepareCall("EXEC EliminarUsuarioRecordado ?")) {
            cs.setString(1, usuario);
            cs.executeUpdate();
        } catch (SQLException e) {
            manejarError("Error al eliminar usuario recordado", e);
        }
    }
    protected void mensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Informacion", JOptionPane.INFORMATION_MESSAGE);
    }

}
