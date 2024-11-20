package Validaciones;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public interface ValidarImagen {

    default boolean validarImagen(File file) throws IOException {
        // Validar tamaño del archivo (máximo 2MB)
        long maxSize = 2 * 1024 * 1024; // 2 MB en bytes
        if (file.length() > maxSize) {
            mostrarMensajeError("El archivo es demasiado grande. El tamaño máximo es 2MB.");
            return false;
        }

        // Validar las dimensiones de la imagen (máximo 1500x1500 píxeles)
        BufferedImage img = ImageIO.read(file);
        int width = img.getWidth();
        int height = img.getHeight();

        int maxWidth = 1500;
        int maxHeight = 1500;

        if (width > maxWidth || height > maxHeight) {
            mostrarMensajeError("La imagen es demasiado grande. Las dimensiones máximas son 1500x1500 píxeles.");
            return false;
        }
        return true;
    }

    public abstract void mostrarMensajeError(String mensaje);
}
