package Persistencia;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import Abstrac.DAO;
import Modelo.Departamento;
import java.util.ArrayList;
import java.util.List;

public class DepartamentoDAO extends DAO<Departamento>{

    public List<Departamento> obtenerDepartamentos(){
        String sql = "EXEC SP_ObtenerDepartamentos";
        List<Departamento> departamentos = new ArrayList<>();
        try (Connection con =getconection();CallableStatement cs = con.prepareCall(sql)){
            try( ResultSet rs = cs.executeQuery()){
                while (rs.next()) {
                    departamentos.add(parsear(rs));
                }
                return departamentos;
            }
        } catch (Exception e) {
            manejarError("Error al obtener departamentos", e);
            return null;
        }
    }
    @Override
    public Departamento parsear(ResultSet rs) {
        Departamento departamento = new Departamento();
        try {
            departamento.setId(rs.getInt("id"));
            departamento.setNombre(rs.getString("nombre"));
            return departamento;
        } catch (Exception e) {
            manejarError("Error al parsear el Departamento", e);
            return null;
        }
    }
    
}
