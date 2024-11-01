package Persistencia;

import Abstrac.DAO;
import Modelo.Usuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.prefs.Preferences;
import javax.swing.JOptionPane;

public class LoginDAO extends DAO<Usuario> {

    private static final String PREF_USUARIO_KEY = "usuario_";
    private static final String PREF_CANTIDAD_USUARIOS = "cantidad_usuarios";
    private Preferences prefs;

    public LoginDAO() {
        prefs = Preferences.userNodeForPackage(LoginDAO.class);
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
                                rs.getString("nombre"), rs.getString("apellido"), usuario, estado, rs.getString("rol"));
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

    // Método para guardar un usuario recordado
    public void guardarUsuarioRecordado(String usuario) {
        int cantidadUsuarios = prefs.getInt(PREF_CANTIDAD_USUARIOS, 0);

        // Guardar el usuario en una clave con índice único
        prefs.put(PREF_USUARIO_KEY + cantidadUsuarios, usuario);
        prefs.putInt(PREF_CANTIDAD_USUARIOS, cantidadUsuarios + 1);
    }

    // Método para obtener todos los usuarios recordados
    public String[] obtenerUsuariosRecordados() {
        int cantidadUsuarios = prefs.getInt(PREF_CANTIDAD_USUARIOS, 0);
        String[] usuarios = new String[cantidadUsuarios];
        
        // Recuperar cada usuario recordado usando su índice
        for (int i = 0; i < cantidadUsuarios; i++) {
            usuarios[i] = prefs.get(PREF_USUARIO_KEY + i, "");
        }
        return usuarios;
    }

    // Método para limpiar los usuarios recordados
    public void limpiarUsuariosRecordados() {
        int cantidadUsuarios = prefs.getInt(PREF_CANTIDAD_USUARIOS, 0);
        for (int i = 0; i < cantidadUsuarios; i++) {
            prefs.remove(PREF_USUARIO_KEY + i);
        }
        prefs.putInt(PREF_CANTIDAD_USUARIOS, 0);
    }
    protected void mensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Informacion", JOptionPane.INFORMATION_MESSAGE);
    }

}
