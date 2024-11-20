package Vista_Orden;

import Modelo.ColorRopa;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class Colores extends javax.swing.JPanel {

    private ColorRopa colorRopa;
    private static Colores panelSeleccionado;

    public Colores(ColorRopa colorRopa) {
        initComponents();
        this.colorRopa = colorRopa;
        establecerColorDeFondo();
    }

    public ColorRopa getColorRopa() {
        return colorRopa;
    }

    public void setColorRopa(ColorRopa colorRopa) {
        this.colorRopa = colorRopa;
    }

    public Colores(String color) {
        initComponents();
    }

    private void establecerColorDeFondo() {
        if (colorRopa.getCodigo_hexdecimal() != null) {
            String colorHex = colorRopa.getCodigo_hexdecimal();
            System.out.println("Codigo exadecimal: "+colorRopa.getCodigo_hexdecimal());
            Color color = Color.decode(colorHex);
            this.setBackground(color);
        }
    }

    public int getidColor() {
        int id = colorRopa.getId();
        return id;
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

    }//GEN-LAST:event_formMouseClicked

    public void seleccionar() {
        if (panelSeleccionado == this) {
            // Deseleccionar si el mismo panel fue clicado nuevamente
            panelSeleccionado.setBorder(null);
            panelSeleccionado.setBackground(panelSeleccionado.getBackground().brighter());
            panelSeleccionado = null;
            return;
        }

        if (panelSeleccionado != null) {
            panelSeleccionado.setBorder(null);
            panelSeleccionado.setBackground(panelSeleccionado.getBackground().brighter());
        }

        panelSeleccionado = this;
        Border border = BorderFactory.createLineBorder(Color.DARK_GRAY, 3);
        this.setBorder(border);
        this.setBackground(this.getBackground().darker());
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
