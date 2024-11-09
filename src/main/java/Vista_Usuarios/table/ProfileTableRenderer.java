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
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean isSelected, boolean hasFocus, int row, int column) {
        Component com = oldCellRenderer.getTableCellRendererComponent(jtable, o, isSelected, hasFocus, row, column);
        TableCellProfile cell = new TableCellProfile((Usuario) o, com.getFont());

        if (isSelected) {
            cell.setBackground(jtable.getSelectionBackground());
        } else {
            cell.setBackground(jtable.getBackground());
        }
        return cell;
    }

}
