package Persistencia;

import java.util.List;

import Abstrac.DAO;
import Modelo.Marca;
import Modelo.Producto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MarcaDAO extends DAO<Marca>{
    /*Base de datos:
     * CREATE TABLE Generos (
    id BIGINT PRIMARY KEY IDENTITY(1,1),
    nombre NVARCHAR(20) UNIQUE CHECK (nombre IN ('Hombre', 'Niño', 'Mujer', 'Niña'))
);
     */
    public List<Marca> obtenerTodasLasMarcas(){
        List<Marca> marcas = listarTodo("SP_obtenerTodasLasMarcas");
        return marcas;
    }

    @Override
    public Marca parsear(ResultSet rs) {
        try {
            Marca marca = new Marca(rs.getString("nombre"));
            marca.setId(rs.getLong("id"));
            return marca;
        } catch (SQLException e) {
            manejarError("Error al Parsear Marca", e);
        }
        return null;
    }
    public List<Marca> obtenerMarcaPorId(Producto producto){
        long id = producto.getId();
        List<Marca> marcas = listarPorId(id,"SP_ObtenerMarcasPorProducto");
        return marcas;
    }
}
