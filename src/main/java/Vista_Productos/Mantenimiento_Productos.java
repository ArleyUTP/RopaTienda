package Vista_Productos;

import Modelo.Producto;
import Persistencia.CategoriaDAO;
import Persistencia.ProductoDAO;
import Vista_Usuarios.table.CheckBoxTableHeaderRenderer;
import Vista_Usuarios.table.TableHeaderAlignment;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import raven.popup.DefaultOption;
import raven.popup.GlassPanePopup;
import raven.popup.component.SimplePopupBorder;
import raven.popup.component.SimplePopupBorderOption;
import raven.toast.Notifications;

public class Mantenimiento_Productos extends javax.swing.JPanel {

    public Mantenimiento_Productos() {
        initComponents();
        init();
        cargaDatosTabla();
    }

    private void init() {
        panel.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:25;"
                + "background:$Table.background");
        table.getTableHeader().putClientProperty(FlatClientProperties.STYLE, ""
                + "height:30;"
                + "hoverBackground:null;"
                + "pressedBackground:null;"
                + "separatorColor:$TableHeader.background;"
                + "font:bold;");

        table.putClientProperty(FlatClientProperties.STYLE, ""
                + "rowHeight:70;"
                + "showHorizontalLines:true;"
                + "intercellSpacing:0,1;"
                + "cellFocusColor:$TableHeader.hoverBackground;"
                + "selectionBackground:$TableHeader.hoverBackground;"
                + "selectionForeground:$Table.foreground;");
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
        table.getColumnModel().getColumn(0).setHeaderRenderer(new CheckBoxTableHeaderRenderer(table, 0));
        table.getTableHeader().setDefaultRenderer(new TableHeaderAlignment(table));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        scroll = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        lbl_titulo = new javax.swing.JLabel();
        txt_busqueda = new javax.swing.JTextField();
        btn_eliminar = new Vista_Usuarios.table.ButtonAction();
        btn_editar = new Vista_Usuarios.table.ButtonAction();
        btn_crear = new Vista_Usuarios.table.ButtonAction();

        scroll.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "SELECT", "#", "codigo", "Nombre", "Categoria", "Stock", "Stock Minimo", "Precio Compra", "Precio Venta", "Estado Promoción", "F. Caducida P.", "Foto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.getTableHeader().setReorderingAllowed(false);
        scroll.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(2).setResizable(false);
        }

        lbl_titulo.setText("Usuarios");

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

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scroll)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_titulo)
                            .addComponent(txt_busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(300, 345, Short.MAX_VALUE)
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
                .addGap(0, 0, 0)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 8, Short.MAX_VALUE)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_busquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busquedaKeyReleased
    }//GEN-LAST:event_txt_busquedaKeyReleased

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        List<Producto> selectedProducts = getSelectedProducts();
    
    // Verificar si hay productos seleccionados
    if (!selectedProducts.isEmpty()) {
        int dialogResult = JOptionPane.showConfirmDialog(this, "¿Estás seguro de eliminar los productos seleccionados?", "Confirmación", JOptionPane.YES_NO_OPTION);
        
        if (dialogResult == JOptionPane.YES_OPTION) {
            ProductoDAO productoDAO = new ProductoDAO();
            
            // Eliminar cada producto seleccionado
            for (Producto producto : selectedProducts) {
                productoDAO.eliminar(producto);
            }
            
            Notifications.getInstance().show(Notifications.Type.SUCCESS, "Producto(s) eliminado(s) exitosamente");
            cargarDatosTabla(); 
        }
            } else {
        Notifications.getInstance().show(Notifications.Type.WARNING, "Debes seleccionar al menos un producto para eliminar");
        }
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void btn_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarActionPerformed
        // Lista para almacenar los usuarios seleccionados en la tabla


    }//GEN-LAST:event_btn_editarActionPerformed

    private void btn_crearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_crearActionPerformed
        Vista_Productos.Crear crear = new Crear();
        crear.setPreferredSize(new Dimension(693, 570)); // Cambia el tamaño según sea necesario

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
                                .setWidth(693) // Cambia el ancho según sea necesario
                                .useScroll(), // Habilitar desplazamiento si es necesario
                        actions,
                        (pc, i) -> {
                            if (i == 1) {
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
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl_titulo;
    private javax.swing.JPanel panel;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTable table;
    private javax.swing.JTextField txt_busqueda;
    // End of variables declaration//GEN-END:variables

    private List<Producto> getSelectedProducts() throws NullPointerException {
    List<Producto> selectedProducts = new ArrayList<>();
    ProductoDAO productoDAO = new ProductoDAO();

    for (int i = 0; i < table.getRowCount(); i++) {
        Boolean isSelected = (Boolean) table.getValueAt(i, 0); // Columna de selección (Checkbox)
        if (isSelected != null && isSelected) {
            int productId = (Integer) table.getValueAt(i, 1); // Columna del ID del producto
            Producto producto = productoDAO.obtenerProductoPorId(productId); // Obtener el producto de la base de datos
            selectedProducts.add(producto);
        }
    }
        return selectedProducts;
    }

    
    public void cargaDatosTabla() {
        ProductoDAO productoDAO = new ProductoDAO();
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        DefaultTableModel modelo = (DefaultTableModel) table.getModel();
        modelo.setRowCount(0);
        List<Producto> productos = productoDAO.obtenerTodosLosProductos();
        productos.forEach(producto -> {
            modelo.addRow(new Object[]{
                false,
                producto.getId(),
                producto.getCodigo(),
                producto.getNombre(),
                categoriaDAO.obtenerCategoriaPorId(producto),
                producto.getStock(),
                producto.getStockMinimo(),
                producto.getPrecioCompra(),
                producto.getPrecioVenta(),
                producto.getEstadoPromocion(),
                producto.getFechaCaducidadPromoción(),
                producto.getFoto()
            });
        });
    }
}
