package Vista_Orden;

import Modelo.Producto;
import Persistencia.ProductoDAO;
import java.awt.Color;
import java.util.List;
import javax.swing.ImageIcon;

public class Productos_Detalles extends javax.swing.JPanel {

    private List<String> imagenes; // Lista de URLs de imágenes
    private int indiceActual = 0;  // Índice para recorrer las imágenes

    public Productos_Detalles(Producto producto) {
        initComponents();
        init();
        lbl_nombre.setText(producto.getNombre());
        lbl_precio.setText(String.valueOf(producto.getPrecioVenta()));
        imagen.setImage(new ImageIcon(producto.getFoto()));
        ProductoDAO proDAO = new ProductoDAO();
        this.imagenes = proDAO.obtenerImagenesPorId(producto);
        imagenes.add(producto.getFoto());
        if (!imagenes.isEmpty()) {
            cargarMiniaturas(imagenes);
        }
    }

    private void init() {
        contenedorColores.add(new Colores(Color.BLACK));
        contenedorColores.add(new Colores(Color.CYAN));
        contenedorColores.add(new Colores(Color.MAGENTA));
        contenedorColores.add(new Colores(Color.ORANGE));
        contenedorColores.add(new Colores(Color.pink));
        contenedorColores.revalidate();
        contenedorColores.repaint();
        contenedorTallas.add(new Talla("S"));
        contenedorTallas.add(new Talla("M"));
        contenedorTallas.add(new Talla("L"));
        contenedorTallas.add(new Talla("XL"));
        contenedorTallas.add(new Talla("XXL"));
        contenedorTallas.revalidate();
        contenedorTallas.repaint();
    }

    private void actualizarImagen() {
        if (!imagenes.isEmpty()) {
            ImageIcon nuevaImagen = new ImageIcon(imagenes.get(indiceActual));
            imagen.setImage(nuevaImagen);
            imagen.repaint();
        }
    }

    private void cargarMiniaturas(List<String> imagenes) {
        contenedorImagenes.removeAll();
        for (String url : imagenes) {
            javaswingdev.picturebox.PictureBox miniatura = new javaswingdev.picturebox.PictureBox();
            miniatura.setImage(new ImageIcon(url));
            miniatura.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    mostrarImagenEnPrincipal(url); // Evento clic para mostrar la imagen en grande
                }
            });
            contenedorImagenes.add(miniatura);
        }
        contenedorImagenes.revalidate(); // Actualiza el contenedor
        contenedorImagenes.repaint();
    }

    private void mostrarImagenEnPrincipal(String url) {
        imagen.setImage(new ImageIcon(url)); // Muestra la imagen seleccionada en el PictureBox principal
        imagen.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_nombre = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbl_precio = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jButton1 = new javax.swing.JButton();
        imagen = new javaswingdev.picturebox.PictureBox();
        contenedorColores = new javax.swing.JPanel();
        contenedorTallas = new javax.swing.JPanel();
        btn_anterior = new javax.swing.JButton();
        btn_siguiente = new javax.swing.JButton();
        contenedorImagenes = new javax.swing.JPanel();

        lbl_nombre.setText("Nombre");

        jLabel2.setText("Codigo");

        jLabel3.setText("Precio");

        lbl_precio.setText("Precio");

        jLabel5.setText("Color");

        jLabel6.setText("Talla");

        jLabel7.setText("Cantidad");

        jButton1.setText("AGREGAR AL CARRITO");

        imagen.setLayout(new java.awt.FlowLayout());

        contenedorColores.setLayout(new java.awt.GridLayout(1, 6, 2, 0));

        contenedorTallas.setLayout(new java.awt.GridLayout(1, 0, 2, 0));

        btn_anterior.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btn_anterior.setText("<");
        btn_anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_anteriorActionPerformed(evt);
            }
        });

        btn_siguiente.setText(">");
        btn_siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_siguienteActionPerformed(evt);
            }
        });

        contenedorImagenes.setLayout(new java.awt.GridLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btn_anterior, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(contenedorImagenes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(imagen, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_siguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(contenedorTallas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(contenedorColores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_precio)
                        .addGap(34, 34, 34))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(95, 95, 95)
                                .addComponent(lbl_nombre)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 199, Short.MAX_VALUE)
                        .addComponent(btn_anterior, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(115, 115, 115))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(imagen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lbl_nombre)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(lbl_precio))
                            .addGap(75, 75, 75)
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(contenedorColores, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(btn_siguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(contenedorTallas, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel7)
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton1)))))
                .addGap(18, 18, 18)
                .addComponent(contenedorImagenes, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_siguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_siguienteActionPerformed
        if (!imagenes.isEmpty()) {
            indiceActual = (indiceActual + 1) % imagenes.size();
            actualizarImagen();
        }
    }//GEN-LAST:event_btn_siguienteActionPerformed

    private void btn_anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_anteriorActionPerformed
        if (!imagenes.isEmpty()) {
            indiceActual = (indiceActual - 1 + imagenes.size()) % imagenes.size(); // Retrocede al índice anterior
            actualizarImagen();
        }
    }//GEN-LAST:event_btn_anteriorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_anterior;
    private javax.swing.JButton btn_siguiente;
    private javax.swing.JPanel contenedorColores;
    private javax.swing.JPanel contenedorImagenes;
    private javax.swing.JPanel contenedorTallas;
    private javaswingdev.picturebox.PictureBox imagen;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JLabel lbl_nombre;
    private javax.swing.JLabel lbl_precio;
    // End of variables declaration//GEN-END:variables

}
