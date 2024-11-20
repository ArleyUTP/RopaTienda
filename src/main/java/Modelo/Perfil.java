package Modelo;

import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Perfil {

    Icon icon;
    File ruta;
    byte[] bytes;

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }
    public Perfil(File ruta) {
        this.ruta = ruta;
    }

    public Perfil(byte[] bytes) {
        if (bytes != null) {
            this.bytes=bytes;
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
    public String toString() {
        return "Perfil{" + "icon=" + icon + ", ruta=" + ruta + '}';
    }

}
