package Persistencia;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import Abstrac.DAO;
import Modelo.Perfil;
import Modelo.Usuario;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.List;
import javax.imageio.ImageIO;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.coobird.thumbnailator.Thumbnails;

public class UsuarioDAO extends DAO<Usuario> {

    public void crearUsuario(Usuario usuario) throws IOException {
        try (Connection con = getconection(); CallableStatement cs = con.prepareCall("EXEC SP_CrearUsuario ?,?,?,?,?,?,?,?,?,?")) {
            cs.setString(1, usuario.getNombre());
            cs.setString(2, usuario.getApellido());
            cs.setString(3, usuario.getDni());
            cs.setString(4, usuario.getCorreo());
            cs.setString(5, usuario.getUsuario());
            cs.setString(6, usuario.getClave());
            cs.setString(7, usuario.getEstado());
            cs.setString(8, usuario.getRol());
            cs.setDate(9, usuario.getFechaNacimiento());
            Perfil perfil = usuario.getPerfil();
            if (perfil != null && perfil.getRuta() != null) {
                cs.setBytes(10, getByteImagen(perfil.getRuta()));
            } else {
                System.out.println("El perfil es nulo y la ruta es nulal ");
                cs.setNull(10, java.sql.Types.VARBINARY);
            }

            cs.executeUpdate();
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
                    usuario = parsear(rs);
                }
            }
        } catch (SQLException e) {
            manejarError("Error al obtener el usuario", e);
        }
        return usuario;
    }

    public void actualizarUsuario(Usuario usuario) throws IOException {
        try (Connection con = getconection(); CallableStatement cs = con.prepareCall("EXEC SP_ActualizarUsuario ?,?,?,?,?,?,?,?,?,?,?")) {
            cs.setInt(1, usuario.getId());
            cs.setString(2, usuario.getNombre());
            cs.setString(3, usuario.getApellido());
            cs.setString(4, usuario.getDni());
            cs.setString(5, usuario.getCorreo());
            cs.setString(6, usuario.getUsuario());
            cs.setString(7, usuario.getClave());
            cs.setString(8, usuario.getEstado());
            cs.setString(9, usuario.getRol());
            cs.setDate(10, usuario.getFechaNacimiento());
            Perfil perfil = usuario.getPerfil();
            if (perfil != null && perfil.getRuta() != null) {
                cs.setBytes(11, getByteImagen(perfil.getRuta()));
            } else if (perfil != null && perfil.getBytes() != null) {
                cs.setBytes(11, perfil.getBytes());
            } else {
                cs.setNull(11, java.sql.Types.VARBINARY);
            }
            cs.executeUpdate();
            mensaje("Usuario actualizado correctamente");
        } catch (SQLException e) {
            manejarError("Error al actualizar el usuario", e);
        }
    }

    public List<Usuario> obtenerTodosLosUsuarios() {
        return listarTodo("SP_ObtenerTodosLosUsuarios");
    }

    public void eliminar(Usuario usuario) {

    }

    public void buscarUsuarios(JTextField txt_buscador, JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        String usuarioBuscado = txt_buscador.getText();
        try (Connection con = getconection(); CallableStatement cs = con.prepareCall("EXEC SP_BuscarUsuario ?")) {
            cs.setString(1, usuarioBuscado);
            try (ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    Usuario usuario = parsear(rs);
                    model.addRow(new Object[]{
                        false,
                        usuario.getId(),
                        usuario,
                        usuario.getApellido(),
                        usuario.getDni(),
                        usuario.getCorreo(),
                        usuario.getUsuario(),
                        usuario.getRol(),});
                }
            }
        } catch (SQLException e) {
            manejarError("Error al buscar usuarios", e);
        }

        table.setModel(model);
    }

    @Override
    public Usuario parsear(ResultSet rs) {
        Usuario usuario = new Usuario();
        try {
            usuario.setId(rs.getInt("id"));
            usuario.setNombre(rs.getString("nombre"));
            usuario.setApellido(rs.getString("apellido"));
            usuario.setDni(rs.getString("dni"));
            usuario.setCorreo(rs.getString("correo"));
            usuario.setUsuario(rs.getString("usuario"));
            usuario.setClave(rs.getString("clave"));
            usuario.setEstado(rs.getString("estado"));
            usuario.setRol(rs.getString("rol"));
            usuario.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
            usuario.setFechaCreacion(rs.getDate("fecha_creacion"));
            Perfil perfil = new Perfil(rs.getBytes("foto"));
            usuario.setPerfil(perfil);
        } catch (SQLException e) {
            manejarError("Error al parsear el ResultSet", e);
        }
        return usuario;
    }

    private byte[] getByteImagen(File file) throws IOException {
        BufferedImage imagen = Thumbnails.of(file)
                .width(500)
                .outputQuality(0.7f)
                .asBufferedImage();
        ByteArrayOutputStream out = null;
        try {
            out = new ByteArrayOutputStream();
            ImageIO.write(imagen, "jpg", out);
            byte[] data = out.toByteArray();
            return data;
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}
