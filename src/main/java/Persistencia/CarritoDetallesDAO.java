package Persistencia;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import Abstrac.DAO;
import Modelo.CarritoCompras;
import Modelo.CarritoDetalles;
import Modelo.Producto;
import Modelo.ProductoInventario;

public class CarritoDetallesDAO extends DAO<CarritoDetalles> {

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

    public List<CarritoDetalles> obtenerDetallesPorCarrito(CarritoCompras carrito) {
        String sql = "EXEC SP_ObtenerDetallesPorCarrito ?";
        List<CarritoDetalles> detalles = new ArrayList<>();

        try (Connection con = getconection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, carrito.getIdCarrito());

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    CarritoDetalles detalle = parsear(rs);
                    detalle.setCarrito(carrito);
                    detalles.add(detalle);
                }
            }
        } catch (SQLException e) {
            manejarError("Error al obtener los detalles del carrito", e);
        }

        return detalles;
    }

    @Override
    public CarritoDetalles parsear(ResultSet rs) {
        CarritoDetalles carritoDetalles = new CarritoDetalles();
        try {
            carritoDetalles.setIdCarritoDetalle(rs.getInt("idCarritoDetalle"));
            ProductoInventario productoInventario = new ProductoInventario();
            productoInventario.setIdVariante(rs.getInt("inventario_id"));
            Producto producto = new Producto();
            producto.setId(rs.getInt("producto_id"));
            productoInventario.setProducto(producto);
            carritoDetalles.setProductoInventario(productoInventario);
            carritoDetalles.setCantidad(rs.getInt("cantidad"));
            carritoDetalles.setPrecio(rs.getDouble("precio"));
        } catch (Exception e) {
            manejarError("Error al parsear el resultado", e);
        }
        return carritoDetalles;
    }

    public double calcularSubtotalCarrito(CarritoCompras carrito) {
        String sql = "EXEC SP_CalcularSubTotalPorCarrito ?";
        try (Connection con = getconection(); CallableStatement cs = con.prepareCall(sql)) {
            cs.setInt(1, carrito.getIdCarrito());
            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                return rs.getDouble("subtotal");
            }
        } catch (Exception e) {
            manejarError("Error al calcular subtotal por carrito", e);
        }
        return 0;
    }

    public boolean aumentarCantidad(CarritoDetalles carritoDetalles) {
        String sql = "EXEC SP_AumentarCantidadCarrito ?";
        try (Connection con = getconection(); CallableStatement cs = con.prepareCall(sql)) {
            cs.setInt(1, carritoDetalles.getIdCarritoDetalle());
            cs.execute();
            return true; // Operación exitosa
        } catch (SQLException e) {
            manejarError("Error al aumentar cantidad en el carrito", e);
            return false; // Indica que hubo un problema
        }
    }

    public boolean disminuirCantidad(CarritoDetalles carritoDetalles) {
        String sql = "EXEC SP_DisminuirCantidadCarrito ?";
        try (Connection con = getconection(); CallableStatement cs = con.prepareCall(sql)) {
            cs.setInt(1, carritoDetalles.getIdCarritoDetalle());
            cs.execute();
            return true; // Operación exitosa
        } catch (SQLException e) {
            manejarError("Error al disminuir cantidad en el carrito", e);
            return false; // Indica que hubo un problema
        }
    }

    public boolean eliminarCarritoDetalle(CarritoDetalles carritoDetalles) {
        String sql = "EXEC SP_EliminarCarritoDetalle ?";
        try (Connection con = getconection(); CallableStatement cs = con.prepareCall(sql)) {
            cs.setInt(1, carritoDetalles.getIdCarritoDetalle());
            cs.execute();
            return true; // Operación exitosa
        } catch (SQLException e) {
            manejarError("Error al eliminar el detalle del carrito", e);
            return false; // Indica que hubo un problema
        }
    }
}
