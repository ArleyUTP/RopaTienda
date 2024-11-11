package Modelo;

import javax.swing.ImageIcon;

public class Profile {

    private ImageIcon icon;

    public Profile(String imagePath) {
        if (imagePath != null && !imagePath.isEmpty()) {
            this.icon = new ImageIcon(imagePath);
        }
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(String imagePath) {
        this.icon = new ImageIcon(imagePath);
    }
}
