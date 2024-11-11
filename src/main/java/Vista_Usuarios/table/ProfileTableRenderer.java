package Vista_Usuarios.table;

import Modelo.Usuario;
import Vista_Usuarios.TableCellProfile;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class ProfileTableRenderer implements TableCellRenderer {

    private final TableCellRenderer oldCellRenderer;

    public ProfileTableRenderer(JTable table) {
        oldCellRenderer = table.getDefaultRenderer(Object.class);
    }

    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
        Component com = oldCellRenderer.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1);

        // Solo crea un nuevo TableCellProfile si es necesario
        if (!com.getClass().equals(TableCellProfile.class)) {
            TableCellProfile cellProfile = new TableCellProfile((Usuario) o, com.getFont());
            cellProfile.setBackground(com.getBackground());
            return cellProfile;
        }

        // Si ya es un TableCellProfile, solo actualiza su contenido
        TableCellProfile cellProfile = (TableCellProfile) com;
        cellProfile.setValue((Usuario) o);
        return cellProfile;
    }
}
