package Vista;

import Vista_Usuarios.Mantenimiento_Usuarios;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.Font;
import javax.swing.UIManager;

public class Iniciador {

    public static void main(String args[]) {
        FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("Temas");
        System.out.println("Custom defaults registered from 'Temas'");
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
        FlatMacLightLaf.setup();
        java.awt.EventQueue.invokeLater(() -> {
            new Mantenimiento_Usuarios().setVisible(true);
        });
    }
}