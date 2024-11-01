package Vista;

import com.formdev.flatlaf.FlatDarkLaf;

public class Iniciador {

    public static void main(String[] args) {
        try {
            FlatDarkLaf.setup();
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        Vista_bienvenida vista = new Vista_bienvenida();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }

}
