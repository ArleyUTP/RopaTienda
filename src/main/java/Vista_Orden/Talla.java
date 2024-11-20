package Vista_Orden;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class Talla extends javax.swing.JPanel {

    private static Talla selectedTalla;
    private Modelo.Talla talla;

    public Modelo.Talla getTalla() {
        return talla;
    }

    public void setTalla(Modelo.Talla talla) {
        this.talla = talla;
    }

    public Talla(Modelo.Talla talla) {
        this.talla = talla;
        initComponents();
        lbl_talla.setText(talla.getNombre());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_talla = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        setLayout(new java.awt.GridBagLayout());

        lbl_talla.setText("jLabel1");
        add(lbl_talla, new java.awt.GridBagConstraints());
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked

    }//GEN-LAST:event_formMouseClicked

    public void seleccionar() {
        // Si hay una talla seleccionada, deseleccionarla
        if (selectedTalla != null) {
            selectedTalla.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Restaurar borde original
            selectedTalla.setBackground(Color.WHITE); // Restaurar color de fondo
        }

        // Seleccionar la nueva talla
        selectedTalla = this; // Actualizar la talla seleccionada
        Border border = BorderFactory.createLineBorder(Color.DARK_GRAY, 3);
        this.setBorder(border); // Establecer borde para la talla seleccionada
        this.setBackground(Color.LIGHT_GRAY); // Cambiar color de fondo para indicar selección
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbl_talla;
    // End of variables declaration//GEN-END:variables
}
