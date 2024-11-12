package Persistencia;

import java.sql.*;
import java.util.*;

import Abstrac.DAO;
import Modelo.Producto;

public class ProductoDAO extends DAO<Producto>{

    public List<Producto> obtenerTodosLosProductos(){
        List<Producto> productos = listarTodo("ObtenerTodosLosProductos");
        return productos;
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
            producto.setCategoriaId(rs.getInt("categoria_id"));
            producto.setTallaId(rs.getInt("talla_id"));
            producto.setMarcaId(rs.getInt("marca_id"));
            producto.setGeneroId(rs.getInt("genero_id"));
            producto.setStock(rs.getInt("stock"));
            producto.setStockMinimo(rs.getInt("stock_minimo"));
            producto.setPrecioCompra(rs.getDouble("precio_compra"));
            producto.setPrecioVenta(rs.getDouble("precio_venta"));
            producto.setEstadoPromocion(rs.getBoolean("estado_promocion"));
            producto.setFechaCaducidadPromocion(rs.getDate("fecha_caducidad_promocion"));
        } catch (Exception e) {
            manejarError("Error al parcear Producto", e);
        }
        return producto;
    }
}
