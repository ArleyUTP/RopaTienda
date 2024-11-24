package Componentes;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;

public class Ofer_Extrella extends JComponent {

    private String texto = ""; // Texto a mostrar en el centro (ejemplo: precio de oferta)

    // Constructor por defecto
    public Ofer_Extrella() {
        this.setPreferredSize(new Dimension(100, 100)); // Tamaño por defecto
    }

    // Método para establecer el texto (por ejemplo: precio)
    public void setTexto(String texto) {
        this.texto = texto;
        repaint(); // Actualiza el componente
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Activar suavizado para mejor calidad de dibujo
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Dibujar el fondo blanco
////        g2d.setColor(Color.WHITE);
////        g2d.fillRect(0, 0, getWidth(), getHeight());

// Cambia el tamaño según el tamaño del componente
        int radioExterior = (int) (getWidth() * 0.4); // 40% del ancho del componente
        int radioInterior = (int) (getHeight() * 0.2); // 20% de la altura del componente

        Shape figura = crearEstrella(getWidth() / 2, getHeight() / 2, radioExterior, radioInterior, 5);
        // Cambia a crearNube(...) si prefieres nube
        g2d.setColor(Color.ORANGE); // Color de la figura
        g2d.fill(figura);

        // Dibujar el borde
        g2d.setColor(Color.BLACK);
        g2d.draw(figura);

        // Dibujar el texto en el centro
        if (!texto.isEmpty()) {
            g2d.setColor(Color.BLACK);
            FontMetrics fm = g2d.getFontMetrics();
            int textWidth = fm.stringWidth(texto);
            int textHeight = fm.getAscent();
            g2d.drawString(texto, (getWidth() - textWidth) / 2, (getHeight() + textHeight) / 2);
        }
    }

    // Método para crear una estrella
    private Shape crearEstrella(int x, int y, int radioExterior, int radioInterior, int puntos) {
        Path2D estrella = new Path2D.Double();
        double angulo = Math.PI / puntos;

        for (int i = 0; i < puntos * 2; i++) {
            double radio = (i % 2 == 0) ? radioExterior : radioInterior;
            double dx = x + Math.cos(i * angulo) * radio;
            double dy = y - Math.sin(i * angulo) * radio;
            if (i == 0) {
                estrella.moveTo(dx, dy);
            } else {
                estrella.lineTo(dx, dy);
            }
        }
        estrella.closePath();
        return estrella;
    }

    // Método para crear una nube (opcional)
    private Shape crearNube(int x, int y, int ancho, int alto) {
        Path2D nube = new Path2D.Double();
        nube.moveTo(x - ancho / 2, y);
        nube.curveTo(x - ancho / 2, y - alto / 2, x - ancho / 4, y - alto, x, y - alto / 2);
        nube.curveTo(x + ancho / 4, y - alto, x + ancho / 2, y - alto / 2, x + ancho / 2, y);
        nube.curveTo(x + ancho / 2, y + alto / 2, x + ancho / 4, y + alto, x, y + alto / 2);
        nube.curveTo(x - ancho / 4, y + alto, x - ancho / 2, y + alto / 2, x - ancho / 2, y);
        nube.closePath();
        return nube;
    }
}
