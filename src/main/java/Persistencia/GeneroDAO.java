package Persistencia;

import java.sql.*;
import java.util.*;

import Abstrac.DAO;
import Modelo.Genero;

public class GeneroDAO extends DAO<Genero>{
    /*Base de datos:
     * CREATE TABLE Generos (
    id BIGINT PRIMARY KEY IDENTITY(1,1),
    nombre NVARCHAR(20) UNIQUE CHECK (nombre IN ('Hombre', 'Niño', 'Mujer', 'Niña'))
);
     */
    public List<Genero> obtenerTodosLosGeneros(){
        List<Genero> generos = listarTodo("SP_ObtenerTodosLosGeneros");
        return generos;
    }

    @Override
    public Genero parsear(ResultSet rs) {
        try {
            Genero genero = new Genero(rs.getString("nombre"));
            genero.setId(rs.getInt("id"));
            return genero;
        } catch (Exception e) {
            manejarError("Error al parsear el resultado de la consulta", e);
        }
        return null;
    }
}
