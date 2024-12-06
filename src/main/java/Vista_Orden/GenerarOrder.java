package Vista_Orden;

import Modelo.Cliente;
import Modelo.Departamento;
import Modelo.Distrito;
import Modelo.OrdenPedido;
import Modelo.Provincia;
import Persistencia.ClienteDAO;
import Persistencia.DepartamentoDAO;
import Persistencia.DistritoDAO;
import Persistencia.OrdenPedidoDAO;
import Persistencia.ProvinciaDAO;

import java.util.List;

import com.formdev.flatlaf.FlatClientProperties;
import javax.swing.DefaultComboBoxModel;
import raven.toast.Notifications;

public class GenerarOrder extends javax.swing.JPanel {

    private Cliente cliente;
    private Modelo.CarritoCompras carritoCompra;

    public GenerarOrder(Modelo.CarritoCompras carritoCompras) {
        this.carritoCompra = carritoCompras;
        initComponents();
        init();
        cargarDepartamentos();
        cargarClientesExistentes();
    }

    private void init() {
        txt_buscarClienteExistente.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Buscar Cliente Existente....");
        txt_nombre.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Nombre*");
        txt_numeroDocumento.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "N° de documento*");
        txt_telefono.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Telefono*");
        txt_email.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Email*");
        cbo_departamento.addActionListener(e -> {
            if (cbo_departamento.getSelectedIndex() > 0) { // Evita "Seleccione un Departamento"
                Departamento departamentoSeleccionado = (Departamento) cbo_departamento.getSelectedItem();
                cargarProvincias(departamentoSeleccionado);
            } else {
                cbo_provincia.removeAllItems(); // Limpia las provincias si no hay selección válida
                cbo_distrito.removeAllItems(); // Limpia los distritos también
            }
        });
        cbo_provincia.addActionListener(e -> {
            if (cbo_provincia.getSelectedIndex() > 0) { // Evita "Seleccione una Provincia"
                Provincia provinciaSeleccionada = (Provincia) cbo_provincia.getSelectedItem();
                cargarDistritos(provinciaSeleccionada);
            } else {
                cbo_distrito.removeAllItems(); // Limpia los distritos si no hay selección válida
            }
        });
    }

    private void cargarDepartamentos() {
        DepartamentoDAO departamentoDAO = new DepartamentoDAO();
        List<Departamento> departamentos = departamentoDAO.obtenerDepartamentos();
        cbo_departamento.removeAllItems(); // Limpia el combo
        cbo_departamento.addItem(new Departamento(0, "Seleccione un Departamento")); // Elemento por defecto
        departamentos.forEach(departamento -> cbo_departamento.addItem(departamento));
    }

    private void cargarProvincias(Departamento departamento) {
        ProvinciaDAO provinciaDAO = new ProvinciaDAO();
        List<Provincia> provincias = provinciaDAO.obtenerProvinciasPorDepartamento(departamento);
        cbo_provincia.removeAllItems(); // Limpia el combo
        cbo_provincia.addItem(new Provincia(0, "Seleccione una Provincia")); // Elemento por defecto
        if (provincias != null) {
            provincias.forEach(provincia -> cbo_provincia.addItem(provincia));
        }
    }

    private void cargarDistritos(Provincia provincia) {
        DistritoDAO distritoDAO = new DistritoDAO();
        List<Distrito> distritos = distritoDAO.obtenerDistritosPorProvincia(provincia);
        cbo_distrito.removeAllItems(); // Limpia el combo
        cbo_distrito.addItem(new Distrito(0, "Seleccione un Distrito")); // Elemento por defecto
        distritos.forEach(distrito -> cbo_distrito.addItem(distrito));
    }

    private void cargarClientesExistentes() {
        ClienteDAO clienteDAO = new ClienteDAO();
        List<Cliente> listaClientes = clienteDAO.obtenerTodos();
        DefaultComboBoxModel<Cliente> modeloCombo = new DefaultComboBoxModel<>();
        for (Cliente clienteExistente : listaClientes) {
            modeloCombo.addElement(clienteExistente);
        }
        cbo_clienteExistente.setModel(modeloCombo);
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
        cbo_tipoDocumento = new javax.swing.JComboBox<>();
        txt_nombre = new javax.swing.JTextField();
        btn_generarOrden = new javax.swing.JButton();
        txt_buscarClienteExistente = new javax.swing.JTextField();
        cbo_clienteExistente = new javax.swing.JComboBox<>();
        txt_telefono = new javax.swing.JFormattedTextField();

        setMinimumSize(new java.awt.Dimension(462, 540));
        setPreferredSize(new java.awt.Dimension(1049, 430));
        setLayout(new java.awt.BorderLayout());

        panelPrincipal.setLayout(new java.awt.BorderLayout());

        panelCentrar.setPreferredSize(new java.awt.Dimension(1070, 450));
        panelCentrar.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        panelInformacionOrder.setPreferredSize(new java.awt.Dimension(620, 424));
        panelInformacionOrder.setRequestFocusEnabled(false);
        panelInformacionOrder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbo_provincia.setBorder(javax.swing.BorderFactory.createTitledBorder("Provincia"));
        cbo_provincia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbo_provinciaMouseClicked(evt);
            }
        });

        cbo_tipo_pago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un Tipo de Pago", "Efectivo", "Tarjeta de Crédito", "Tarjet de Débito", "Transferencia Bancaria", "Depósito Bancario", "Pago en Línea", "Yape", "Plin" }));
        cbo_tipo_pago.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo De Pago"));

        cbo_distrito.setBorder(javax.swing.BorderFactory.createTitledBorder("Distrito"));

        cbo_departamento.setBorder(javax.swing.BorderFactory.createTitledBorder("Departamento"));
        cbo_departamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbo_departamentoMouseClicked(evt);
            }
        });

        cbo_tipoDocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un Tipo de Documento", "DNI", "Cédula de Identidad", "Pasaporte", "Licencia de Conducir", "Tarjeta de Residencia", "Identificación Militar", "Carnet de Estudiante", "Identificación de Trabajador", " " }));
        cbo_tipoDocumento.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo de Documento"));

        btn_generarOrden.setText("Crear Orden");
        btn_generarOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_generarOrdenActionPerformed(evt);
            }
        });

        cbo_clienteExistente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbo_clienteExistenteMouseClicked(evt);
            }
        });

        txt_telefono.setPreferredSize(new java.awt.Dimension(5, 24));

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
                    .addGroup(panelInformacionLayout.createSequentialGroup()
                        .addComponent(txt_buscarClienteExistente, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbo_clienteExistente, 0, 347, Short.MAX_VALUE))
                    .addComponent(txt_email)
                    .addComponent(txt_numeroDocumento)
                    .addComponent(cbo_tipoDocumento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_telefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGap(4, 4, 4)
                .addComponent(txt_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbo_tipo_pago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_generarOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(panelInformacion);

        panelInformacionOrder.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 620, 410));

        panelCentrar.add(panelInformacionOrder);

        panelPrincipal.add(panelCentrar, java.awt.BorderLayout.CENTER);

        jScrollPane3.setViewportView(panelPrincipal);

        add(jScrollPane3, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void cbo_clienteExistenteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbo_clienteExistenteMouseClicked
        Cliente clienteSeleccionado = (Cliente) cbo_clienteExistente.getSelectedItem();
        this.cliente = clienteSeleccionado;
        if (cliente != null) {
            txt_nombre.setText(cliente.getNombre());
            cbo_tipoDocumento.setSelectedItem(cliente.getTipoDocumento());
            txt_numeroDocumento.setText(cliente.getNumeroDocumento());
            cbo_departamento.setSelectedItem(cliente.getDepartamento());
            cbo_provincia.setSelectedItem(cliente.getProvincia());
            cbo_distrito.setSelectedItem(cliente.getDistrito());
            txt_telefono.setText(cliente.getTelefono());
            txt_email.setText(cliente.getEmail());
        }
    }//GEN-LAST:event_cbo_clienteExistenteMouseClicked

    private void cbo_departamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbo_departamentoMouseClicked

    }//GEN-LAST:event_cbo_departamentoMouseClicked

    private void cbo_provinciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbo_provinciaMouseClicked

    }//GEN-LAST:event_cbo_provinciaMouseClicked

    private void btn_generarOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_generarOrdenActionPerformed
        if (cliente != null && carritoCompra != null) {
            OrdenPedidoDAO ordenPedidoDAO = new OrdenPedidoDAO();
            OrdenPedido ordenPedido = new OrdenPedido();
            ordenPedido.setCliente(cliente);
            ordenPedido.setVendedor(carritoCompra.getUsuario());
            ordenPedido.setCarritoCompras(carritoCompra);
            ordenPedido.setForma_pago(cbo_tipo_pago.getSelectedItem().toString());
            if (ordenPedidoDAO.GenerarOrdenPedido(ordenPedido)) {
                Notifications.getInstance().show(Notifications.Type.SUCCESS, "Orden Generada Correctamente");
            }
        } else if (cliente == null && carritoCompra != null) {
            if (cbo_tipoDocumento.getSelectedIndex() > 0 && cbo_departamento.getSelectedIndex() > 0 && cbo_provincia.getSelectedIndex() > 0 && cbo_distrito.getSelectedIndex() > 0) {
                // Crear nuevo cliente
                Cliente nuevoCliente = new Cliente();
                nuevoCliente.setNombre(txt_nombre.getText());
                nuevoCliente.setTipoDocumento(cbo_tipoDocumento.getSelectedItem().toString());
                nuevoCliente.setNumeroDocumento(txt_numeroDocumento.getText());
                nuevoCliente.setDepartamento((Departamento) cbo_departamento.getSelectedItem());
                nuevoCliente.setProvincia((Provincia) cbo_provincia.getSelectedItem());
                nuevoCliente.setDistrito((Distrito) cbo_distrito.getSelectedItem());
                nuevoCliente.setTelefono(txt_telefono.getText());
                nuevoCliente.setEmail(txt_email.getText());
                ClienteDAO clienteDAO = new ClienteDAO();
                clienteDAO.guardarCliente(nuevoCliente); // Método a implementar
                this.cliente = nuevoCliente;
                btn_generarOrdenActionPerformed(evt);
            }
        } else {
            System.out.println("Hay algo Nulo");
        }
    }//GEN-LAST:event_btn_generarOrdenActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_generarOrden;
    private javax.swing.JComboBox<Cliente> cbo_clienteExistente;
    private javax.swing.JComboBox<Departamento> cbo_departamento;
    private javax.swing.JComboBox<Distrito> cbo_distrito;
    private javax.swing.JComboBox<Provincia> cbo_provincia;
    private javax.swing.JComboBox<String> cbo_tipoDocumento;
    private javax.swing.JComboBox<String> cbo_tipo_pago;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel panelCentrar;
    private javax.swing.JPanel panelInformacion;
    private javax.swing.JPanel panelInformacionOrder;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JTextField txt_buscarClienteExistente;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_numeroDocumento;
    private javax.swing.JFormattedTextField txt_telefono;
    // End of variables declaration//GEN-END:variables
}
