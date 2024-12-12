package Persistencia;

import java.sql.*;
import java.util.*;

import Abstrac.DAO;
import Modelo.Categoria;
import Modelo.Producto;

public class CategoriaDAO extends DAO<Categoria> {

    public List<Categoria> obtenerTodasLasCategorias() {
        List<Categoria> categorias = listarTodo("SP_ObtenerTodasLasCategorias");
        return categorias;
    }

    public String obtenerCategoriaPorId(Producto producto) {
        long id = producto.getCategoria().getId();
        String nombreCategoria = "";
        try (Connection con = getconection(); CallableStatement cs = con.prepareCall("EXEC SP_OptenerCategoriaPorId ? ")) {
            cs.setLong(1, id);
            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                nombreCategoria = rs.getString("nombre");
            }
        } catch (SQLException e) {
            manejarError("Error al obtener nombre Categoria por ID", e);
        }
        return nombreCategoria;
    }

    @Override
    public Categoria parsear(ResultSet rs) {
        try {
            Categoria categoria = new Categoria();
            categoria.setId(rs.getInt("id"));
            categoria.setNombre(rs.getString("nombre"));
            return categoria;
        } catch (SQLException e) {
            manejarError("Error al parsear categoria", e);
        }
        return null;
    }
}
