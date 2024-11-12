package Persistencia;

import java.sql.*;
import java.util.*;

import Abstrac.DAO;
import Modelo.Categoria;
import Modelo.Producto;

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
    public String obtenerCategoriaPorId(Producto producto){
        long id = producto.getId();
        String nombreCategoria = "";
        try (Connection con = getconection();
                CallableStatement cs = con.prepareCall("EXEC SP_OptenerCategoriaPorId ? ")){
            cs.setLong(1, id);
            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                nombreCategoria=rs.getString("nombre");
            }
        } catch (SQLException e) {
            manejarError("Error al obtener nombre Categoria por ID", e);
        }
        return nombreCategoria;
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
