package Componentes;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class Carta extends javax.swing.JPanel {

    public Color getColor1() {
        return color1;
    }

    public void setColor1(Color color1) {
        this.color1 = color1;
    }

    public Color getColor2() {
        return color2;
    }

    public void setColor2(Color color2) {
        this.color2 = color2;
    }

    private Color color1;
    private Color color2;

    public Carta() {
        initComponents();
        color1 = Color.decode("#00FF7F");
        color2 = Color.WHITE;
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint g = new GradientPaint(0, 0, color1, 0, getHeight(), color2);
        g2.setPaint(g);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.setColor(new Color(255, 255, 255, 50));
        g2.fillOval(getWidth() - (getHeight() / 2), 10, getHeight(), getHeight());
        g2.fillOval(getWidth() - (getHeight() / 2) - 20, getHeight() / 2 + 20, getHeight(), getHeight());
        super.paintComponent(grphcs);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lbl_titulo = new javax.swing.JLabel();
        lbl_cantidad = new javax.swing.JLabel();
        lbl_descripcion = new javax.swing.JLabel();

        setOpaque(false);
        setLayout(new java.awt.GridLayout(4, 0));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/dinero.png"))); // NOI18N
        add(jLabel1);

        lbl_titulo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_titulo.setText("Titulo");
        add(lbl_titulo);

        lbl_cantidad.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_cantidad.setText("Cantidad");
        add(lbl_cantidad);

        lbl_descripcion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_descripcion.setText("Descripción");
        add(lbl_descripcion);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbl_cantidad;
    private javax.swing.JLabel lbl_descripcion;
    private javax.swing.JLabel lbl_titulo;
    // End of variables declaration//GEN-END:variables
}
