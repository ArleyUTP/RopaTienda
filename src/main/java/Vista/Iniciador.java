package Vista;

import Vista_Usuarios.Mantenimiento_Usuarios;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.Font;
import javax.swing.UIManager;

public class Iniciador {
    
//    public static void main(String[] args) {
//        try {
//            FlatDarkLaf.setup();
//        } catch (Exception ex) {
//            System.err.println("Failed to initialize LaF");
//        }
//        Vista_bienvenida vista = new Vista_bienvenida();
//        vista.setLocationRelativeTo(null);
//        vista.setVisible(true);
//    }
        public static void main(String args[]) {
        FlatRobotoFont.install();
        UIManager.put("defaultFont",new Font(FlatRobotoFont.FAMILY,Font.PLAIN,13));
        FlatMacLightLaf.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mantenimiento_Usuarios().setVisible(true);
            }
        });
    }
}
