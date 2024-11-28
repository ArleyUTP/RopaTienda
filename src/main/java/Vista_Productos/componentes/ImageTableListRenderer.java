package Vista_Productos.componentes;

import Modelo.Perfil;
import java.awt.Component;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class ImageTableListRenderer implements TableCellRenderer {

    private final TableCellRenderer oldCellRenderer;

    public ImageTableListRenderer(JTable table) {
        this.oldCellRenderer = table.getDefaultRenderer(Object.class);
    }

    @Override
    public Component getTableCellRendererComponent(
            JTable table,
            Object value,
            boolean isSelected,
            boolean hasFocus,
            int row,
            int column) {

        // Obtener el componente predeterminado
        Component defaultComponent = oldCellRenderer.getTableCellRendererComponent(
                table, value, isSelected, hasFocus, row, column);

        // Validar si el valor es una lista de Perfil
        if (value instanceof List<?>) {
            List<?> valueList = (List<?>) value;

            // Filtrar y asegurarse de que es una lista de Perfil
            if (!valueList.isEmpty() && valueList.get(0) instanceof Perfil) {
                @SuppressWarnings("unchecked")
                List<Perfil> perfiles = (List<Perfil>) value;

                // Crear una nueva instancia de CellList para esta celda
                CellList cellList = new CellList(perfiles);
                cellList.setBackground(isSelected ? table.getSelectionBackground() : table.getBackground());
                return cellList;
            }
        }

        // Si el valor no es válido o la lista está vacía, devolver el componente predeterminado
        return defaultComponent;
    }
}
