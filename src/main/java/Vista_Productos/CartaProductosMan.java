package Vista_Productos;

import Modelo.ImageResizer;
import Modelo.Producto;
import Persistencia.CategoriaDAO;
import com.formdev.flatlaf.FlatClientProperties;
import javaswingdev.picturebox.PictureBox.BoxFit;
import javax.swing.Icon;

public class CartaProductosMan extends javax.swing.JPanel {

    private Producto producto;

    public CartaProductosMan(Producto producto) {
        initComponents();
        init();
        lbl_nombre.setText(producto.getNombre());
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        lbl_categoria.setText(categoriaDAO.obtenerCategoriaPorId(producto));
        lbl_precioCompra.setText(String.valueOf(producto.getPrecioCompra()));
        lbl_precioVenta.setText(String.valueOf(producto.getPrecioVenta()));
        lbl_descripcion.setText(producto.getDescripcion());
        // Verificar si el producto tiene una imagen
        if (producto.getFotoPrincipal() != null && producto.getFotoPrincipal().getIcon() != null) {
            // Obtener el Icono de la imagen
            Icon imagenIcono = producto.getFotoPrincipal().getIcon();  // Aquí obtenemos el Icono directamente
            // Establecer el Icono en el PictureBox
            imagen.setSize(362, 532);
            ImageResizer imageResizer = new ImageResizer(imagenIcono);
            imagen.setImage(imageResizer.obtenerIconoRedimensionado(imagen));
            // Ajustar la imagen con BoxFit
            imagen.setBoxFit(BoxFit.COVER);  // Ajuste para cubrir el cuadro completo
        } else {
            System.out.println("La foto es nulll");
        }
        btn_estadoPromocion.setSelected(producto.isEstadoPromocion());
        this.producto = producto;
    }

    private void init() {
        this.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:25;"
                + "background:$Table.background");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_descripcion = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        imagen = new javaswingdev.picturebox.PictureBox();
        jPanel4 = new javax.swing.JPanel();
        lbl_nombre = new javax.swing.JLabel();
        lbl_categoria = new javax.swing.JLabel();
        lbl_precioCompra = new javax.swing.JLabel();
        lbl_precioVenta = new javax.swing.JLabel();
        btn_estadoPromocion = new javax.swing.JCheckBox();

        setBackground(new java.awt.Color(204, 204, 204));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        lbl_descripcion.setEditable(false);
        lbl_descripcion.setBackground(new java.awt.Color(187, 187, 187));
        lbl_descripcion.setColumns(20);
        lbl_descripcion.setForeground(new java.awt.Color(0, 0, 0));
        lbl_descripcion.setRows(5);
        lbl_descripcion.setBorder(null);
        lbl_descripcion.setFocusable(false);
        lbl_descripcion.setOpaque(false);
        lbl_descripcion.setLineWrap(true);         // Ajuste de línea automático
        lbl_descripcion.setWrapStyleWord(true);    // Ajuste en palabras completas
        lbl_descripcion.setEditable(false);        // Desactiva la edición
        lbl_descripcion.setOpaque(false);          // Fondo transparente para parecer un JLabel// Configuración de fuente

        jPanel2.setLayout(new java.awt.BorderLayout());
        jPanel2.add(imagen, java.awt.BorderLayout.CENTER);

        jPanel4.setOpaque(false);
        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.Y_AXIS));

        lbl_nombre.setText("nombre");
        jPanel4.add(lbl_nombre);

        lbl_categoria.setText("categoria");
        jPanel4.add(lbl_categoria);

        lbl_precioCompra.setText("precio compra");
        jPanel4.add(lbl_precioCompra);

        lbl_precioVenta.setText("precio venta");
        jPanel4.add(lbl_precioVenta);

        btn_estadoPromocion.setText("Promoción");
        jPanel4.add(btn_estadoPromocion);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lbl_descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lbl_descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        lbl_descripcion.getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked


    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox btn_estadoPromocion;
    private javaswingdev.picturebox.PictureBox imagen;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lbl_categoria;
    private javax.swing.JTextArea lbl_descripcion;
    private javax.swing.JLabel lbl_nombre;
    private javax.swing.JLabel lbl_precioCompra;
    private javax.swing.JLabel lbl_precioVenta;
    // End of variables declaration//GEN-END:variables
}
