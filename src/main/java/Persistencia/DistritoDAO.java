package Persistencia;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.*;

import Abstrac.DAO;
import Modelo.Distrito;
import Modelo.Provincia;

public class DistritoDAO extends DAO<Distrito>{

    public List<Distrito> obtenerDistritosPorProvincia(Provincia provincia) {
        String sql = "EXEC SP_ObtenerDistritosPorProvincia ?";
        List<Distrito> distritos = new ArrayList<>();
        try (Connection con = getconection();CallableStatement cs = con.prepareCall(sql)){
            cs.setInt(1, provincia.getId());
            try(ResultSet rs = cs.executeQuery()){
                while(rs.next()){
                    Distrito distrito = parsear(rs);
                    distritos.add(distrito);
                }
                return distritos;
            }
        } catch (Exception e) {
            manejarError("Error al obtener los distritos por provincia", e);
            return null;
        }
    }
    @Override
    public Distrito parsear(ResultSet rs) {
        Distrito distrito = new Distrito();
        try {
            distrito.setId(rs.getInt("id"));
            distrito.setNombre(rs.getString("nombre"));
            return distrito;
        } catch (Exception e) {
            manejarError("Error al parsear el Distrito", e);
            return null;
        }
    }
    
}
