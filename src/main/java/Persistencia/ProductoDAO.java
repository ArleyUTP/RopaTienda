package Persistencia;

import java.sql.*;
import java.util.*;

import Abstrac.DAO;
import Modelo.Producto;
import Modelo.Usuario;

public class ProductoDAO extends DAO<Producto>{

    public List<Producto> obtenerTodosLosProductos(){
        List<Producto> productos = listarTodo("SP_ObtenerTodosLosProductos");
        return productos;
    }
    
    
    public void eliminar(Producto producto) {
       
    }
    
    public List<String> obtenerImagenesPorId(Producto producto){
        long id = producto.getId();
        List<String> imagenes = new ArrayList<>();
        return  imagenes;
    }

    @Override
    public Producto parsear(ResultSet rs) {
        Producto producto = new Producto();
        try {
            producto.setId(rs.getInt("id"));
            producto.setCodigo(rs.getString("codigo"));
            producto.setNombre(rs.getString("nombre"));
            producto.setIdCategoria(rs.getLong("categoria_id"));
            producto.setStock(rs.getInt("stock"));
            producto.setStockMinimo(rs.getInt("stockMinimo"));
            producto.setPrecioCompra(rs.getDouble("precio_compra"));
            producto.setPrecioVenta(rs.getDouble("precio_venta"));
            producto.setEstadoPromocion(rs.getBoolean("estado_promocion"));
            producto.setFechaCaducidadPromoción(rs.getDate("fecha_caducidad_promocion"));
            producto.setFoto(rs.getString("foto"));
        } catch (SQLException e) {
            manejarError("Error al parcear Producto", e);
        }
        return producto;
    }


    public Producto obtenerProductoPorId(int productId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerProductoPorId'");
    }
    
    
}
