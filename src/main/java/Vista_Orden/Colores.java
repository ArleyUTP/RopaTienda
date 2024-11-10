/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista_Orden;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

/**
 *
 * @author user
 */
public class Colores extends javax.swing.JPanel {

    private static Colores panelSeleccionado;

    public Colores(Color color) {
        initComponents();
        this.setBackground(color);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 24, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 24, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked

        // Si hay un panel seleccionado, quitar la selección
        if (panelSeleccionado != null) {
            panelSeleccionado.setBorder(null); // Quitar borde del panel previamente seleccionado
            panelSeleccionado.setBackground(panelSeleccionado.getBackground().brighter()); // Restaurar color de fondo
        }
        // Seleccionar el nuevo panel
        panelSeleccionado = this; // Actualizar el panel seleccionado
        Border border = BorderFactory.createLineBorder(Color.DARK_GRAY, 3);
        this.setBorder(border); // Cambiar borde del panel seleccionado
        this.setBackground(this.getBackground().darker()); // Cambiar color de fondo al seleccionar
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
