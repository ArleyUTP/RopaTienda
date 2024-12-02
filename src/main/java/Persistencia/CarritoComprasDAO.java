package Persistencia;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import Abstrac.DAO;
import Modelo.CarritoCompras;
import Modelo.Usuario;

public class CarritoComprasDAO extends DAO<CarritoCompras>{

    public int obtenerOCrearCarritoCompras(CarritoCompras carritoCompras){
        String sql = "EXEC SP_ObtenerOCrearCarrito ?,?";
        try (Connection con = getconection();CallableStatement cs = con.prepareCall(sql)){
            cs.setInt(1, carritoCompras.getUsuario().getId());
            cs.registerOutParameter(2, Types.BIGINT);
            cs.execute();
            return cs.getInt(2);
        } catch (SQLException e) {
            manejarError("Error al obtener o crear el carrito para el usuario: " + carritoCompras.getUsuario().getId(), e);
            return 0; // Indica error devolviendo 0
        }
    }
    public int obtenerCantidadProductosCarritoActivo(Usuario usuario){
        String sql = "EXEC SP_ObtenerCantidadProductosCarritoActivo ?, ?";
        try (Connection con = getconection(); CallableStatement cs = con.prepareCall(sql)) {
            // Establecer el parámetro de entrada
            cs.setInt(1, usuario.getId());
            // Registrar el parámetro de salida
            cs.registerOutParameter(2, Types.INTEGER);
            // Ejecutar el procedimiento almacenado
            cs.execute();
            // Retornar el resultado del parámetro de salida
            return cs.getInt(2);
        } catch (SQLException e) {
            manejarError("Error al obtener la cantidad de productos del carrito activo", e);
            return 0; // Si ocurre un error, retorna 0 por defecto
        }
    }
    @Override
    public CarritoCompras parsear(ResultSet rs) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'parsear'");
    }
}
