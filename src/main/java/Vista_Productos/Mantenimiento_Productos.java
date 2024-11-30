package Vista_Productos;

import Modelo.Producto;
import Modelo.ProductoInventario;
import Persistencia.ProductoDAO;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Dimension;
import java.util.List;
import raven.popup.DefaultOption;
import raven.popup.GlassPanePopup;
import raven.popup.component.SimplePopupBorder;
import raven.popup.component.SimplePopupBorderOption;
import raven.toast.Notifications;

public class Mantenimiento_Productos extends javax.swing.JPanel {

    public Mantenimiento_Productos() {
        initComponents();
        init();
        cargarProductos();
    }

    private void init() {
        panel.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:25;"
                + "background:$Table.background");
        scroll.getVerticalScrollBar().putClientProperty(FlatClientProperties.STYLE, ""
                + "trackArc:999;"
                + "trackInsets:3,3,3,3;"
                + "thumbInsets:3,3,3,3;"
                + "background:$Table.background;");
        lbl_titulo.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:bold +5;");
        txt_busqueda.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Busqueda...");
        txt_busqueda.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, new FlatSVGIcon("sample/icon/search.svg"));
        txt_busqueda.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:15;"
                + "borderWidth:0;"
                + "focusWidth:0;"
                + "innerFocusWidth:0;"
                + "margin:5,20,5,20;"
                + "background:$Panel.background");
        btn_crear.putClientProperty(FlatClientProperties.STYLE, ""
                + "background:#39E079");
        btn_editar.putClientProperty(FlatClientProperties.STYLE, ""
                + "");
        btn_eliminar.putClientProperty(FlatClientProperties.STYLE, ""
                + "");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        lbl_titulo = new javax.swing.JLabel();
        txt_busqueda = new javax.swing.JTextField();
        btn_eliminar = new Vista_Usuarios.table.ButtonAction();
        btn_editar = new Vista_Usuarios.table.ButtonAction();
        btn_crear = new Vista_Usuarios.table.ButtonAction();
        scroll = new javax.swing.JScrollPane();
        contenedor = new javax.swing.JPanel();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        lbl_titulo.setText("Producto");

        txt_busqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_busquedaKeyReleased(evt);
            }
        });

        btn_eliminar.setText("Eliminar");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        btn_editar.setText("Editar");
        btn_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarActionPerformed(evt);
            }
        });

        btn_crear.setText("Crear");
        btn_crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_crearActionPerformed(evt);
            }
        });

        contenedor.setLayout(new java.awt.GridLayout(0, 4, 50, 50));
        scroll.setViewportView(contenedor);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scroll)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_titulo)
                            .addComponent(txt_busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(300, 358, Short.MAX_VALUE)
                        .addComponent(btn_crear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)))
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_crear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(panel);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_busquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busquedaKeyReleased
    }//GEN-LAST:event_txt_busquedaKeyReleased

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void btn_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarActionPerformed
    }//GEN-LAST:event_btn_editarActionPerformed

    private void btn_crearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_crearActionPerformed
        Vista_Productos.Crear crear = new Crear();
        crear.setPreferredSize(new Dimension(100, 574)); // Cambia el tamaño según sea necesario

        DefaultOption option = new DefaultOption() {
            @Override
            public boolean closeWhenClickOutside() {
                return true;
            }
        };
        String actions[] = new String[]{"Cancelar", "Guardar"};

        GlassPanePopup.showPopup(
                new SimplePopupBorder(crear, "Crear Producto",
                        new SimplePopupBorderOption()
                                .setRoundBorder(30) // Esquinas redondeadas con un radio de 30 píxeles
                                .setWidth(1000) // Cambia el ancho según sea necesario
                                .useScroll(), // Habilitar desplazamiento si es necesario
                        actions,
                        (pc, i) -> {
                            if (i == 1) {
                                ProductoDAO productoDAO = new ProductoDAO();
                                Producto producto = crear.obtenerProducto();
                                List<ProductoInventario> variantes = crear.obtenerVarianteProducto();
                                if (productoDAO.crearProductoConVariantes(producto, variantes)) {
                                    Notifications.getInstance().show(Notifications.Type.INFO, "Producto Creado Correctamente");
                                }
                                pc.closePopup();
                                Notifications.getInstance().show(Notifications.Type.SUCCESS, "Usuario creado Correctamente");
                            } else {
                                pc.closePopup();
                            }
                        }),
                option
        );
    }//GEN-LAST:event_btn_crearActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Vista_Usuarios.table.ButtonAction btn_crear;
    private Vista_Usuarios.table.ButtonAction btn_editar;
    private Vista_Usuarios.table.ButtonAction btn_eliminar;
    private javax.swing.JPanel contenedor;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl_titulo;
    private javax.swing.JPanel panel;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTextField txt_busqueda;
    // End of variables declaration//GEN-END:variables

    private void cargarProductos() {
        ProductoDAO productoDAO = new ProductoDAO();
        List<Producto> productos = productoDAO.obtenerTodosLosProductos();
        productos.forEach(producto -> {
            CartaProductosMan cartaProductosMan = new CartaProductosMan(producto);
            cartaProductosMan.setPreferredSize(new java.awt.Dimension(300, 500));
            contenedor.add(cartaProductosMan);
        });
        contenedor.revalidate();
        contenedor.repaint();
    }
}
