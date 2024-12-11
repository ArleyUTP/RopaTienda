package Persistencia;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import Abstrac.DAO;
import Modelo.SeriesCorrelativos;

public class SeriesCorrelativosDAO extends DAO<SeriesCorrelativos>{

        // Método para obtener la serie y el correlativo actual utilizando un procedimiento almacenado
    public SeriesCorrelativos obtenerSerieYCorrelativo(String tipo) throws SQLException {
        String sql = "EXEC SP_ObtenerSerieYCorrelativo ?";
        SeriesCorrelativos series = null;

        try (Connection con = getconection();CallableStatement cs = con.prepareCall(sql)) {
            cs.setString(1, tipo);

            try (ResultSet rs = cs.executeQuery()) {
                if (rs.next()) {
                    series = new SeriesCorrelativos();
                    series.setId(rs.getLong("id"));
                    series.setTipo(rs.getString("tipo"));
                    series.setSerie(rs.getString("serie"));
                    series.setCorrelativoActual(rs.getInt("correlativo_actual"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return series;
    }

    // Método para actualizar el correlativo actual utilizando un procedimiento almacenado
    public void actualizarCorrelativo(long id, int nuevoCorrelativo) throws SQLException {
        String sql = "EXEC SP_ActualizarCorrelativo ?,?";

        try (Connection con = getconection();CallableStatement cs = con.prepareCall(sql)) {
            cs.setLong(1, id);
            cs.setInt(2, nuevoCorrelativo);
            cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }
    @Override
    public SeriesCorrelativos parsear(ResultSet rs) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'parsear'");
    }
    
}
