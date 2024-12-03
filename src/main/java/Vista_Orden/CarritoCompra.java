package Vista_Orden;

import Modelo.CarritoCompras;
import Modelo.CarritoDetalles;
import Modelo.Usuario;
import Persistencia.CarritoComprasDAO;
import Persistencia.CarritoDetallesDAO;
import java.util.List;

public class CarritoCompra extends javax.swing.JPanel {

    private Usuario usuario;

    public CarritoCompra(Usuario usuario) {
        this.usuario = usuario;
        initComponents();
        cargarDatos();
    }

    private void cargarDatos() {
        if (usuario != null) {
            CarritoComprasDAO carritoComprasDAO = new CarritoComprasDAO();
            CarritoDetallesDAO carritoDetallesDAO = new CarritoDetallesDAO();
            CarritoCompras carritoCompra = carritoComprasDAO.obtenerCarritoCompras(usuario);
            List<CarritoDetalles> listaCarritoDetalle = carritoDetallesDAO.obtenerDetallesPorCarrito(carritoCompra);
            listaCarritoDetalle.forEach(carritoDetalle -> {
                Item_Carrrito item_Carrrito = new Item_Carrrito(carritoDetalle);
                panelCentrar.add(item_Carrrito);
            });
            panelCentrar.revalidate();
            panelCentrar.repaint();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        panelCentrar = new javax.swing.JPanel();
        panelInferior = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jScrollPane1.setBorder(null);

        panelCentrar.setLayout(new javax.swing.BoxLayout(panelCentrar, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(panelCentrar);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);

        panelInferior.setPreferredSize(new java.awt.Dimension(400, 40));
        panelInferior.setLayout(new java.awt.BorderLayout());

        jLabel1.setText("Subtotal");
        jLabel1.setPreferredSize(new java.awt.Dimension(130, 16));
        panelInferior.add(jLabel1, java.awt.BorderLayout.LINE_START);

        jLabel2.setText("######");
        jLabel2.setPreferredSize(new java.awt.Dimension(70, 16));
        panelInferior.add(jLabel2, java.awt.BorderLayout.LINE_END);

        add(panelInferior, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelCentrar;
    private javax.swing.JPanel panelInferior;
    // End of variables declaration//GEN-END:variables
}
