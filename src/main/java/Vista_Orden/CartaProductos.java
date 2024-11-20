package Vista_Orden;

import Modelo.Producto;
import com.formdev.flatlaf.FlatClientProperties;
import raven.popup.DefaultOption;
import raven.popup.GlassPanePopup;
import raven.popup.component.SimplePopupBorder;
import raven.popup.component.SimplePopupBorderOption;
import raven.toast.Notifications;

public class CartaProductos extends javax.swing.JPanel {

    private Producto producto;

    public CartaProductos(Producto producto) {
        initComponents();
//        init();
        lbl_nombre.setText(producto.getNombre());
        lbl_precio.setText(String.valueOf(producto.getPrecioVenta()));
        lbl_descripcion.setText(producto.getDescripcion());
        if (producto.getFoto_principal()!= null) {
            imagen.setImage(producto.getFoto_principal().getIcon());
        }
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
        java.awt.GridBagConstraints gridBagConstraints;

        imagen = new javaswingdev.picturebox.PictureBox();
        lbl_nombre = new javax.swing.JLabel();
        lbl_precio = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lbl_descripcion = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(204, 204, 204));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout imagenLayout = new javax.swing.GroupLayout(imagen);
        imagen.setLayout(imagenLayout);
        imagenLayout.setHorizontalGroup(
            imagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );
        imagenLayout.setVerticalGroup(
            imagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 406, Short.MAX_VALUE)
        );

        lbl_nombre.setBackground(new java.awt.Color(0, 0, 0));
        lbl_nombre.setText("Nombre");

        lbl_precio.setText("Precio");

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.BorderLayout());

        lbl_descripcion.setColumns(20);
        lbl_descripcion.setRows(5);
        lbl_descripcion.setOpaque(false);
        lbl_descripcion.setLineWrap(true);         // Ajuste de línea automático
        lbl_descripcion.setWrapStyleWord(true);    // Ajuste en palabras completas
        lbl_descripcion.setEditable(false);        // Desactiva la edición
        lbl_descripcion.setOpaque(false);          // Fondo transparente para parecer un JLabel// Configuración de fuente
        jScrollPane1.setViewportView(lbl_descripcion);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        lbl_descripcion.getAccessibleContext().setAccessibleName("");
        lbl_descripcion.getAccessibleContext().setAccessibleParent(null);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_precio)
                            .addComponent(lbl_nombre))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_nombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_precio)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked

        Productos_Detalles productos_Detalles = new Productos_Detalles(producto);
        DefaultOption option = new DefaultOption() {
            @Override
            public boolean closeWhenClickOutside() {
                return true;
            }
        };
        String actions[] = new String[]{"Cancelar", "Agregar al Carrito"};
        GlassPanePopup.showPopup(
                new SimplePopupBorder(productos_Detalles, "Crear Usuario", new SimplePopupBorderOption
                        ().setWidth(590),actions, (pc, i) -> {
                    if (i == 1) {
                        Notifications.getInstance().show(Notifications.Type.SUCCESS, "Agregado Correcto al carrito");
                        pc.closePopup();
                    } else {
                        pc.closePopup();
                    }
                }),
                option
        );
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javaswingdev.picturebox.PictureBox imagen;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea lbl_descripcion;
    private javax.swing.JLabel lbl_nombre;
    private javax.swing.JLabel lbl_precio;
    // End of variables declaration//GEN-END:variables
}
