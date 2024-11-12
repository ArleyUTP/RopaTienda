package Persistencia;

import java.sql.*;
import java.util.*;

import Abstrac.DAO;
import Modelo.Talla;

public class TallaDAO extends DAO<Talla>{
    
    /*Base de datos:
     * CREATE TABLE Tallas (
    id BIGINT PRIMARY KEY IDENTITY(1,1),
    nombre NVARCHAR(10) UNIQUE CHECK (nombre IN ('S', 'M', 'L', 'XL','XXL'))
);
     */
    public List<Talla> obtenerTodasLasTallas(){
        List<Talla> obtenerTodasLasTallas = listarTodo("ObtenerTodasLasTallas");
        return obtenerTodasLasTallas;
    }

    @Override
    public Talla parsear(ResultSet rs) {
        try {
            Talla talla = new Talla(rs.getString("nombre"));
            talla.setId(rs.getInt("id"));
            return talla;
        } catch (SQLException e) {
            manejarError("Error al parsear talla", e);
        }
        return null;
    }
    
}
