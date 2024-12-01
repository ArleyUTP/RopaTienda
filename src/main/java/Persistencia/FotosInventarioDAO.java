package Persistencia;

import java.sql.ResultSet;
import java.util.List;

import Abstrac.DAO;
import Modelo.FotosInventario;
import Modelo.Perfil;
import Modelo.ProductoInventario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class FotosInventarioDAO extends DAO<FotosInventario> {

    public void crearFotosInvetario(int idVariante, List<Perfil> imagenes) {
        String sql = "EXEC SP_CrearImagenesInventario ?, ?";
        imagenes.forEach(foto -> {
            try (Connection con = getconection(); CallableStatement cs = con.prepareCall(sql)) {
                byte[] imgBytes = foto.getBytes();
                cs.setInt(1, idVariante);
                cs.setBytes(2, imgBytes);
                cs.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace(); // Manejo de errores individual para cada foto
            }
        });
    }

    public boolean crearFotoInventario(FotosInventario fotosInventario) {
        String sql = "EXEC SP_CrearFotoInventario ?,?";
        try (Connection con = getconection(); CallableStatement cs = con.prepareCall(sql)) {
            cs.setInt(1, fotosInventario.getIdInventario());
            cs.setBytes(2, fotosInventario.getImagen().getBytes());
            cs.executeUpdate();
            return true;
        } catch (SQLException e) {
            manejarError("Error al crear foto inventatio", e);
            return false;
        }
    }

    public boolean actualizarFotoInventario(FotosInventario fotosInventario) {
        String sql = "EXEC SP_ActualizarFotoInventario ?,?,?";
        try (Connection con = getconection(); CallableStatement cs = con.prepareCall(sql)) {
            cs.setInt(1, fotosInventario.getId());
            cs.setInt(2, fotosInventario.getIdInventario());
            cs.setBytes(3, fotosInventario.getImagen().getBytes());
            cs.executeUpdate();
            return true;
        } catch (SQLException e) {
            manejarError("Error al actualizar foto inventario", e);
            return false;
        }
    }

    public boolean eliminarFotoInventario(Perfil fotoSeleccionada) {
        String sql = "EXEC SP_EliminarFotoInventario ?";
        try (Connection con = getconection(); CallableStatement cs = con.prepareCall(sql)) {
            cs.setInt(1, fotoSeleccionada.getId());
            cs.executeUpdate();
            return true;
        } catch (SQLException e) {
            manejarError("Error al eliminar foto inventario", e);
            return false;
        }
    }

    public List<FotosInventario> obtenerFotosInventarioPorIdInventario(ProductoInventario productoInventario) {
        int idInventario = productoInventario.getIdVariante();
        List<FotosInventario> fotos = listarPorId(idInventario, "SP_ObtenerFotosInventarioPorIdInventario");
        return fotos;
    }

    @Override
    public FotosInventario parsear(ResultSet rs) {
        FotosInventario foto = new FotosInventario();
        try {
            foto.setId(rs.getInt("id"));
            foto.setIdInventario(rs.getInt("inventario_id"));
            Perfil imagen = new Perfil(rs.getBytes("foto"));
            imagen.setId(rs.getInt("id"));
            foto.setImagen(imagen);
        } catch (Exception e) {
            manejarError("Error al parse fotos Inventario", e);
        }
        return foto;
    }

}
