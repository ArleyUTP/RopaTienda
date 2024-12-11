package Persistencia;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import Abstrac.DAO;
import Modelo.Comprobante;

public class ComprobanteDAO extends DAO<Comprobante>{
    
    public long generarComprobante(Comprobante comprobante) throws SQLException {
    long idGenerado = 0;
    String sql = "EXEC GenerarComprobante ?, ?, ?, ?, ?, ?, ?, ?, ? ";
    try (Connection con = getconection();
         CallableStatement cs = con.prepareCall(sql)) {
        cs.setLong(1, comprobante.getOrdenPedido().getId());
        cs.setString(2, comprobante.getTipo());
        cs.setString(3, comprobante.getSerie());
        cs.setInt(4, comprobante.getCorrelativo());
        cs.setDouble(5, comprobante.getSubtotal());
        cs.setDouble(6, comprobante.getTotalIva());
        cs.setDouble(7, comprobante.getTotalAPagar());
        cs.setString(8, comprobante.getTotalLetras());
        cs.registerOutParameter(9, java.sql.Types.BIGINT);
        cs.execute();
        idGenerado = cs.getLong(9);
    } catch (SQLException e) {
        manejarError("Error al generar comprobante", e);
    }
    return idGenerado;
}

    @Override
    public Comprobante parsear(ResultSet rs) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'parsear'");
    }
    
}
