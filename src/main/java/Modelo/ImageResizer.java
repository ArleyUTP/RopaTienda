package Modelo;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class ImageResizer {

    private Icon icon;
    private byte[] bytes;

    public ImageResizer(byte[] bytes) {
        if (bytes != null) {
            this.bytes = bytes;
            icon = new ImageIcon(bytes);
        }
    }

    public ImageResizer(Icon icon) {
        this.icon = icon;
    }

    public Icon obtenerIconoRedimensionado(JComponent componente) {
        if (icon == null) {
            throw new IllegalStateException("La imagen no se ha inicializado correctamente.");
        }

        if (componente == null) {
            throw new IllegalArgumentException("El componente no puede ser nulo.");
        }

        int ancho = componente.getWidth();
        int alto = componente.getHeight();

        if (ancho <= 0 || alto <= 0) {
            throw new IllegalStateException("El componente debe tener dimensiones válidas.");
        }

        // Crear la imagen redimensionada
        ImageIcon originalIcon = (ImageIcon) icon;
        Image imagenRedimensionada = originalIcon.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);

        // Retornar la imagen redimensionada como Icon
        return new ImageIcon(imagenRedimensionada);
    }
}
