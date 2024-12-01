package Persistencia;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Abstrac.DAO;
import Modelo.ColorRopa;
import Modelo.FotosInventario;
import Modelo.Perfil;
import Modelo.Producto;
import Modelo.ProductoInventario;
import Modelo.Talla;
import java.sql.SQLException;

public class ProductoInventarioDAO extends DAO<ProductoInventario> {

    public boolean crearProductoInventario(ProductoInventario productoInventario) {
        String sql = "EXEC SP_CrearVariantes ?, ?, ?, ?, ?";
        try (Connection con = getconection(); CallableStatement cs = con.prepareCall(sql)) {
            cs.setInt(1, productoInventario.getProducto().getId());
            cs.setInt(2, productoInventario.getTalla().getId());
            cs.setInt(3, productoInventario.getColorRopa().getId());
            cs.setInt(4, productoInventario.getStock());
            cs.registerOutParameter(5, java.sql.Types.BIGINT); // Registro del parámetro de salida
            cs.executeUpdate();
            int idVarianteIngresada = cs.getInt(5);
            FotosInventarioDAO fotosInventarioDAO = new FotosInventarioDAO();
            fotosInventarioDAO.crearFotosInvetario(idVarianteIngresada, productoInventario.getFotos());
            return true;
        } catch (SQLException e) {
            manejarError("Error al crear Variante", e);
            return false;
        }
    }

    public boolean actualizarProductoInventario(ProductoInventario productoInventario) {
        String sql = "EXEC SP_ActualizarVariante ?, ?, ?, ?, ?";
        try (Connection con = getconection(); CallableStatement cs = con.prepareCall(sql)) {
            cs.setInt(1, productoInventario.getIdVariante());
            cs.setInt(2, productoInventario.getProducto().getId());
            cs.setInt(3, productoInventario.getTalla().getId());
            cs.setInt(4, productoInventario.getColorRopa().getId());
            cs.setInt(5, productoInventario.getStock());
            cs.executeUpdate();
            return true;
        } catch (SQLException e) {
            manejarError("Error al actualizar Producto Variante", e);
            return false;
        }
    }

    public List<ProductoInventario> obtenerVariantePorIdProducto(Producto producto) {
        List<ProductoInventario> productosInventarios = new ArrayList<>();
        int idProducto = producto.getId();
        try (Connection con = getconection(); CallableStatement cs = con.prepareCall("EXEC SP_ObtenerVariantesPorIdProducto ?")) {
            cs.setInt(1, idProducto);
            try (ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    ProductoInventario productoInventario = parsear(rs);
                    productosInventarios.add(productoInventario);
                }
            }
        } catch (Exception e) {
            manejarError("Error al obtner lista de productosInventario", e);
        }
        return productosInventarios;
    }

    @Override
    public ProductoInventario parsear(ResultSet rs) {
        ProductoInventario productoInventario = new ProductoInventario();
        try {
            productoInventario.setIdVariante(rs.getInt("id"));
            Producto producto = new Producto();
            producto.setId(rs.getInt("producto_id"));
            productoInventario.setProducto(producto);
            Talla talla = new Talla();
            talla.setId(rs.getInt("talla_id"));
            talla.setNombre(rs.getString("talla_nombre"));
            productoInventario.setTalla(talla);
            ColorRopa colorRopa = new ColorRopa();
            colorRopa.setId(rs.getInt("color_id"));
            colorRopa.setNombre(rs.getString("color_nombre"));
            colorRopa.setCodigo_hexdecimal(rs.getString("valor_hex"));
            productoInventario.setColorRopa(colorRopa);
            productoInventario.setStock(rs.getInt("cantidad"));
            FotosInventarioDAO fotosInventarioDAO = new FotosInventarioDAO();
            List<Perfil> fotos = new ArrayList<>();
            List<FotosInventario> fotosInventarios = fotosInventarioDAO.obtenerFotosInventarioPorIdInventario(productoInventario);
            fotosInventarios.forEach(fotosI -> {
                fotos.add(fotosI.getImagen());
            });
            productoInventario.setFotos(fotos);
        } catch (Exception e) {
            manejarError("Error al parsea ProductoInventario", e);
        }
        return productoInventario;
    }
}
