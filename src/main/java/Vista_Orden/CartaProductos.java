package Vista_Orden;

import Modelo.ImageResizer;
import Modelo.Producto;
import com.formdev.flatlaf.FlatClientProperties;
import javaswingdev.picturebox.PictureBox.BoxFit;
import javax.swing.Icon;
import raven.popup.DefaultOption;
import raven.popup.GlassPanePopup;
import raven.popup.component.SimplePopupBorder;
import raven.popup.component.SimplePopupBorderOption;
import raven.toast.Notifications;

public class CartaProductos extends javax.swing.JPanel {

    private Producto producto;

    public CartaProductos(Producto producto) {
        initComponents();
        init();
        lbl_nombre.setText(producto.getNombre());
        lbl_precio.setText("S/. " + String.valueOf(producto.getPrecioVenta()));
        lbl_descripcion.setText(producto.getDescripcion());
        jScrollPane1.setOpaque(false);
        lbl_descripcion.setOpaque(false);
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
            this.producto = producto;
        }
    }

    private void init() {
        this.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:25;"
                + "background:$Table.background");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        imagen = new javaswingdev.picturebox.PictureBox();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lbl_descripcion = new javax.swing.JTextArea();
        lbl_nombre = new javax.swing.JLabel();
        lbl_precio = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jPanel2.setLayout(new java.awt.BorderLayout());
        jPanel2.add(imagen, java.awt.BorderLayout.CENTER);

        jPanel4.setOpaque(false);
        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel1.setEnabled(false);
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setBorder(null);
        jScrollPane1.setEnabled(false);
        jScrollPane1.setOpaque(false);

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
        jScrollPane1.setViewportView(lbl_descripcion);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        lbl_descripcion.getAccessibleContext().setAccessibleName("");

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        lbl_nombre.setBackground(new java.awt.Color(0, 0, 0));
        lbl_nombre.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_nombre.setText("Nombre");
        lbl_nombre.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(lbl_nombre, java.awt.BorderLayout.PAGE_START);

        lbl_precio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_precio.setText("Precio");
        jPanel1.add(lbl_precio, java.awt.BorderLayout.PAGE_END);

        jPanel4.add(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
//
//        Productos_Detalles productos_Detalles = new Productos_Detalles(producto);
//        DefaultOption option = new DefaultOption() {
//            @Override
//            public boolean closeWhenClickOutside() {
//                return true;
//            }
//        };
//        String actions[] = new String[]{"Cancelar", "Agregar al Carrito"};
//        GlassPanePopup.showPopup(
//                new SimplePopupBorder(productos_Detalles, "Crear Usuario", new SimplePopupBorderOption().setWidth(590), actions, (pc, i) -> {
//                    if (i == 1) {
//                        Notifications.getInstance().show(Notifications.Type.SUCCESS, "Agregado Correcto al carrito");
//                        pc.closePopup();
//                    } else {
//                        pc.closePopup();
//                    }
//                }),
//                option
//        );
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javaswingdev.picturebox.PictureBox imagen;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea lbl_descripcion;
    private javax.swing.JLabel lbl_nombre;
    private javax.swing.JLabel lbl_precio;
    // End of variables declaration//GEN-END:variables
}
