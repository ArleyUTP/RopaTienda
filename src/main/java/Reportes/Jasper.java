package Reportes;

import java.sql.ResultSet;

import javax.swing.WindowConstants;

import Abstrac.DAO;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Jasper extends DAO {

    public Jasper() {
        try {
            HashMap parametros = new HashMap();
            parametros.put("orden_id", 1);
            parametros.put("comprobante_id", 5);
            JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reports/Factura.jasper"));
            JasperPrint jPrint = JasperFillManager.fillReport(report, parametros, getconection());
            JasperViewer view = new JasperViewer(jPrint, false);
            view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            view.setVisible(true);
        } catch (JRException e) {
            manejarError("Error al mostrar informe", e);
        }
    }

    @Override
    public Object parsear(ResultSet rs) {
        throw new UnsupportedOperationException("Unimplemented method 'parsear'");
    }

    public static void main(String[] args) {
        Jasper jasper = new Jasper();
    }
}
