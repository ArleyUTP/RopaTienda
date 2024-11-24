package Componentes;

import Modelo.ImageResizer;
import javax.swing.Icon;

public class Ofertas_Item extends javax.swing.JPanel {
    
    public Ofertas_Item(Icon imagen, String precioOferta, String fechaCaducidad) {
        initComponents();
        lbl_fechaCaducidad.setText(fechaCaducidad);
        this.precioOferta.setTexto(precioOferta);
        this.imagenProducto.setSize(300, 300);
        ImageResizer imageResizer = new ImageResizer(imagen);
        this.imagenProducto.setImage(imageResizer.obtenerIconoRedimensionado(this.imagenProducto));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imagenProducto = new javaswingdev.picturebox.PictureBox();
        lbl_fechaCaducidad = new javax.swing.JLabel();
        precioOferta = new Componentes.Ofer_Extrella();

        lbl_fechaCaducidad.setText("Fecha Final");
        imagenProducto.add(lbl_fechaCaducidad);
        lbl_fechaCaducidad.setBounds(0, 160, 70, 40);
        imagenProducto.add(precioOferta);
        precioOferta.setBounds(190, -10, 120, 120);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(imagenProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(imagenProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javaswingdev.picturebox.PictureBox imagenProducto;
    private javax.swing.JLabel lbl_fechaCaducidad;
    private Componentes.Ofer_Extrella precioOferta;
    // End of variables declaration//GEN-END:variables
}
