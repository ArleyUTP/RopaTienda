package Vista_Orden;

import Modelo.ColorRopa;
import Modelo.Producto;
import Persistencia.ColorDAO;
import Persistencia.TallaDAO;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.ImageIcon;

public class Productos_Detalles extends javax.swing.JPanel {

    private Producto producto;
    private List<String> imagenes; // Lista de URLs de imágenes
    private int indiceActual = 0;  // Índice para recorrer las imágenes
    private ColorRopa colorDeRopaSeleccionada;
    private Modelo.Talla tallaDeRopaSeccionada;
    public Productos_Detalles(Producto producto) {
        this.producto = producto;
        initComponents();
        init();
        lbl_nombre.setText(producto.getNombre());
        lbl_precio.setText(String.valueOf(producto.getPrecioVenta()));
        imagen.setImage(producto.getFoto_principal().getIcon());
    }

    private void init() {
        ColorDAO colorDAO = new ColorDAO();
        List<ColorRopa> colores = colorDAO.obtenerColoresPorId(producto);
        colores.forEach(color->{
            Colores colorpanel = new Colores(color);
            colorpanel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    colorpanel.seleccionar();
                    colorDeRopaSeleccionada=colorpanel.getColorRopa();
                    lbl_colorSeleccionado.setText(colorDeRopaSeleccionada.getNombre());
                }
            });
            contenedorColores.add(colorpanel);
        });
        contenedorColores.revalidate();
        contenedorColores.repaint();
        TallaDAO tallaDAO = new TallaDAO();
        List<Modelo.Talla> tallas = tallaDAO.obtenerTallasPorId(producto);
        tallas.forEach(talla->{
            Talla tallaPanel = new Talla(talla);
            tallaPanel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    tallaPanel.seleccionar();
                    tallaDeRopaSeccionada =tallaPanel.getTalla();
                    lbl_tallaSeleccionado.setText(tallaDeRopaSeccionada.getNombre());
                }
            
            });
            contenedorTallas.add(tallaPanel);
        });
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
        jLabel3 = new javax.swing.JLabel();
        lbl_precio = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        imagen = new javaswingdev.picturebox.PictureBox();
        contenedorColores = new javax.swing.JPanel();
        contenedorTallas = new javax.swing.JPanel();
        btn_anterior = new javax.swing.JButton();
        btn_siguiente = new javax.swing.JButton();
        contenedorImagenes = new javax.swing.JPanel();
        lbl_colorSeleccionado = new javax.swing.JLabel();
        lbl_tallaSeleccionado = new javax.swing.JLabel();

        lbl_nombre.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbl_nombre.setText("Nombre");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel3.setText("Precio");

        lbl_precio.setText("Precio");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel5.setText("Colores:");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel6.setText("Tallas:");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel7.setText("Cantidad");

        jSpinner1.setEnabled(false);

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

        contenedorImagenes.setLayout(new java.awt.GridLayout(1, 0));

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(lbl_nombre)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_siguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(contenedorTallas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSpinner1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(contenedorColores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(358, 358, 358)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                        .addComponent(lbl_precio)
                        .addGap(34, 34, 34))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_colorSeleccionado))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_tallaSeleccionado)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btn_anterior, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(115, 115, 115))
                    .addComponent(imagen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_nombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(lbl_precio))
                        .addGap(75, 75, 75)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_colorSeleccionado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(contenedorColores, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_siguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lbl_tallaSeleccionado, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(contenedorTallas, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(contenedorImagenes, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JLabel lbl_colorSeleccionado;
    private javax.swing.JLabel lbl_nombre;
    private javax.swing.JLabel lbl_precio;
    private javax.swing.JLabel lbl_tallaSeleccionado;
    // End of variables declaration//GEN-END:variables

}
