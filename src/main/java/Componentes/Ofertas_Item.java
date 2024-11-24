package Componentes;

import javax.swing.Icon;
public class Ofertas_Item extends javax.swing.JPanel {

    public Ofertas_Item(Icon imagen,String precioOferta,String fechaCaducidad) {
        initComponents();
        lbl_fechaCaducidad.setText(fechaCaducidad);
        imagenProducto.setImage(imagen);
        this.precioOferta.setTexto(precioOferta);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imagenProducto = new javaswingdev.picturebox.PictureBox();
        lbl_fechaCaducidad = new javax.swing.JLabel();
        precioOferta = new Componentes.Ofer_Extrella();

        lbl_fechaCaducidad.setText("Fecha Final");
        imagenProducto.add(lbl_fechaCaducidad);
        lbl_fechaCaducidad.setBounds(0, 220, 70, 16);
        imagenProducto.add(precioOferta);
        precioOferta.setBounds(220, -10, 120, 120);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imagenProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imagenProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javaswingdev.picturebox.PictureBox imagenProducto;
    private javax.swing.JLabel lbl_fechaCaducidad;
    private Componentes.Ofer_Extrella precioOferta;
    // End of variables declaration//GEN-END:variables
}
