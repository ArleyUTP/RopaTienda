package Persistencia;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Abstrac.DAO;
import Modelo.Departamento;
import Modelo.Provincia;

public class ProvinciaDAO extends DAO<Provincia>{

    public List<Provincia> obtenerProvinciasPorDepartamento(Departamento departamento) {
        String sql ="EXEC SP_ObtenerProvinciasPorDepartamento ?";
        List<Provincia> provincias = new ArrayList<>();
        try (Connection con = getconection();CallableStatement cs = con.prepareCall(sql)){
            cs.setInt(1, departamento.getId());
            try (ResultSet rs = cs.executeQuery()){
                while (rs.next()) {
                    Provincia provincia = parsear(rs);
                    provincias.add(provincia);
                }
                return provincias;
            }
        } catch (Exception e) {
            manejarError("Error al obtener provincias por departamento", e);
            return null;
        }
    }
    @Override
    public Provincia parsear(ResultSet rs) {
        Provincia provincia = new Provincia();
        try {
            provincia.setId(rs.getInt("id"));
            provincia.setNombre(rs.getString("nombre"));
            return provincia;
        } catch (Exception e) {
            manejarError("Erro al parsear Provincia", e);
            return null;
        }
    }
    
}
