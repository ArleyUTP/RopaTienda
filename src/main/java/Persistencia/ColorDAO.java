package Persistencia;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Abstrac.DAO;
import Modelo.ColorRopa;
import Modelo.Producto;

public class ColorDAO extends DAO<ColorRopa>{

    
    public List<ColorRopa> obtenerColoresPorId(Producto producto){
        int id = producto.getId();
        List<ColorRopa> colores = new ArrayList<>();
        try (Connection con = getconection();
        CallableStatement cs = con.prepareCall("EXEC SP_ObtenerColoresPorIdProducto ?")){
            cs.setInt(1, id);
            try (ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    ColorRopa color = parsear(rs);
                    colores.add(color);
                }
            }          
        } catch (Exception e) {
            manejarError("Error al obtener colores por id", e);
        }
        return colores;
    }
    @Override
    public ColorRopa parsear(ResultSet rs) {
        ColorRopa color = new ColorRopa();
        try {
            color.setId(rs.getInt("id"));
            color.setNombre(rs.getString("nombre"));
            color.setCodigo_hexdecimal(rs.getString("valor_hex"));
        } catch (Exception e) {
            manejarError("Error al parsear el Color Ropa", e);
        }
        return color;
    }
    
}
