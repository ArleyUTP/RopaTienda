package Persistencia;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Abstrac.DAO;
import Modelo.OrdenPedido;

public class OrdenPedidoDAO extends DAO<OrdenPedido> {

    public boolean GenerarOrdenPedido(OrdenPedido ordenPedido) {
        String sql = "EXEC SP_GenerarOrdenPedido ?,?,?,?,?";
        try (Connection con = getconection(); CallableStatement cs = con.prepareCall(sql)) {
            // Establecer los parámetros de entrada
            cs.setInt(1, ordenPedido.getCliente().getId());
            System.out.println("Id del Cliente: " + ordenPedido.getCliente().getId());
            cs.setInt(2, ordenPedido.getVendedor().getId());
            System.out.println("ID del Vendedor: " + ordenPedido.getVendedor().getId());
            cs.setInt(3, ordenPedido.getCarritoCompras().getIdCarrito());
            System.out.println("Id del carrito es: " + ordenPedido.getCarritoCompras().getIdCarrito());
            cs.setString(4, ordenPedido.getForma_pago());
            // Registrar el parámetro de salida
            cs.registerOutParameter(5, java.sql.Types.BIT);

            // Ejecutar el procedimiento almacenado
            cs.execute();

            // Obtener el valor del parámetro de salida
            return cs.getBoolean(5);
        } catch (SQLException e) {
            // Manejar cualquier error de base de datos
            System.err.println("Error al generar la orden de pedido: " + e.getMessage());
            return false; // Indicar fallo en caso de excepción
        }
    }

    public void mostrarOrdenesPedido(JTable tablaOrdenes) {
        DefaultTableModel modelo = (DefaultTableModel) tablaOrdenes.getModel();
        String sql = "EXEC SP_MostarOrdenesPedido";
        try (Connection con = getconection(); CallableStatement cs = con.prepareCall(sql)) {
            try (ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    OrdenPedido ordenPedido = parsear(rs);
                    modelo.addRow(new Object[]{
                        false,
                        ordenPedido.getId(),
                        ordenPedido.getFecha_emision(),
                        ordenPedido.getImporte_total(),});
                }
            }
        } catch (SQLException e) {

        }
    }

    @Override
    public OrdenPedido parsear(ResultSet rs) {
        OrdenPedido ordenPedido = new OrdenPedido();
        try {
            ordenPedido.setId(rs.getInt("id"));
            ordenPedido.setFecha_emision(rs.getDate("fecha_emision"));
            ordenPedido.setImporte_total(rs.getDouble("importe_total"));
            ordenPedido.setForma_pago(rs.getString("forma_pago"));
            return ordenPedido;
        } catch (Exception e) {
            manejarError("Error al parsear la Orden de Pedido", e);
            return null;
        }
    }

}
