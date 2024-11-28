package Vista_Productos.componentes;

import Modelo.Perfil;
import java.awt.Component;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class ImageListRenderer implements ListCellRenderer<Perfil> {

    private final ListCellRenderer<? super Perfil> oldCellRenderer;

    public ImageListRenderer(JList<Perfil> list) {
        this.oldCellRenderer = list.getCellRenderer();
    }

    @Override
    public Component getListCellRendererComponent(
            JList<? extends Perfil> list,
            Perfil value,
            int index,
            boolean isSelected,
            boolean cellHasFocus) {

        // Obtener el componente predeterminado para manejar el fondo y fuente
        Component defaultComponent = oldCellRenderer.getListCellRendererComponent(
                list, value, index, isSelected, cellHasFocus);

        // Si el componente no es un CellImage, crearlo
        if (!(defaultComponent instanceof CellImage)) {
            CellImage cellImage = new CellImage(value);
            cellImage.setBackground(defaultComponent.getBackground());
            return cellImage;
        }

        // Si ya es un CellImage, solo actualiza su contenido
        CellImage cellImage = (CellImage) defaultComponent;
        cellImage.getImagenProducto().setImage(value.getIcon());
        cellImage.setBackground(isSelected ? list.getSelectionBackground() : list.getBackground());
        return cellImage;
    }
}
