package Componentes;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Ofer_Circulo extends JComponent {

    private String texto = ""; // Texto a mostrar en el centro del círculo

    // Constructor por defecto
    public Ofer_Circulo() {
        this.setPreferredSize(new Dimension(100, 100)); // Tamaño por defecto
    }

    // Método para establecer el texto dentro del círculo
    public void setTexto(String texto) {
        this.texto = texto;
        repaint(); // Redibujar el componente
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Activar suavizado para mejor calidad de dibujo
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Calcular el tamaño del círculo basado en el tamaño del componente
        int diameter = Math.min(getWidth(), getHeight()); // Asegurar que sea un círculo perfecto
        int x = (getWidth() - diameter) / 2;
        int y = (getHeight() - diameter) / 2;

        // Dibujar el círculo
        Shape circulo = new Ellipse2D.Double(x, y, diameter, diameter);
        g2d.setColor(Color.RED); // Color de relleno
        g2d.fill(circulo);

        // Dibujar el borde del círculo
        g2d.draw(circulo);

        // Dibujar el texto centrado dentro del círculo
        if (!texto.isEmpty()) {
            g2d.setColor(Color.BLACK);
            FontMetrics fm = g2d.getFontMetrics();
            int textWidth = fm.stringWidth(texto);
            int textHeight = fm.getAscent();
            g2d.drawString(texto, (getWidth() - textWidth) / 2, (getHeight() + textHeight) / 2);
        }
    }
}
