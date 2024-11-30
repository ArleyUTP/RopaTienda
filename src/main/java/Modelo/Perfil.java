package Modelo;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import net.coobird.thumbnailator.Thumbnails;

public class Perfil {

    int id;
    Icon icon;
    File ruta;
    byte[] bytes;
    String rutaAbsoluta;

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public Perfil(File ruta) {
        this.ruta = ruta;
    }

    public Perfil(String rutaAbsoluta, File file) {
        this.rutaAbsoluta = rutaAbsoluta;
        this.ruta = file;
        this.icon = new ImageIcon(rutaAbsoluta);
        try {
            this.bytes = getByteImagen(file);
        } catch (IOException e) {
            System.out.println("Error al convertir ruta en Bytes");
        }
    }

    public Perfil(byte[] bytes) {
        if (bytes != null) {
            this.bytes = bytes;
            icon = new ImageIcon(bytes);
        }
    }

    public Perfil(Icon icon) {
        this.icon = icon;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public File getRuta() {
        return ruta;
    }

    public void setRuta(File ruta) {
        this.ruta = ruta;
        try {
            this.bytes = getByteImagen(ruta);
        } catch (IOException e) {
            System.out.println("Error al convertir ruta en Bytes");
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Perfil other = (Perfil) obj;
        return Objects.equals(this.rutaAbsoluta, other.rutaAbsoluta);
    }

    private byte[] getByteImagen(File file) throws IOException {
        BufferedImage imagen = Thumbnails.of(file)
                .width(500)
                .outputQuality(0.7f)
                .asBufferedImage();
        ByteArrayOutputStream out = null;
        try {
            out = new ByteArrayOutputStream();
            ImageIO.write(imagen, "jpg", out);
            byte[] data = out.toByteArray();
            return data;
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    @Override
    public String toString() {
        return "Perfil{" + "id=" + id + ", icon=" + icon + ", ruta=" + ruta + ", bytes=" + bytes + ", rutaAbsoluta=" + rutaAbsoluta + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
