package Vista_Orden.componentes;

import javax.swing.JButton;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

public class RoundButton extends JButton {

    public RoundButton() {
        setContentAreaFilled(false); // Evita que el fondo predeterminado se pinte
        setFocusPainted(false);     // Elimina el indicador de enfoque
        setBorderPainted(false);    // Elimina el borde predeterminado
    }

    @Override
    protected void paintComponent(Graphics g) {
        // Establecer un fondo circular
        if (getModel().isPressed()) {
            g.setColor(getBackground().darker());
        } else {
            g.setColor(getBackground());
        }
        g.fillOval(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        // Opcional: Añade un borde circular
        g.setColor(getForeground());
        g.drawOval(0, 0, getWidth() - 1, getHeight() - 1);
    }

    public Shape getShape() {
        // Devuelve la forma del botón como un círculo
        return new Ellipse2D.Float(0, 0, getWidth(), getHeight());
    }

    @Override
    public boolean contains(int x, int y) {
        // Verifica si el clic está dentro del área circular
        Shape shape = getShape();
        return shape.contains(x, y);
    }
}
