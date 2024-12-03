package Componentes;

import Modelo.Usuario;
import Persistencia.CarritoComprasDAO;

public class CarritoOfer_Item extends javax.swing.JPanel {

    private Usuario usuarioActual;

    public CarritoOfer_Item() {
        initComponents();
    }

    public Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public void setUsuarioActual(Usuario usuarioActual) {
        this.usuarioActual = usuarioActual;
    }

    public void mostrarContador(Usuario usuario) {
        if (usuarioActual != null) {
            CarritoComprasDAO carritoComprasDAO = new CarritoComprasDAO();
            int cantidadProductos = carritoComprasDAO.obtenerCantidadProductosCarritoActivo(usuarioActual);
            if (cantidadProductos != 0) {
                cantidad.setTexto(String.valueOf(cantidadProductos));
            } else {
                cantidad.setTexto(String.valueOf("0"));
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cantidad = new Componentes.Ofer_Circulo();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(50, 50));
        setLayout(null);
        add(cantidad);
        cantidad.setBounds(20, 30, 40, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-shopping-cart-48.png"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(0, 0, 70, 70);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Componentes.Ofer_Circulo cantidad;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
