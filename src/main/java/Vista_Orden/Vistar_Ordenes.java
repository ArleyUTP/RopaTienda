package Vista_Orden;

import Modelo.Comprobante;
import Modelo.NumeroALetraPeru;
import Modelo.OrdenPedido;
import Modelo.SeriesCorrelativos;
import Modelo.Usuario;
import Persistencia.ComprobanteDAO;
import com.formdev.flatlaf.FlatClientProperties;
import Persistencia.OrdenPedidoDAO;
import Persistencia.SeriesCorrelativosDAO;
import Reportes.Vista_Previa;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import raven.toast.Notifications;

public class Vistar_Ordenes extends javax.swing.JPanel {

    private OrdenPedido ordenSeleccionada;

    public Vistar_Ordenes() {
        initComponents();
        init();
        cargarDatosTabla();
    }

    private void init() {
        this.putClientProperty(FlatClientProperties.STYLE, ""
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
    }

    private void cargarDatosTabla() {
        OrdenPedidoDAO ordenPedidoDAO = new OrdenPedidoDAO();
        ordenPedidoDAO.mostrarOrdenesPedido(table);
    }

    private List<OrdenPedido> getSelect() {
        OrdenPedidoDAO ordenPedidoDAO = new OrdenPedidoDAO();
        List<OrdenPedido> selectOrdes = new ArrayList<>();
        for (int i = 0; i < table.getRowCount(); i++) {
            Boolean isSelected = (Boolean) table.getValueAt(i, 0);
            if (isSelected != null && isSelected) {
                int ordenId = (Integer) table.getValueAt(i, 1);
                OrdenPedido ordenPedido = ordenPedidoDAO.obtenerOrdenPedidoPorId(ordenId);
                selectOrdes.add(ordenPedido);
            }
        }
        return selectOrdes;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scroll = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btn_generar = new javax.swing.JButton();

        scroll.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "#", "F. Emisión", "Importe"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false
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
            table.getColumnModel().getColumn(0).setPreferredWidth(40);
            table.getColumnModel().getColumn(0).setMaxWidth(20);
        }

        btn_generar.setText("Generar");
        btn_generar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_generarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_generar, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scroll)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(435, Short.MAX_VALUE)
                .addComponent(btn_generar)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(8, 8, 8)
                    .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(39, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_generarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_generarActionPerformed
        List<OrdenPedido> ordenesSelecionadas = getSelect();
        if (!ordenesSelecionadas.isEmpty()) {
            if (ordenesSelecionadas.size() == 1) {
                ordenSeleccionada = ordenesSelecionadas.get(0);

                // Mostrar diálogo para elegir tipo de documento
                String[] opciones = {"Factura", "Boleta"};
                String tipoSeleccionado = (String) JOptionPane.showInputDialog(
                        null,
                        "Seleccione el tipo de comprobante",
                        "Generar Comprobante",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        opciones,
                        opciones[0]);

                if (tipoSeleccionado != null) {
                    try {
                        // Obtener serie y correlativo
                        Comprobante comprobante = new Comprobante();
                        comprobante.setOrdenPedido(ordenSeleccionada);
                        comprobante.setTipo(tipoSeleccionado);
                        comprobante.setSubtotal(ordenSeleccionada.getImporte_total());
                        // Obtener serie y correlativo desde SeriesCorrelativosDAO
                        SeriesCorrelativosDAO seriesDAO = new SeriesCorrelativosDAO();
                        SeriesCorrelativos serieCorrelativo = seriesDAO.obtenerSerieYCorrelativo(tipoSeleccionado);
                        comprobante.setSerie(serieCorrelativo.getSerie());
                        comprobante.setCorrelativo(serieCorrelativo.getCorrelativoActual() + 1);

                        // Generar el comprobante
                        ComprobanteDAO comprobanteDAO = new ComprobanteDAO();
                        long idComprobante = comprobanteDAO.generarComprobante(comprobante);
                        // Actualizar el correlativo en la tabla SeriesCorrelativos
                        seriesDAO.actualizarCorrelativo(serieCorrelativo.getId(), comprobante.getCorrelativo());
                        if (idComprobante!=0) {
                            
                        }
                        Notifications.getInstance().show(Notifications.Type.SUCCESS, "Comprobante generado con ID: " + idComprobante);
                    } catch (Exception e) {
                        Notifications.getInstance().show(Notifications.Type.ERROR, "Error al generar comprobante: " + e.getMessage());
                    }
                }
            } else {
                Notifications.getInstance().show(Notifications.Type.WARNING, "Seleccionar solo una Orden para Generar");
            }
        } else {
            Notifications.getInstance().show(Notifications.Type.WARNING, "Selecciona un Orden Para Generar");
        }
    }//GEN-LAST:event_btn_generarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_generar;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
