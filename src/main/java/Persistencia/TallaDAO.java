package Persistencia;

import java.sql.*;
import java.util.*;


import Abstrac.DAO;
import Modelo.Producto;
import Modelo.Talla;

public class TallaDAO extends DAO<Talla>{
    

    public List<Talla> obtenerTodasLastallas(){
        List<Talla> tallas = listarTodo("SP_ObtenerTodasLasTallas");
        return tallas;
    }
    
    @Override
    public Talla parsear(ResultSet rs) {
        try {
            Talla talla = new Talla();
            talla.setId(rs.getInt("id"));
            talla.setNombre(rs.getString("talla_nombre"));
            return talla;
        } catch (SQLException e) {
            manejarError("Error al parsear talla", e);
        }
        return null;
    }
    
    public List<Talla> obtenertallasPorId(Producto producto){
        int id = producto.getId();
        List<Talla> tallas = new ArrayList<>();
        try (Connection con = getconection();
        CallableStatement cs = con.prepareCall("EXEC SP_ObtenertallasPorIdProducto ?")){
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
