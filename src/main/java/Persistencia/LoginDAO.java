package Persistencia;

import Abstrac.DAO;
import Modelo.Perfil;
import Modelo.Usuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextField;

public class LoginDAO extends DAO<Usuario> {

    public LoginDAO() {
    }

    public boolean esUsuarioAdmin(String usuario, String clave) {
        try (Connection con = getconection(); CallableStatement cs = con.prepareCall("EXEC SP_VerificarAdmin ?, ?")) {
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
        try (Connection con = getconection(); CallableStatement cs = con.prepareCall("EXEC SP_validarCredenciales ?,?")) {
            cs.setString(1, usuario);
            cs.setString(2, clave);
            try (ResultSet rs = cs.executeQuery();) {
                if (rs.next()) {
                    String estado = rs.getString("estado");
                    if ("activo".equalsIgnoreCase(estado)) {
                        usuarioAutenticado = parsear(rs);
                    } else {
                        mensajeDeError("El estado de esta cuenta es inactivo");
                    }
                }
            }
        } catch (Exception e) {
            manejarError("Error al validar credenciales", e);
        }
        return usuarioAutenticado;
    }

    public void agregarUsuarioRecordado(String usuario) {
        try (Connection con = getconection(); CallableStatement cs = con.prepareCall("EXEC SP_InsertarUsuarioRecordado ?")) {
            cs.setString(1, usuario);
            cs.executeUpdate();
        } catch (SQLException e) {
            manejarError("Error al agregar usuario recordado", e);
        }
    }

    public List<Usuario> obtenerUsuariosRecordados() {
        List<Usuario> usuariosRecordados = new ArrayList<>();
        try (Connection con = getconection(); CallableStatement cs = con.prepareCall("EXEC SP_ObtenerUsuariosRecordados")) {
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setUsuario(rs.getString("usuario"));
                usuariosRecordados.add(usuario);
            }
        } catch (Exception e) {
            manejarError("Error al obtener usuarios recordados", e);
        }
        return usuariosRecordados;
    }

    public void eliminarUsuarioRecordado(String usuario) {
        try (Connection con = getconection(); CallableStatement cs = con.prepareCall("EXEC SP_EliminarUsuarioRecordado ?")) {
            cs.setString(1, usuario);
            cs.executeUpdate();
        } catch (SQLException e) {
            manejarError("Error al eliminar usuario recordado", e);
        }
    }

    @Override
    public Usuario parsear(ResultSet rs) {
        Usuario usuario = new Usuario();
        try {
            usuario.setId(rs.getInt("id"));
            usuario.setNombre(rs.getString("nombre"));
            usuario.setApellido(rs.getString("apellido"));
            usuario.setCorreo(rs.getString("correo"));
            usuario.setEstado(rs.getString("estado"));
            usuario.setRol(rs.getString("rol"));
            Perfil perfil = new Perfil(rs.getBytes("foto"));
            usuario.setPerfil(perfil);
            System.out.println("El pasarseo bota: " + usuario.toString());
        } catch (SQLException e) {
            manejarError("Error al parsear el ResultSet", e);
        }
        return usuario;
    }

    public String desactivarCuenta(String usuario) {
        String mensaje = null;
        try (Connection con = getconection(); CallableStatement cs = con.prepareCall("EXEC  SP_DescativarCuentaTemporalmente ?,? ")) {
            cs.setString(1, usuario); // Usuario
            cs.registerOutParameter(2, java.sql.Types.NVARCHAR); // Mensaje de salida
            cs.executeUpdate();
            mensaje = cs.getString(2);
        } catch (SQLException e) {
            manejarError("Error al desactivar cuenta temporalmente", e);
        }
        return mensaje; // Retorna el mensaje
    }

    public void reactivarCuenta(String usuario) {
        try (Connection con = getconection(); CallableStatement cs = con.prepareCall("EXEC SP_ReactivarCuenta ?")) {

            cs.setString(1, usuario);
            int filasAfectadas = cs.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("La cuenta ha sido reactivada correctamente.");
            } else {
            }

        } catch (SQLException e) {
            manejarError("Error al reactivar la cuenta", e);
        }
    }

    public boolean validarIngreso(JTextField... campos) {
        if (ValidarCamposVacios(campos[0], campos[0].getToolTipText())) {
            return false;
        }
        return true;
    }
}
