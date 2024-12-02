package Persistencia;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import Abstrac.DAO;
import Modelo.CarritoDetalles;

public class CarritoDetallesDAO extends DAO<CarritoDetalles>{

public boolean crearCarritoDetalle(CarritoDetalles carritoDetalle) {
    String sql = "EXEC SP_CrearCarritoDetalle ?, ?, ?, ?, ?";
    try (Connection con = getconection(); CallableStatement cs = con.prepareCall(sql)) {
        // Establecer los parámetros de entrada
        cs.setInt(1, carritoDetalle.getCarrito().getIdCarrito());
        cs.setInt(2, carritoDetalle.getProductoInventario().getIdVariante());
        cs.setInt(3, carritoDetalle.getCantidad());
        cs.setDouble(4, carritoDetalle.getPrecio());

        // Parámetro de salida
        cs.registerOutParameter(5, Types.BIT);

        // Ejecutar el procedimiento almacenado
        cs.execute();

        // Retornar el resultado del procedimiento almacenado
        return cs.getBoolean(5);
    } catch (SQLException e) {
        manejarError("Error al crear el detalle del carrito", e);
        return false; // Indica que no se pudo crear el detalle
    }
}

    @Override
    public CarritoDetalles parsear(ResultSet rs) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'parsear'");
    }
    
}
