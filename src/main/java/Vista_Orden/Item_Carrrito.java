package Vista_Orden;

import Modelo.CarritoDetalles;
import Modelo.Producto;
import Persistencia.ProductoDAO;

public class Item_Carrrito extends javax.swing.JPanel {
    
    public Item_Carrrito(CarritoDetalles carritoDetalles) {
        initComponents();
        ProductoDAO productoDAO = new ProductoDAO();
        Producto producto = productoDAO.obtenerProductoPorId(carritoDetalles.getProductoInventario().getProducto());
        if (producto != null) {
            lbl_nombreProducto.setText(producto.getNombre());
            lbl_precio.setText("S/." + String.valueOf(producto.getPrecioVenta()));
            lbl_cantidad.setText(String.valueOf(carritoDetalles.getCantidad()));
            imagen.setImage(producto.getFotoPrincipal().getIcon());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelIzquierdo = new javax.swing.JPanel();
        roundButton1 = new Vista_Orden.componentes.RoundButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        paneDerecho = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        lbl_cantidad = new javax.swing.JLabel();
        panelCentrar = new javax.swing.JPanel();
        imagen = new javaswingdev.picturebox.PictureBox();
        panelInformacion = new javax.swing.JPanel();
        lbl_nombreProducto = new javax.swing.JLabel();
        lbl_precio = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        panelIzquierdo.setPreferredSize(new java.awt.Dimension(40, 109));
        panelIzquierdo.setLayout(new java.awt.BorderLayout());

        roundButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/busqueda.png"))); // NOI18N
        panelIzquierdo.add(roundButton1, java.awt.BorderLayout.CENTER);

        jLabel5.setText("     ");
        panelIzquierdo.add(jLabel5, java.awt.BorderLayout.PAGE_START);

        jLabel6.setText("      ");
        panelIzquierdo.add(jLabel6, java.awt.BorderLayout.PAGE_END);

        add(panelIzquierdo, java.awt.BorderLayout.LINE_END);

        paneDerecho.setPreferredSize(new java.awt.Dimension(30, 63));
        paneDerecho.setLayout(new java.awt.BorderLayout());

        jButton1.setText("+");
        paneDerecho.add(jButton1, java.awt.BorderLayout.PAGE_START);

        jButton2.setText("+");
        paneDerecho.add(jButton2, java.awt.BorderLayout.PAGE_END);

        lbl_cantidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_cantidad.setText("#");
        lbl_cantidad.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        paneDerecho.add(lbl_cantidad, java.awt.BorderLayout.CENTER);

        add(paneDerecho, java.awt.BorderLayout.LINE_START);

        imagen.setPreferredSize(new java.awt.Dimension(50, 55));
        panelCentrar.add(imagen);

        panelInformacion.setLayout(new java.awt.GridLayout(2, 1));

        lbl_nombreProducto.setText("Nombre Producto");
        panelInformacion.add(lbl_nombreProducto);

        lbl_precio.setText("Precio Venta");
        panelInformacion.add(lbl_precio);

        panelCentrar.add(panelInformacion);

        add(panelCentrar, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javaswingdev.picturebox.PictureBox imagen;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lbl_cantidad;
    private javax.swing.JLabel lbl_nombreProducto;
    private javax.swing.JLabel lbl_precio;
    private javax.swing.JPanel paneDerecho;
    private javax.swing.JPanel panelCentrar;
    private javax.swing.JPanel panelInformacion;
    private javax.swing.JPanel panelIzquierdo;
    private Vista_Orden.componentes.RoundButton roundButton1;
    // End of variables declaration//GEN-END:variables
}
