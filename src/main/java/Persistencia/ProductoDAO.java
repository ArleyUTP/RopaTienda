package Persistencia;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.*;

import Abstrac.DAO;
import Modelo.Producto;

public class ProductoDAO extends DAO<Producto>{

    public List<Producto> obtenerTodosLosProductos(){
        List<Producto> productos = new ArrayList<Producto>();
        String sql = "EXEC ObtenerTodosLosProductos";
        try (Connection con = getconection();
        CallableStatement cs = con.prepareCall(sql);
        ResultSet rs = cs.executeQuery()){
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setId(rs.getInt("id"));
                producto.setCodigo(rs.getString("codigo"));
                producto.setNombre(rs.getString("nombre"));
                producto.setCategoriaId(rs.getInt("categoria"));
                producto.setTallaId(rs.getInt("talla"));
                producto.setGeneroId(rs.getInt("genero_id"));
                producto.setStock(0);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return productos;
    }
    public List<String> obtenerImagenesPorId(Producto producto){
        long id = producto.getId();
        List<String> imagenes = new ArrayList<>();
        return  imagenes;
    }
}
