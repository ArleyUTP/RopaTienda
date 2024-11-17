package Vista_Productos;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.util.UIScale;
import java.awt.Rectangle;
import java.awt.Shape;
import javaswingdev.picturebox.DefaultPictureBoxRender;

public class Crear extends javax.swing.JPanel {

    public Crear() {
        initComponents();
        datePicker.setCloseAfterSelected(true);
        datePicker.setEditor(txt_fechaVencimientoPromocion);
                imagen.setPictureBoxRender(new DefaultPictureBoxRender() {
            @Override
            public Shape render(Rectangle rectangle) {
                return createRound(rectangle, UIScale.scale(10));
            }

        });
        panelImagen.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:0,0,0,0,$Component.borderColor,,10;"
                + "background:$TextArea.background");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoEstadoPromocion = new javax.swing.ButtonGroup();
        datePicker = new raven.datetime.component.date.DatePicker();
        jLabel2 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbo_categoria = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        spn_stock = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        spn_stockMinimo = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        txt_precioCompra = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_PrecioVenta = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        btn_inactivo = new javax.swing.JRadioButton();
        btn_activo = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        panelImagen = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txt_fechaVencimientoPromocion = new javax.swing.JFormattedTextField();
        contenedorColores = new javax.swing.JPanel();
        imagen = new javaswingdev.picturebox.PictureBox();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        buttonAction1 = new Vista_Usuarios.table.ButtonAction();
        buttonAction2 = new Vista_Usuarios.table.ButtonAction();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Stock");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 86, -1, -1));
        add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 6, 230, -1));

        jLabel3.setText("Nombre");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 6, -1, -1));

        add(cbo_categoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 46, 230, -1));

        jLabel4.setText("Categoria");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 46, -1, -1));
        add(spn_stock, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 86, 230, -1));

        jLabel5.setText("Precio Compra");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 164, -1, -1));
        add(spn_stockMinimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 126, 230, -1));

        jLabel6.setText("Stock Minimo");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 126, -1, -1));
        add(txt_precioCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 164, 230, 26));

        jLabel7.setText("Foto");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 352, -1, -1));
        add(txt_PrecioVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 202, 230, 28));

        jLabel8.setText("Precio Venta");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 202, -1, -1));

        grupoEstadoPromocion.add(btn_inactivo);
        btn_inactivo.setText("Inactivo");
        add(btn_inactivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 242, -1, -1));

        grupoEstadoPromocion.add(btn_activo);
        btn_activo.setText("Activo");
        add(btn_activo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 242, -1, -1));

        jLabel9.setText("Promoción");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 288, -1, -1));

        panelImagen.setLayout(new java.awt.BorderLayout());
        add(panelImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 568, 230, -1));

        jLabel10.setText("Promoción");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 242, -1, -1));
        add(txt_fechaVencimientoPromocion, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 288, 230, 28));

        javax.swing.GroupLayout contenedorColoresLayout = new javax.swing.GroupLayout(contenedorColores);
        contenedorColores.setLayout(contenedorColoresLayout);
        contenedorColoresLayout.setHorizontalGroup(
            contenedorColoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 272, Short.MAX_VALUE)
        );
        contenedorColoresLayout.setVerticalGroup(
            contenedorColoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        add(contenedorColores, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 406, -1, -1));

        jToolBar1.setRollover(true);
        jToolBar1.setOpaque(false);

        jButton1.setText("Seleccionar");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton1);

        jButton2.setText("Eliminar");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton2);

        javax.swing.GroupLayout imagenLayout = new javax.swing.GroupLayout(imagen);
        imagen.setLayout(imagenLayout);
        imagenLayout.setHorizontalGroup(
            imagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imagenLayout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        imagenLayout.setVerticalGroup(
            imagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imagenLayout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 155, Short.MAX_VALUE))
        );

        add(imagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 369, 230, -1));

        jLabel15.setText("Variantes");
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Talla", "Color", "Stock", "Precio Variante", "Foto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, 540, 90));

        buttonAction1.setText("Eliminar");
        add(buttonAction1, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 10, -1, -1));

        buttonAction2.setText("Agregar");
        add(buttonAction2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 10, -1, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton btn_activo;
    private javax.swing.JRadioButton btn_inactivo;
    private Vista_Usuarios.table.ButtonAction buttonAction1;
    private Vista_Usuarios.table.ButtonAction buttonAction2;
    private javax.swing.JComboBox<String> cbo_categoria;
    private javax.swing.JPanel contenedorColores;
    private raven.datetime.component.date.DatePicker datePicker;
    private javax.swing.ButtonGroup grupoEstadoPromocion;
    private javaswingdev.picturebox.PictureBox imagen;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JPanel panelImagen;
    private javax.swing.JSpinner spn_stock;
    private javax.swing.JSpinner spn_stockMinimo;
    private javax.swing.JFormattedTextField txt_PrecioVenta;
    private javax.swing.JFormattedTextField txt_fechaVencimientoPromocion;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JFormattedTextField txt_precioCompra;
    // End of variables declaration//GEN-END:variables
}
