package Vista_Orden;

import Modelo.CarritoCompras;
import Modelo.CarritoDetalles;
import Modelo.Usuario;
import Persistencia.CarritoComprasDAO;
import Persistencia.CarritoDetallesDAO;
import com.formdev.flatlaf.FlatClientProperties;
import java.util.List;
import javax.swing.BorderFactory;

public class CarritoCompra extends javax.swing.JPanel {

    private Usuario usuario;
    private CarritoCompras carritoCompra;

    public CarritoCompras getCarritoCompra() {
        return carritoCompra;
    }

    public void setCarritoCompra(CarritoCompras carritoCompra) {
        this.carritoCompra = carritoCompra;
    }

    public CarritoCompra(Usuario usuario) {
        this.usuario = usuario;
        initComponents();
        init();
        cargarDatos();
        calcularSubtotal();
    }

    private void init() {
        this.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:25;"
                + "background:$Table.background");
    }

    public void cargarDatos() {
        if (usuario != null) {
            CarritoComprasDAO carritoComprasDAO = new CarritoComprasDAO();
            CarritoDetallesDAO carritoDetallesDAO = new CarritoDetallesDAO();
            carritoCompra = carritoComprasDAO.obtenerCarritoCompras(usuario);
            List<CarritoDetalles> listaCarritoDetalle = carritoDetallesDAO.obtenerDetallesPorCarrito(carritoCompra);
            listaCarritoDetalle.forEach(carritoDetalle -> {
                Item_Carrrito item_Carrrito = new Item_Carrrito(carritoDetalle);
                panelCentrar.add(item_Carrrito);
            });
            panelCentrar.revalidate();
            panelCentrar.repaint();
        }
    }

    public void calcularSubtotal() {
        CarritoDetallesDAO carritoDetallesDAO = new CarritoDetallesDAO();
        if (carritoCompra != null) {
            lbl_subtotal.setText("S/." + carritoDetallesDAO.calcularSubtotalCarrito(carritoCompra));
        } else {
            lbl_subtotal.setText("");
        }
    }

    public void recargarCarrito() {
        panelCentrar.removeAll(); // Limpia los elementos actuales
        cargarDatos(); // Vuelve a cargar los datos desde la base de datos
        calcularSubtotal(); // Actualiza el subtotal
        panelCentrar.revalidate();
        panelCentrar.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        panelCentrar = new javax.swing.JPanel();
        panelInferior = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbl_subtotal = new javax.swing.JLabel();

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(238, 200));
        setLayout(new java.awt.BorderLayout());

        jScrollPane1.setBorder(null);

        panelCentrar.setLayout(new javax.swing.BoxLayout(panelCentrar, javax.swing.BoxLayout.Y_AXIS));

        // Espaciado entre elementos
        panelCentrar.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Opcional

        jScrollPane1.setViewportView(panelCentrar);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);

        panelInferior.setPreferredSize(new java.awt.Dimension(400, 40));
        panelInferior.setLayout(new java.awt.BorderLayout());

        jLabel1.setText("Subtotal");
        jLabel1.setPreferredSize(new java.awt.Dimension(130, 16));
        panelInferior.add(jLabel1, java.awt.BorderLayout.LINE_START);

        lbl_subtotal.setText("######");
        lbl_subtotal.setPreferredSize(new java.awt.Dimension(70, 16));
        panelInferior.add(lbl_subtotal, java.awt.BorderLayout.LINE_END);

        add(panelInferior, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_subtotal;
    private javax.swing.JPanel panelCentrar;
    private javax.swing.JPanel panelInferior;
    // End of variables declaration//GEN-END:variables
}
