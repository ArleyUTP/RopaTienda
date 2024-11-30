package Persistencia;

import java.sql.ResultSet;
import java.util.List;

import Abstrac.DAO;
import Modelo.FotosInventario;
import Modelo.Perfil;
import Modelo.ProductoInventario;

public class FotosInventarioDAO extends DAO<FotosInventario> {
    
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
