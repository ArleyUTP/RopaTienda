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
        Long id = producto.getId();
        List<ColorRopa> colores = new ArrayList<>();
        try (Connection con = getconection();
        CallableStatement cs = con.prepareCall("EXEC SP_BuscarColoresPorId ?")){
            cs.setLong(1, id);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                ColorRopa color = new ColorRopa(rs.getString("nombre"),rs.getString("codigo_hexdecimal"));
                color.setId(rs.getInt("id"));
                colores.add(color);
            }            
        } catch (Exception e) {
            manejarError("Error al obtener colores por id", e);
        }
        return colores;
    }
    @Override
    public ColorRopa parsear(ResultSet rs) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'parsear'");
    }
    
}
