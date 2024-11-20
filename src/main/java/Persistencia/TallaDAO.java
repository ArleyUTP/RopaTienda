package Persistencia;

import java.sql.*;
import java.util.*;


import Abstrac.DAO;
import Modelo.Producto;
import Modelo.Talla;

public class TallaDAO extends DAO<Talla>{
    

    public List<Talla> obtenerTodasLasTallas(){
        List<Talla> obtenerTodasLasTallas = listarTodo("ObtenerTodasLasTallas");
        return obtenerTodasLasTallas;
    }
    
    @Override
    public Talla parsear(ResultSet rs) {
        Talla talla = new Talla();
        try {
            talla.setId(rs.getInt("id"));
            talla.setNombre(rs.getString("nombre"));
        } catch (SQLException e) {
            manejarError("Error al parsear talla", e);
        }
        return talla;
    }
    
    public List<Talla> obtenerTallasPorId(Producto producto){
        int id = producto.getId();
        List<Talla> tallas = new ArrayList<>();
        try (Connection con = getconection();
        CallableStatement cs = con.prepareCall("EXEC SP_ObtenerTallasPorIdProducto ?")){
            cs.setInt(1, id);
            try(ResultSet rs = cs.executeQuery()){
                while (rs.next()) {
                    Talla talla = parsear(rs);
                    tallas.add(talla);
                }
            }
        } catch (Exception e) {
            manejarError("Error al obtener tallas por id", e);
        }
        return tallas;
    }
}
