package Modelo;

import java.io.File;
import java.util.Objects;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Perfil {

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

    public Perfil(String rutaAbsoluta) {
        this.rutaAbsoluta = rutaAbsoluta;
        this.icon = new ImageIcon(rutaAbsoluta);
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
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Perfil other = (Perfil) obj;
        return Objects.equals(this.rutaAbsoluta, other.rutaAbsoluta);
    }

    @Override
    public String toString() {
        return "Perfil{" + "icon=" + icon + ", ruta=" + ruta + '}';
    }

}
