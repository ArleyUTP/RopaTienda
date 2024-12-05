package Persistencia;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Abstrac.DAO;
import Modelo.Departamento;

public class DepartamentoDAO extends DAO<Departamento>{

//    public List<Departamento> obtenerDepartamentos(){
//        List<Departamento> departamentos = new ArrayList<>();
//    }
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
