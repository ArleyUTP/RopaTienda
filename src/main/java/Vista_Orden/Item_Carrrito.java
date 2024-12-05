package Vista_Orden;

import Modelo.CarritoDetalles;
import Modelo.Producto;
import Persistencia.CarritoDetallesDAO;
import Persistencia.ProductoDAO;
import raven.toast.Notifications;

public class Item_Carrrito extends javax.swing.JPanel {

    private CarritoDetalles carritoDetalles;

    public Item_Carrrito(CarritoDetalles carritoDetalles) {
        initComponents();
        this.carritoDetalles = carritoDetalles;
        ProductoDAO productoDAO = new ProductoDAO();
        Producto producto = productoDAO.obtenerProductoPorId(carritoDetalles.getProductoInventario().getProducto());
        if (producto != null) {
            lbl_nombreProducto.setText(producto.getNombre());
            lbl_precio.setText("S/." + String.valueOf(producto.getPrecioVenta()));
            lbl_cantidad.setText(String.valueOf(carritoDetalles.getCantidad()));
            imagen.setImage(producto.getFotoPrincipal().getIcon());
        }
    }

    private void recargarDatosCarrito() {
        CarritoCompra carritoCompra = (CarritoCompra) getParent().getParent().getParent().getParent();
        carritoCompra.recargarCarrito();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paneDerecho = new javax.swing.JPanel();
        btn_aumentar = new javax.swing.JButton();
        btn_disminuir = new javax.swing.JButton();
        lbl_cantidad = new javax.swing.JLabel();
        panelCentrar = new javax.swing.JPanel();
        imagen = new javaswingdev.picturebox.PictureBox();
        panelInformacion = new javax.swing.JPanel();
        lbl_nombreProducto = new javax.swing.JLabel();
        lbl_precio = new javax.swing.JLabel();
        buttonAction1 = new Vista_Usuarios.table.ButtonAction();

        setPreferredSize(new java.awt.Dimension(238, 60));
        setLayout(new java.awt.BorderLayout());

        paneDerecho.setPreferredSize(new java.awt.Dimension(30, 63));
        paneDerecho.setLayout(new java.awt.BorderLayout());

        btn_aumentar.setText("+");
        btn_aumentar.setBorder(null);
        btn_aumentar.setOpaque(false);
        btn_aumentar.setPreferredSize(new java.awt.Dimension(7, 24));
        btn_aumentar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_aumentarActionPerformed(evt);
            }
        });
        paneDerecho.add(btn_aumentar, java.awt.BorderLayout.PAGE_START);

        btn_disminuir.setText("-");
        btn_disminuir.setBorder(null);
        btn_disminuir.setOpaque(false);
        btn_disminuir.setPreferredSize(new java.awt.Dimension(4, 24));
        btn_disminuir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_disminuirActionPerformed(evt);
            }
        });
        paneDerecho.add(btn_disminuir, java.awt.BorderLayout.PAGE_END);

        lbl_cantidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_cantidad.setText("#");
        lbl_cantidad.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        paneDerecho.add(lbl_cantidad, java.awt.BorderLayout.CENTER);

        add(paneDerecho, java.awt.BorderLayout.WEST);

        imagen.setPreferredSize(new java.awt.Dimension(50, 55));
        panelCentrar.add(imagen);

        panelInformacion.setLayout(new java.awt.GridLayout(2, 1));

        lbl_nombreProducto.setText("Nombre Producto");
        panelInformacion.add(lbl_nombreProducto);

        lbl_precio.setText("Precio Venta");
        panelInformacion.add(lbl_precio);

        panelCentrar.add(panelInformacion);

        buttonAction1.setBorder(null);
        buttonAction1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-delete-30.png"))); // NOI18N
        buttonAction1.setOpaque(false);
        buttonAction1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAction1ActionPerformed(evt);
            }
        });
        panelCentrar.add(buttonAction1);

        add(panelCentrar, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_aumentarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aumentarActionPerformed
        CarritoDetallesDAO carritoDetallesDAO = new CarritoDetallesDAO();
        if (carritoDetallesDAO.aumentarCantidad(carritoDetalles)) {
            recargarDatosCarrito();
        } else {
            Notifications.getInstance().show(Notifications.Type.ERROR, "No se pudo aumentar la cantidad.");
        }
    }//GEN-LAST:event_btn_aumentarActionPerformed

    private void btn_disminuirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_disminuirActionPerformed
        CarritoDetallesDAO carritoDetallesDAO = new CarritoDetallesDAO();
        if (carritoDetallesDAO.disminuirCantidad(carritoDetalles)) {
            recargarDatosCarrito();
        } else {
            Notifications.getInstance().show(Notifications.Type.ERROR, "No se pudo disminuir la cantidad.");
        }
    }//GEN-LAST:event_btn_disminuirActionPerformed

    private void buttonAction1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAction1ActionPerformed
        CarritoDetallesDAO carritoDetallesDAO = new CarritoDetallesDAO();
        if (carritoDetallesDAO.eliminarCarritoDetalle(carritoDetalles)) {
            recargarDatosCarrito();
        }
        Notifications.getInstance().show(Notifications.Type.ERROR, "No se pudo disminuir la cantidad.");
    }//GEN-LAST:event_buttonAction1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_aumentar;
    private javax.swing.JButton btn_disminuir;
    private Vista_Usuarios.table.ButtonAction buttonAction1;
    private javaswingdev.picturebox.PictureBox imagen;
    private javax.swing.JLabel lbl_cantidad;
    private javax.swing.JLabel lbl_nombreProducto;
    private javax.swing.JLabel lbl_precio;
    private javax.swing.JPanel paneDerecho;
    private javax.swing.JPanel panelCentrar;
    private javax.swing.JPanel panelInformacion;
    // End of variables declaration//GEN-END:variables
}
