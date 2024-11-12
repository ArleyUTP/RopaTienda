package Persistencia;

import java.sql.*;
import java.util.*;

import Abstrac.DAO;
import Modelo.Categoria;

public class CategoriaDAO extends DAO<Categoria>{
    /*Base de datos:
     * CREATE TABLE Categorias (
    id BIGINT PRIMARY KEY IDENTITY(1,1),
    nombre NVARCHAR(50) UNIQUE
);
     */
    public List<Categoria> obtenerTodasLasCategorias(){
        List<Categoria> categorias = listarTodo("SP_ObtenerTodasLasCategorias");
        return categorias;
    }

    @Override
    public Categoria parsear(ResultSet rs) {
        try {
            Categoria categoria = new Categoria(rs.getString("nombre"));
            categoria.setId(rs.getInt("id"));
            return categoria;
        } catch (SQLException e) {
            manejarError("Error al parsear categoria", e);
        }
        return null;
    }
}
