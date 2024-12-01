package Vista_Productos;

import Modelo.Categoria;
import Modelo.ColorRopa;
import Modelo.Perfil;
import Modelo.Producto;
import Modelo.ProductoInventario;
import Modelo.Talla;
import Persistencia.CategoriaDAO;
import Persistencia.ProductoInventarioDAO;
import Vista_Productos.componentes.ImageTableListRenderer;
import com.formdev.flatlaf.FlatClientProperties;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import jnafilechooser.api.JnaFileChooser;
import raven.popup.DefaultOption;
import raven.popup.GlassPanePopup;
import raven.popup.component.SimplePopupBorder;
import raven.popup.component.SimplePopupBorderOption;
import raven.toast.Notifications;

public class Crear extends javax.swing.JPanel {
    
    private Producto productoCargado;
    Perfil fotoPrincipal;
    
    public Crear() {
        initComponents();
        init();
        panelImagen.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:0,0,0,0,$Component.borderColor,,10;"
                + "background:$TextArea.background");
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        List<Categoria> categorias = categoriaDAO.obtenerTodasLasCategorias();
        categorias.forEach(categoria -> cbo_categoria.addItem(categoria));
        this.btn_inactivo.setSelected(true);
        tablaVariantes.getColumnModel().getColumn(0).setMinWidth(0);
        tablaVariantes.getColumnModel().getColumn(0).setMaxWidth(0);
        tablaVariantes.getColumnModel().getColumn(0).setWidth(0);
    }
    
    private void init() {
        tablaVariantes.getTableHeader().putClientProperty(FlatClientProperties.STYLE, ""
                + "height:30;"
                + "hoverBackground:null;"
                + "pressedBackground:null;"
                + "separatorColor:$TableHeader.background;"
                + "font:bold;");
        
        tablaVariantes.putClientProperty(FlatClientProperties.STYLE, ""
                + "rowHeight:100;"
                + "showHorizontalLines:true;"
                + "intercellSpacing:0,1;"
                + "cellFocusColor:$TableHeader.hoverBackground;"
                + "selectionBackground:$TableHeader.hoverBackground;"
                + "selectionForeground:$Table.foreground;");
        tablaVariantes.getColumnModel().getColumn(4).setCellRenderer(new ImageTableListRenderer(tablaVariantes));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoEstadoPromocion = new javax.swing.ButtonGroup();
        txt_nombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbo_categoria = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_precioCompra = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_PrecioVenta = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        btn_inactivo = new javax.swing.JRadioButton();
        btn_activo = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaVariantes = new javax.swing.JTable();
        buttonAction1 = new Vista_Usuarios.table.ButtonAction();
        btn_crearVariante = new Vista_Usuarios.table.ButtonAction();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_descripcion = new javax.swing.JTextArea();
        panelImagen = new javax.swing.JPanel();
        imagen = new javaswingdev.picturebox.PictureBox();
        jToolBar1 = new javax.swing.JToolBar();
        btn_seleccionar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 6, 230, -1));

        jLabel3.setText("Nombre");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 6, -1, -1));

        add(cbo_categoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 46, 230, -1));

        jLabel4.setText("Categoria");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 46, -1, -1));

        jLabel5.setText("Precio Compra");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 164, -1, -1));
        add(txt_precioCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 230, 26));

        jLabel7.setText("Foto");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 352, -1, -1));
        add(txt_PrecioVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 202, 230, 28));

        jLabel8.setText("Precio Venta");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 202, -1, -1));

        grupoEstadoPromocion.add(btn_inactivo);
        btn_inactivo.setText("Inactivo");
        btn_inactivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_inactivoActionPerformed(evt);
            }
        });
        add(btn_inactivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 242, -1, -1));

        grupoEstadoPromocion.add(btn_activo);
        btn_activo.setText("Activo");
        add(btn_activo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 242, -1, -1));

        jLabel10.setText("Promoción");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 242, -1, -1));

        jLabel15.setText("Variantes");
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, -1, -1));

        tablaVariantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Talla", "Color", "Stock", "Fotos"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaVariantes.getColumnModel().getColumn(3).setCellRenderer(new ImageTableListRenderer(tablaVariantes));
        tablaVariantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaVariantesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaVariantes);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, 650, 470));

        buttonAction1.setText("Eliminar");
        add(buttonAction1, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 10, -1, -1));

        btn_crearVariante.setText("Agregar");
        btn_crearVariante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_crearVarianteActionPerformed(evt);
            }
        });
        add(btn_crearVariante, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 10, -1, -1));

        jLabel1.setText("Descripción");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        txt_descripcion.setColumns(20);
        txt_descripcion.setRows(5);
        jScrollPane1.setViewportView(txt_descripcion);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 230, 80));

        panelImagen.setLayout(new java.awt.BorderLayout());

        jToolBar1.setRollover(true);
        jToolBar1.setOpaque(false);

        btn_seleccionar.setText("Seleccionar");
        btn_seleccionar.setFocusable(false);
        btn_seleccionar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_seleccionar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_seleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_seleccionarActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_seleccionar);

        jButton2.setText("Eliminar");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        javax.swing.GroupLayout imagenLayout = new javax.swing.GroupLayout(imagen);
        imagen.setLayout(imagenLayout);
        imagenLayout.setHorizontalGroup(
            imagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, imagenLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        imagenLayout.setVerticalGroup(
            imagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imagenLayout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(172, Short.MAX_VALUE))
        );

        panelImagen.add(imagen, java.awt.BorderLayout.CENTER);

        add(panelImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 356, 210, 210));
    }// </editor-fold>//GEN-END:initComponents

    private void btn_crearVarianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_crearVarianteActionPerformed
        
        if (productoCargado != null) {
            CrearVariantes crearVariantes = new CrearVariantes();
            DefaultOption option = new DefaultOption() {
                @Override
                public boolean closeWhenClickOutside() {
                    return true;
                }
            };
            String actions[] = new String[]{"Cancelar", "Guardar"};
            GlassPanePopup.showPopup(
                    new SimplePopupBorder(crearVariantes, "Crear Producto", actions, (pc, i) -> {
                        if (i == 1) {
                            DefaultTableModel model = (DefaultTableModel) tablaVariantes.getModel();
                            Object[] nuevosDatos = crearVariantes.obtenerDatos();
                            if (esValorDuplicadoEnTabla(model, nuevosDatos)) {
                                Notifications.getInstance().show(Notifications.Type.ERROR, "Esta variante ya existe en la tabla");
                            } else {
                                ProductoInventario productoInventario = new ProductoInventario();
                                productoInventario.setProducto(productoCargado);
                                productoInventario.setTalla((Talla) nuevosDatos[1]);
                                productoInventario.setColorRopa((ColorRopa) nuevosDatos[2]);
                                productoInventario.setStock((int) nuevosDatos[3]);
                                productoInventario.setFotos((List<Perfil>) nuevosDatos[4]);
                                ProductoInventarioDAO productoInventarioDAO = new ProductoInventarioDAO();
                                productoInventarioDAO.crearProductoInventario(productoInventario);
                                model.addRow(nuevosDatos);
                                cargarVariantes();
                                pc.closePopup();
                            }
                        } else {
                            pc.closePopup();
                        }
                    }),
                    option
            );
        } else {
            CrearVariantes crearVariantes = new CrearVariantes();
            DefaultOption option = new DefaultOption() {
                @Override
                public boolean closeWhenClickOutside() {
                    return true;
                }
            };
            String actions[] = new String[]{"Cancelar", "Guardar"};
            GlassPanePopup.showPopup(
                    new SimplePopupBorder(crearVariantes, "Crear Producto", actions, (pc, i) -> {
                        if (i == 1) {
                            DefaultTableModel model = (DefaultTableModel) tablaVariantes.getModel();
                            Object[] nuevosDatos = crearVariantes.obtenerDatos();
                            if (esValorDuplicadoEnTabla(model, nuevosDatos)) {
                                Notifications.getInstance().show(Notifications.Type.ERROR, "Esta variante ya existe en la tabla");
                            } else {
                                model.addRow(nuevosDatos);
                                pc.closePopup();
                            }
                        } else {
                            pc.closePopup();
                        }
                    }),
                    option
            );
        }
    }//GEN-LAST:event_btn_crearVarianteActionPerformed

    private void btn_seleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_seleccionarActionPerformed
        // TODO add your handling code here:
        JnaFileChooser ch = new JnaFileChooser();
        ch.addFilter("Image", "png", "jpg", "jpeg");
        boolean act = ch.showOpenDialog(SwingUtilities.getWindowAncestor(this));
        if (act) {
            File file = ch.getSelectedFile();
            fotoPrincipal = new Perfil(file.getAbsolutePath(), file);
            imagen.setImage(new ImageIcon(file.getAbsolutePath()));
        }
    }//GEN-LAST:event_btn_seleccionarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        fotoPrincipal = null;
        imagen.setImage(null);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btn_inactivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_inactivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_inactivoActionPerformed

    private void tablaVariantesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaVariantesMouseClicked
        // Verificar si se seleccionó una fila
        int filaSeleccionada = tablaVariantes.getSelectedRow();
        if (filaSeleccionada == -1) {
            Notifications.getInstance().show(Notifications.Type.WARNING, "Selecciona una variante.");
            return;
        }
        int idVariante = (int) tablaVariantes.getValueAt(filaSeleccionada, 0); // Columna oculta del id
        Talla talla = (Talla) tablaVariantes.getValueAt(filaSeleccionada, 1);
        ColorRopa colorRopa = (ColorRopa) tablaVariantes.getValueAt(filaSeleccionada, 2);
        int cantidad = (int) tablaVariantes.getValueAt(filaSeleccionada, 3);
        List<Perfil> imagenes = (List<Perfil>) tablaVariantes.getValueAt(filaSeleccionada, 4);
        ProductoInventario productoInventario = new ProductoInventario();
        productoInventario.setIdVariante(idVariante);
        productoInventario.setTalla(talla);
        productoInventario.setColorRopa(colorRopa);
        productoInventario.setStock(cantidad);
        productoInventario.setFotos(imagenes);
        CrearVariantes crearVariantes = new CrearVariantes();
        crearVariantes.cargarDatos(productoInventario);
        DefaultOption option = new DefaultOption() {
            @Override
            public boolean closeWhenClickOutside() {
                return true;
            }
        };
        String actions[] = new String[]{"Cancelar", "Actualizar"};
        
        GlassPanePopup.showPopup(
                new SimplePopupBorder(crearVariantes, "Editar Variante",
                        new SimplePopupBorderOption()
                                .setRoundBorder(30) // Esquinas redondeadas con un radio de 30 píxeles
                                .useScroll(), // Habilitar desplazamiento si es necesario
                        actions,
                        (pc, i) -> {
                            if (i == 1) {
                                // Obtener datos actualizados desde el formulario
                                Object[] datosActualizados = crearVariantes.obtenerDatos();
                                // Actualizar la fila seleccionada en la tabla, manteniendo el idVariante
                                DefaultTableModel modelo = (DefaultTableModel) tablaVariantes.getModel();
                                modelo.setValueAt(datosActualizados[0], filaSeleccionada, 0); // Mantener el idVariante
                                modelo.setValueAt(datosActualizados[1], filaSeleccionada, 1); // Talla
                                modelo.setValueAt(datosActualizados[2], filaSeleccionada, 2); // Color
                                modelo.setValueAt(datosActualizados[3], filaSeleccionada, 3); // Stock
                                modelo.setValueAt(datosActualizados[4], filaSeleccionada, 4); // Fotos
                                ProductoInventario productoInventarioActualizado = new ProductoInventario();
                                productoInventarioActualizado.setIdVariante((int) datosActualizados[0]);
                                productoInventarioActualizado.setProducto(productoCargado);
                                productoInventarioActualizado.setTalla((Talla) datosActualizados[1]);
                                productoInventarioActualizado.setColorRopa((ColorRopa) datosActualizados[2]);
                                productoInventarioActualizado.setStock((int) datosActualizados[3]);
                                productoInventarioActualizado.setFotos((List<Perfil>) datosActualizados[4]);
                                ProductoInventarioDAO productoInventarioDAO = new ProductoInventarioDAO();
                                if (productoInventarioDAO.actualizarProductoInventario(productoInventarioActualizado)) {
                                    Notifications.getInstance().show(Notifications.Type.SUCCESS, "Variante actualizada correctamente.");
                                }
                                cargarVariantes();
                                pc.closePopup();
                            } else {
                                pc.closePopup();
                            }
                        }),
                option
        );

    }//GEN-LAST:event_tablaVariantesMouseClicked
    
    private boolean esValorDuplicadoEnTabla(DefaultTableModel modelo, Object[] nuevosDatos) {
        int filas = modelo.getRowCount();
        for (int i = 0; i < filas; i++) {
            Talla tallaExistente = (Talla) modelo.getValueAt(i, 1);
            ColorRopa colorExistente = (ColorRopa) modelo.getValueAt(i, 2);
            Talla tallaNueva = (Talla) nuevosDatos[1];
            ColorRopa colorNuevo = (ColorRopa) nuevosDatos[2];
            if (tallaExistente.equals(tallaNueva) && colorExistente.equals(colorNuevo)) {
                return true;
            }
        }
        return false;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton btn_activo;
    private Vista_Usuarios.table.ButtonAction btn_crearVariante;
    private javax.swing.JRadioButton btn_inactivo;
    private javax.swing.JButton btn_seleccionar;
    private Vista_Usuarios.table.ButtonAction buttonAction1;
    private javax.swing.JComboBox<Categoria> cbo_categoria;
    private javax.swing.ButtonGroup grupoEstadoPromocion;
    private javaswingdev.picturebox.PictureBox imagen;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JPanel panelImagen;
    private javax.swing.JTable tablaVariantes;
    private javax.swing.JFormattedTextField txt_PrecioVenta;
    private javax.swing.JTextArea txt_descripcion;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JFormattedTextField txt_precioCompra;
    // End of variables declaration//GEN-END:variables

    public Producto obtenerProducto() {
        String nombre = txt_nombre.getText();
        String descripcon = txt_descripcion.getText();
        double precioCompra = Double.parseDouble(txt_precioCompra.getText());
        double precioVenta = Double.parseDouble(txt_PrecioVenta.getText());
        boolean estadoPromocion = btn_activo.isSelected();
        Categoria categoria = (Categoria) cbo_categoria.getSelectedItem();
        Producto producto = new Producto();
        if (productoCargado != null) {
            producto.setId(productoCargado.getId());
        }
        producto.setNombre(nombre);
        producto.setDescripcion(descripcon);
        producto.setCategoria(categoria);
        producto.setPrecioCompra(precioCompra);
        producto.setPrecioVenta(precioVenta);
        producto.setEstadoPromocion(estadoPromocion);
        if (fotoPrincipal != null) {
            producto.setFotoPrincipal(fotoPrincipal);
        }
        return producto;
    }
    
    public List<ProductoInventario> obtenerVarianteProducto() {
        List<ProductoInventario> variantes = new ArrayList<>();
        DefaultTableModel model = (DefaultTableModel) tablaVariantes.getModel();

        // Verificar si la tabla tiene datos
        if (model.getRowCount() == 0) {
            return variantes; // Retorna una lista vacía si no hay filas
        }

        // Recorrer cada fila
        for (int i = 0; i < model.getRowCount(); i++) {
            ProductoInventario inventario = new ProductoInventario();

            // Obtener el idVariante desde la columna oculta
            int idVariante = (int) model.getValueAt(i, 0); // Columna oculta del id
            Talla talla = (Talla) model.getValueAt(i, 1); // Columna Talla
            ColorRopa color = (ColorRopa) model.getValueAt(i, 2); // Columna Color
            int stock = (int) model.getValueAt(i, 3); // Columna Stock
            List<Perfil> fotos = (List<Perfil>) model.getValueAt(i, 4); // Columna Fotos

            // Establecer los valores en el objeto ProductoInventario
            inventario.setIdVariante(idVariante);
            inventario.setTalla(talla);
            inventario.setColorRopa(color);
            inventario.setStock(stock);
            inventario.setFotos(fotos);

            // Agregar a la lista
            variantes.add(inventario);
        }
        return variantes;
    }
    
    public void cargarDatos(Producto producto) {
        this.productoCargado = producto;
        txt_nombre.setText(producto.getNombre());
        cbo_categoria.setSelectedItem(producto.getCategoria());
        txt_descripcion.setText(producto.getDescripcion());
        txt_precioCompra.setText(String.valueOf(producto.getPrecioCompra()));
        txt_PrecioVenta.setText(String.valueOf(producto.getPrecioVenta()));
        fotoPrincipal = producto.getFotoPrincipal();
        if (fotoPrincipal != null) {
            imagen.setImage(fotoPrincipal.getIcon());
        } else {
            imagen.setImage(null);
        }
        if (productoCargado != null) {
            cargarVariantes();
        }
    }
    
    public void cargarVariantes() {
        ProductoInventarioDAO productoInventarioDAO = new ProductoInventarioDAO();
        List<ProductoInventario> variantes = productoInventarioDAO.obtenerVariantePorIdProducto(productoCargado);
        DefaultTableModel modelo = (DefaultTableModel) tablaVariantes.getModel();
        modelo.setRowCount(0); // Limpiar la tabla antes de cargar nuevos datos
        // Agregar cada variante con su id (incluido pero oculto)
        variantes.stream().map(variante -> new Object[]{
            variante.getIdVariante(), // Columna oculta
            variante.getTalla(),
            variante.getColorRopa(),
            variante.getStock(),
            variante.getFotos()
        }).forEach(modelo::addRow);
        tablaVariantes.setModel(modelo);
    }
}
