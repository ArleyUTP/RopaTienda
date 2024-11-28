package Vista_Productos.componentes;

import Modelo.Perfil;
import javaswingdev.picturebox.PictureBox;

public class CellImage extends javax.swing.JPanel {

    public PictureBox getImagenProducto() {
        return imagenProducto;
    }

    public void setImagenProducto(PictureBox imagenProducto) {
        this.imagenProducto = imagenProducto;
    }

    public CellImage(Perfil imagen) {
        initComponents();
        if (imagen != null) {
            imagenProducto.setImage(imagen.getIcon());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imagenProducto = new javaswingdev.picturebox.PictureBox();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(imagenProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(imagenProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javaswingdev.picturebox.PictureBox imagenProducto;
    // End of variables declaration//GEN-END:variables
}
