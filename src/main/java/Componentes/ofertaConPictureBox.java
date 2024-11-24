package Componentes;
import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.geom.Path2D;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ofertaConPictureBox extends JComponent {

    private Image image; // La imagen que se mostrará
    private String precio = ""; // Precio seleccionado
    private LocalDate fechaFin = null; // Fecha de finalización

    // Constructor por defecto
    public ofertaConPictureBox() {
        this.setPreferredSize(new Dimension(300, 300)); // Tamaño por defecto
    }

    // Método para establecer la imagen
    public void setImage(Image image) {
        this.image = image;
        repaint();
    }

    // Método para establecer el precio
    public void setPrecio(String precio) {
        this.precio = precio;
        repaint();
    }

    // Método para establecer la fecha de finalización
    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Activar suavizado para mejor calidad de dibujo
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Dibujar la imagen en el fondo (asegurarse de que la imagen se ajuste al componente)
        if (image != null) {
            g2d.drawImage(image, 0, 0, getWidth(), getHeight(), (ImageObserver) null);
        }

        // Dibujar la estrella en la parte superior derecha para el precio
        if (!precio.isEmpty()) {
            Shape estrella = crearEstrella(getWidth() - 50, 50, 30, 15, 10); // Estrella con tamaño ajustado
            g2d.setColor(Color.ORANGE); // Color de la estrella
            g2d.fill(estrella);

            // Mostrar el precio en el centro de la estrella
            g2d.setColor(Color.BLACK);
            Font fontPrecio = new Font("Arial", Font.BOLD, 12);
            g2d.setFont(fontPrecio);
            FontMetrics fmPrecio = g2d.getFontMetrics();
            int textWidth = fmPrecio.stringWidth(precio);
            int textHeight = fmPrecio.getAscent();
            g2d.drawString(precio, (getWidth() - 50 - textWidth / 2), 50 + textHeight / 2);
        }

        // Dibujar el rectángulo con bordes redondeados en la parte inferior izquierda para la fecha de fin
        if (fechaFin != null) {
            String textoFecha = "Hasta: " + fechaFin.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            g2d.setColor(new Color(50, 50, 50, 150)); // Fondo semi-transparente
            g2d.fillRoundRect(20, getHeight() - 50, 150, 40, 20, 20);

            // Mostrar la fecha dentro del rectángulo
            g2d.setColor(Color.WHITE);
            Font fontFecha = new Font("Arial", Font.PLAIN, 14);
            g2d.setFont(fontFecha);
            FontMetrics fmFecha = g2d.getFontMetrics();
            int textWidthFecha = fmFecha.stringWidth(textoFecha);
            g2d.drawString(textoFecha, 20 + (150 - textWidthFecha) / 2, getHeight() - 30);
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

    // Método principal para probar la clase
    public static void main(String[] args) {
        JFrame frame = new JFrame("Oferta con PictureBox");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        // Crear una instancia del componente y agregarla al JFrame
        ofertaConPictureBox componente = new ofertaConPictureBox();
        componente.setPrecio("S/.1000");
        componente.setFechaFin(LocalDate.of(2024, 12, 31)); // Fecha de finalización
        componente.setImage(new ImageIcon("ruta/a/tu/imagen.jpg").getImage()); // Establecer imagen

        frame.add(componente);
        frame.setVisible(true);
    }
}
