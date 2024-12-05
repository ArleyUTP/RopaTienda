package Vista_Orden;

import Modelo.Cliente;
import com.formdev.flatlaf.FlatClientProperties;

public class GenerarOrder extends javax.swing.JPanel {

    private Cliente cliente;

    public GenerarOrder() {
        initComponents();
        init();
    }

    private void init() {
        txt_buscarClienteExistente.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Buscar Cliente Existente....");
        txt_nombre.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Nombre*");
        txt_numeroDocumento.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "N° de documento*");
        txt_telefono.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Telefono*");
        txt_email.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Email*");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        panelPrincipal = new javax.swing.JPanel();
        panelCentrar = new javax.swing.JPanel();
        panelInformacionOrder = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        panelInformacion = new javax.swing.JPanel();
        txt_numeroDocumento = new javax.swing.JTextField();
        cbo_provincia = new javax.swing.JComboBox<>();
        cbo_tipo_pago = new javax.swing.JComboBox<>();
        cbo_distrito = new javax.swing.JComboBox<>();
        txt_email = new javax.swing.JTextField();
        cbo_departamento = new javax.swing.JComboBox<>();
        txt_telefono = new javax.swing.JTextField();
        cbo_tipoDocumento = new javax.swing.JComboBox<>();
        txt_nombre = new javax.swing.JTextField();
        btn_generarOrden = new javax.swing.JButton();
        txt_buscarClienteExistente = new javax.swing.JTextField();
        cbo_clienteExistente = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setMinimumSize(new java.awt.Dimension(462, 540));
        setPreferredSize(new java.awt.Dimension(1049, 450));
        setLayout(new java.awt.BorderLayout());

        panelPrincipal.setLayout(new java.awt.BorderLayout());

        panelCentrar.setPreferredSize(new java.awt.Dimension(1070, 450));
        panelCentrar.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        panelInformacionOrder.setPreferredSize(new java.awt.Dimension(600, 424));
        panelInformacionOrder.setRequestFocusEnabled(false);
        panelInformacionOrder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbo_provincia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbo_provincia.setBorder(javax.swing.BorderFactory.createTitledBorder("Provincia"));

        cbo_tipo_pago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbo_tipo_pago.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo De Pago"));

        cbo_distrito.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbo_distrito.setBorder(javax.swing.BorderFactory.createTitledBorder("Distrito"));

        cbo_departamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbo_departamento.setBorder(javax.swing.BorderFactory.createTitledBorder("Departamento"));

        cbo_tipoDocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un Tipo de Documento", "DNI", "Cédula de Identidad", "Pasaporte", "Licencia de Conducir", "Tarjeta de Residencia", "Identificación Militar", "Carnet de Estudiante", "Identificación de Trabajador", " " }));
        cbo_tipoDocumento.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo de Documento"));

        btn_generarOrden.setText("Crear Orden");

        cbo_clienteExistente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbo_clienteExistenteMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelInformacionLayout = new javax.swing.GroupLayout(panelInformacion);
        panelInformacion.setLayout(panelInformacionLayout);
        panelInformacionLayout.setHorizontalGroup(
            panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInformacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_nombre)
                    .addComponent(cbo_departamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbo_provincia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbo_distrito, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbo_tipo_pago, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_generarOrden, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_telefono)
                    .addGroup(panelInformacionLayout.createSequentialGroup()
                        .addComponent(txt_buscarClienteExistente, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbo_clienteExistente, 0, 347, Short.MAX_VALUE))
                    .addComponent(txt_email)
                    .addComponent(txt_numeroDocumento)
                    .addComponent(cbo_tipoDocumento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelInformacionLayout.setVerticalGroup(
            panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInformacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_buscarClienteExistente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbo_clienteExistente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbo_tipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_numeroDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(cbo_departamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbo_provincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbo_distrito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbo_tipo_pago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_generarOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(panelInformacion);

        panelInformacionOrder.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 590, 410));

        panelCentrar.add(panelInformacionOrder);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número Pedido", "Fecha Emisión", "Importe Total", "Estado", "Generar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        panelCentrar.add(jScrollPane1);

        panelPrincipal.add(panelCentrar, java.awt.BorderLayout.CENTER);

        jScrollPane3.setViewportView(panelPrincipal);

        add(jScrollPane3, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void cbo_clienteExistenteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbo_clienteExistenteMouseClicked

        Cliente clienteSeleccionado = (Cliente) cbo_clienteExistente.getSelectedItem();
        this.cliente=clienteSeleccionado;
        if (cliente!= null) {
            txt_nombre.setText(cliente.getNombre());
            cbo_tipoDocumento.setSelectedItem(cliente.getTipoDocumento());
            String[] direccion = cliente.getDireccion().split("/");
            cbo_departamento.setSelectedItem(direccion[0]);
            cbo_provincia.setSelectedItem(direccion[1]);
            cbo_distrito.setSelectedItem(direccion[2]);
            txt_telefono.setText(cliente.getTelefono());
            txt_email.setText(cliente.getEmail());
        }
    }//GEN-LAST:event_cbo_clienteExistenteMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_generarOrden;
    private javax.swing.JComboBox<Cliente> cbo_clienteExistente;
    private javax.swing.JComboBox<String> cbo_departamento;
    private javax.swing.JComboBox<String> cbo_distrito;
    private javax.swing.JComboBox<String> cbo_provincia;
    private javax.swing.JComboBox<String> cbo_tipoDocumento;
    private javax.swing.JComboBox<String> cbo_tipo_pago;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel panelCentrar;
    private javax.swing.JPanel panelInformacion;
    private javax.swing.JPanel panelInformacionOrder;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JTextField txt_buscarClienteExistente;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_numeroDocumento;
    private javax.swing.JTextField txt_telefono;
    // End of variables declaration//GEN-END:variables
}
