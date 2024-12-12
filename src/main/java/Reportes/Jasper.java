package Reportes;

import java.sql.ResultSet;

import javax.swing.WindowConstants;

import Abstrac.DAO;
import Modelo.OrdenPedido;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Jasper extends DAO {

    public Jasper() {
    }

    public void generarReporte(OrdenPedido ordenPedido, int idComprobante) throws IOException {
        try {
            JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reports/Factura.jasper"));

            HashMap<String, Object> parametros = new HashMap<>();
            parametros.put("orden_id", ordenPedido.getId());
            parametros.put("comprobante_id", idComprobante);

            InputStream subReportStream = getClass().getResourceAsStream("/Reports/DetallesProductos.jasper");
            if (subReportStream == null) {
                throw new IOException("Subreporte no encontrado");
            }
            parametros.put("SubReport", subReportStream);

            InputStream logoStream = getClass().getResourceAsStream("/Reports/Logo.png");
            if (logoStream == null) {
                throw new IOException("Logo no encontrado");
            }
            parametros.put("Logo", logoStream);

            JasperPrint jPrint = JasperFillManager.fillReport(report, parametros, getconection());
            JasperViewer view = new JasperViewer(jPrint, false);
            view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            view.setVisible(true);
        } catch (JRException e) {
            manejarError("Error al generar reporte", e);
        }
    }

    @Override
    public Object parsear(ResultSet rs) {
        throw new UnsupportedOperationException("Unimplemented method 'parsear'");
    }

    public static void main(String[] args) throws IOException {
        Jasper jasper = new Jasper();
        OrdenPedido ordenPedido = new OrdenPedido();
        ordenPedido.setId(1);
        jasper.generarReporte(ordenPedido, 5);
    }
}
