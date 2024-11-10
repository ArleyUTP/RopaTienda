package Vista_Orden;

import Modelo.Producto;
import com.formdev.flatlaf.FlatClientProperties;
import javax.swing.ImageIcon;
import raven.popup.DefaultOption;
import raven.popup.GlassPanePopup;
import raven.popup.component.SimplePopupBorder;
import raven.toast.Notifications;

public class CartaProductos extends javax.swing.JPanel {

    private Producto producto;

    public CartaProductos(Producto producto) {
        initComponents();
        init();
        lbl_nombre.setText(producto.getNombre());
        lbl_precio.setText(String.valueOf(producto.getPrecioVenta()));
        if (producto.getFoto() != null) {
            imagen.setImage(new ImageIcon(producto.getFoto()));
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

        imagen = new javaswingdev.picturebox.PictureBox();
        lbl_nombre = new javax.swing.JLabel();
        lbl_precio = new javax.swing.JLabel();

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        lbl_nombre.setText("Nombre");

        lbl_precio.setText("Precio");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_nombre)
                    .addComponent(lbl_precio))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_nombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_precio)
                .addGap(0, 17, Short.MAX_VALUE))
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
                new SimplePopupBorder(productos_Detalles, "Crear Usuario", actions, (pc, i) -> {
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
    private javax.swing.JLabel lbl_nombre;
    private javax.swing.JLabel lbl_precio;
    // End of variables declaration//GEN-END:variables
}
