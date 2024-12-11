package Reportes;

import Modelo.OrdenPedido;
import Persistencia.OrdenPedidoDAO;

public class Vista_Previa extends javax.swing.JFrame {

    public Vista_Previa(OrdenPedido ordenPedido) {
        initComponents();
        OrdenPedidoDAO ordenPedidoDAO = new OrdenPedidoDAO();
        ordenPedidoDAO.rellenarDatosVistaPrevia(ordenPedido, lbl_nombreCliente, lbl_nombreVededor, lbl_direccion, lbl_tipoDocumento, lbl_numeroDocumento, lbl_tipoPago);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        PanelPrincipal = new javax.swing.JPanel();
        PanelSuperior = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        lbl_tipoDocumento = new javax.swing.JLabel();
        PanelCentral = new javax.swing.JPanel();
        panelSuperioCentral = new javax.swing.JPanel();
        informacion1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lbl_fechaEmsión = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        lbl_horaEmision = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        lbl_nombreCliente = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        lbl_nombreVededor = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        informacion2 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        lbl_direccion = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        lbl_tipoDocumentoIdentidad = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        lbl_numeroDocumento = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        lbl_tipoPago = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductosDetalle = new javax.swing.JTable();
        panelCentralInferior = new javax.swing.JPanel();
        PaneldatosPago = new javax.swing.JPanel();
        PanelPagoEnLetras = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbl_totalLetras = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        PanelInformacionPago = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lbl_subtotal = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbl_totalIva = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbl_totalPago = new javax.swing.JLabel();
        panelDespedida = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelPrincipal.setLayout(new java.awt.BorderLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 458, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        PanelSuperior.add(jPanel1);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel24.setText("N° de Serie:");

        jLabel25.setText("Correlativo:");

        jLabel26.setText("N° de Orden:");

        lbl_tipoDocumento.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        lbl_tipoDocumento.setText("Tipo Docu.");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_tipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_tipoDocumento)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        PanelSuperior.add(jPanel2);

        PanelPrincipal.add(PanelSuperior, java.awt.BorderLayout.NORTH);

        PanelCentral.setLayout(new java.awt.BorderLayout());

        informacion1.setPreferredSize(new java.awt.Dimension(425, 72));
        informacion1.setLayout(new java.awt.GridLayout(4, 2));

        jLabel6.setText("Fecha de Emisión:");
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        informacion1.add(jLabel6);

        lbl_fechaEmsión.setText("    ");
        lbl_fechaEmsión.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        informacion1.add(lbl_fechaEmsión);

        jLabel29.setText("Hora de Emisión:");
        jLabel29.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        informacion1.add(jLabel29);

        lbl_horaEmision.setText("   ");
        lbl_horaEmision.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        informacion1.add(lbl_horaEmision);

        jLabel28.setText("Nombre Cliente");
        jLabel28.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        informacion1.add(jLabel28);

        lbl_nombreCliente.setText("   ");
        lbl_nombreCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        informacion1.add(lbl_nombreCliente);

        jLabel31.setText("Nombre Vendedor");
        jLabel31.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        informacion1.add(jLabel31);

        lbl_nombreVededor.setText("  ");
        lbl_nombreVededor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        informacion1.add(lbl_nombreVededor);

        panelSuperioCentral.add(informacion1);

        jLabel5.setText("           ");
        panelSuperioCentral.add(jLabel5);

        informacion2.setLayout(new java.awt.GridLayout(4, 2));

        jLabel33.setText("Dirección:");
        jLabel33.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        informacion2.add(jLabel33);

        lbl_direccion.setText("    ");
        lbl_direccion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        informacion2.add(lbl_direccion);

        jLabel35.setText("Tipo de Documento:");
        jLabel35.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        informacion2.add(jLabel35);

        lbl_tipoDocumentoIdentidad.setText("   ");
        lbl_tipoDocumentoIdentidad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        informacion2.add(lbl_tipoDocumentoIdentidad);

        jLabel37.setText("N° de Documento:");
        jLabel37.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        informacion2.add(jLabel37);

        lbl_numeroDocumento.setText("   ");
        lbl_numeroDocumento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        informacion2.add(lbl_numeroDocumento);

        jLabel39.setText("Tipo de Pago:");
        jLabel39.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        informacion2.add(jLabel39);

        lbl_tipoPago.setText("  ");
        lbl_tipoPago.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        informacion2.add(lbl_tipoPago);

        panelSuperioCentral.add(informacion2);

        PanelCentral.add(panelSuperioCentral, java.awt.BorderLayout.NORTH);

        tablaProductosDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cantidad", "Descripción", "P. Unitario", "Importe"
            }
        ));
        jScrollPane1.setViewportView(tablaProductosDetalle);

        PanelCentral.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        panelCentralInferior.setPreferredSize(new java.awt.Dimension(789, 200));
        panelCentralInferior.setLayout(new java.awt.BorderLayout());

        PanelPagoEnLetras.setLayout(new javax.swing.BoxLayout(PanelPagoEnLetras, javax.swing.BoxLayout.Y_AXIS));

        jPanel3.setPreferredSize(new java.awt.Dimension(450, 30));
        jPanel3.setLayout(new java.awt.GridLayout(1, 2));

        jLabel1.setText("Total en Letras");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(jLabel1);

        lbl_totalLetras.setText("                           ");
        lbl_totalLetras.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(lbl_totalLetras);

        PanelPagoEnLetras.add(jPanel3);

        PaneldatosPago.add(PanelPagoEnLetras);

        jLabel12.setText("                    ");
        PaneldatosPago.add(jLabel12);

        PanelInformacionPago.setPreferredSize(new java.awt.Dimension(250, 80));
        PanelInformacionPago.setLayout(new java.awt.GridLayout(3, 2));

        jLabel4.setText("SubTotal:");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PanelInformacionPago.add(jLabel4);

        lbl_subtotal.setText("   ");
        lbl_subtotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PanelInformacionPago.add(lbl_subtotal);

        jLabel8.setText("Total IVA:");
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PanelInformacionPago.add(jLabel8);

        lbl_totalIva.setText("   ");
        lbl_totalIva.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PanelInformacionPago.add(lbl_totalIva);

        jLabel10.setText("Total:");
        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PanelInformacionPago.add(jLabel10);

        lbl_totalPago.setText("   ");
        lbl_totalPago.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PanelInformacionPago.add(lbl_totalPago);

        PaneldatosPago.add(PanelInformacionPago);

        panelCentralInferior.add(PaneldatosPago, java.awt.BorderLayout.CENTER);

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel3.setText("Gracias Por su Compra");
        panelDespedida.add(jLabel3);

        panelCentralInferior.add(panelDespedida, java.awt.BorderLayout.PAGE_END);

        PanelCentral.add(panelCentralInferior, java.awt.BorderLayout.PAGE_END);

        PanelPrincipal.add(PanelCentral, java.awt.BorderLayout.CENTER);

        jScrollPane2.setViewportView(PanelPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1123, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Vista_Previa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Vista_Previa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Vista_Previa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Vista_Previa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Vista_Previa().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelCentral;
    private javax.swing.JPanel PanelInformacionPago;
    private javax.swing.JPanel PanelPagoEnLetras;
    private javax.swing.JPanel PanelPrincipal;
    private javax.swing.JPanel PanelSuperior;
    private javax.swing.JPanel PaneldatosPago;
    private javax.swing.JPanel informacion1;
    private javax.swing.JPanel informacion2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_direccion;
    private javax.swing.JLabel lbl_fechaEmsión;
    private javax.swing.JLabel lbl_horaEmision;
    private javax.swing.JLabel lbl_nombreCliente;
    private javax.swing.JLabel lbl_nombreVededor;
    private javax.swing.JLabel lbl_numeroDocumento;
    private javax.swing.JLabel lbl_subtotal;
    private javax.swing.JLabel lbl_tipoDocumento;
    private javax.swing.JLabel lbl_tipoDocumentoIdentidad;
    private javax.swing.JLabel lbl_tipoPago;
    private javax.swing.JLabel lbl_totalIva;
    private javax.swing.JLabel lbl_totalLetras;
    private javax.swing.JLabel lbl_totalPago;
    private javax.swing.JPanel panelCentralInferior;
    private javax.swing.JPanel panelDespedida;
    private javax.swing.JPanel panelSuperioCentral;
    private javax.swing.JTable tablaProductosDetalle;
    // End of variables declaration//GEN-END:variables
}
