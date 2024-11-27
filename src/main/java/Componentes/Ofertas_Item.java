package Componentes;

import javax.swing.Icon;

public class Ofertas_Item extends javax.swing.JPanel {
    
    public Ofertas_Item(Icon imagen, String precioOferta, String fechaCaducidad) {
        initComponents();
//        lbl_fechaCaducidad.setText(fechaCaducidad);
//        this.precioOferta.setTexto(precioOferta);
//        this.imagenProducto.setSize(300, 300);
//        ImageResizer imageResizer = new ImageResizer(imagen);
//        this.imagenProducto.setImage(imageResizer.obtenerIconoRedimensionado(this.imagenProducto));
        this.imagen.setImage(imagen);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imagen = new Componentes.OfertaPerfil();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Componentes.OfertaPerfil imagen;
    // End of variables declaration//GEN-END:variables
}
