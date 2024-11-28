package Vista_Productos;

import Modelo.*;
import Persistencia.ColorDAO;
import Persistencia.TallaDAO;
import Vista_Productos.componentes.ImageListRenderer;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import jnafilechooser.api.JnaFileChooser;
import raven.toast.Notifications;

public class CrearVariantes extends javax.swing.JPanel {
    
    private List<Perfil> imagenesVariante;
    
    public CrearVariantes() {
        initComponents();
        this.imagenesVariante = new ArrayList<>();
        llenarListas();
        listaDeImagenes.setCellRenderer(new ImageListRenderer(listaDeImagenes));
    }
    
    private void llenarListas() {
        TallaDAO tallaDAO = new TallaDAO();
        List<Talla> tallas = tallaDAO.obtenerTodasLastallas();
        tallas.forEach(talla -> cbo_tallas.addItem(talla));
        ColorDAO colorDAO = new ColorDAO();
        List<ColorRopa> colores = colorDAO.obtenerTodosLosColores();
        colores.forEach(color -> cbo_colores.addItem(color));
    }
    
    public Object[] obtenerDatos() {
        Talla tallaSeleccionada = (Talla) cbo_tallas.getSelectedItem();
        ColorRopa colorSeleccionado = (ColorRopa) cbo_colores.getSelectedItem();
        return new Object[]{
            tallaSeleccionada,
            colorSeleccionado,
            (int)cantidad.getValue(),
            imagenesVariante
        };
    }
    
    private void cargarListaDeImagenes() {
        DefaultListModel<Perfil> modelo = new DefaultListModel<>();
        if (imagenesVariante != null) {
            imagenesVariante.forEach(perfilsa -> modelo.addElement(perfil));
            listaDeImagenes.setModel(modelo);
        } else {
            System.out.println("La lista de imagenes variante esta vacia");
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cbo_tallas = new javax.swing.JComboBox<Modelo.Talla>();
        jLabel2 = new javax.swing.JLabel();
        cbo_colores = new javax.swing.JComboBox<ColorRopa>();
        jLabel3 = new javax.swing.JLabel();
        cantidad = new javax.swing.JSpinner(new SpinnerNumberModel(1,0,100,1));
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaDeImagenes = new javax.swing.JList<Perfil>();
        panelImagen = new javax.swing.JPanel();
        imagen = new javaswingdev.picturebox.PictureBox();
        jToolBar1 = new javax.swing.JToolBar();
        btn_seleccionar = new javax.swing.JButton();
        btn_agregar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jToolBar2 = new javax.swing.JToolBar();
        btn_eliminarImagenLista = new javax.swing.JButton();
        btn_actualizarImagenLista = new javax.swing.JButton();

        jLabel1.setText("Talla");

        jLabel2.setText("Color");

        jLabel3.setText("Cantidad");

        jLabel7.setText("Foto");

        jScrollPane1.setViewportView(listaDeImagenes);

        panelImagen.setLayout(new java.awt.BorderLayout());

        jToolBar1.setRollover(true);
        jToolBar1.setOpaque(false);

        btn_seleccionar.setText("Seleccionar");
        btn_seleccionar.setFocusable(false);
        btn_seleccionar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_seleccionar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_seleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_seleccionarActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_seleccionar);

        btn_agregar.setText("Agregar");
        btn_agregar.setFocusable(false);
        btn_agregar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_agregar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_agregar);

        btn_eliminar.setText("Eliminar");
        btn_eliminar.setFocusable(false);
        btn_eliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_eliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_eliminar);

        javax.swing.GroupLayout imagenLayout = new javax.swing.GroupLayout(imagen);
        imagen.setLayout(imagenLayout);
        imagenLayout.setHorizontalGroup(
            imagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imagenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        imagenLayout.setVerticalGroup(
            imagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imagenLayout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 162, Short.MAX_VALUE))
        );

        panelImagen.add(imagen, java.awt.BorderLayout.CENTER);

        jLabel4.setText("Imagenes");

        jToolBar2.setRollover(true);

        btn_eliminarImagenLista.setText("Eliminar");
        btn_eliminarImagenLista.setFocusable(false);
        btn_eliminarImagenLista.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_eliminarImagenLista.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_eliminarImagenLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarImagenListaActionPerformed(evt);
            }
        });
        jToolBar2.add(btn_eliminarImagenLista);

        btn_actualizarImagenLista.setText("Actualizar");
        btn_actualizarImagenLista.setFocusable(false);
        btn_actualizarImagenLista.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_actualizarImagenLista.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_actualizarImagenLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizarImagenListaActionPerformed(evt);
            }
        });
        jToolBar2.add(btn_actualizarImagenLista);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(33, 33, 33)
                        .addComponent(cbo_tallas, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbo_colores, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4)
                    .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(cbo_tallas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(54, 54, 54)
                        .addComponent(jLabel3)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbo_colores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(panelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private Perfil perfil;
    private void btn_seleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_seleccionarActionPerformed
// TODO add your handling code here:
        JnaFileChooser ch = new JnaFileChooser();
        ch.addFilter("Image", "png", "jpg", "jpeg");
        boolean act = ch.showOpenDialog(SwingUtilities.getWindowAncestor(this));
        if (act) {
            File file = ch.getSelectedFile();
            perfil = new Perfil(file.getAbsolutePath(),file);
            // Validar si la imagen ya existe en la lista
            if (imagenesVariante.contains(perfil)) {
                Notifications.getInstance().show(Notifications.Type.ERROR, "La imagen seleccionada ya existe");
                return; // Retorno temprano para evitar continuar
            }

            // Si no existe, se agrega la imagen
            imagen.setImage(new ImageIcon(file.getAbsolutePath()));
        }

    }//GEN-LAST:event_btn_seleccionarActionPerformed
    
    private void agregar(Perfil perfil) {
        imagenesVariante.add(perfil);
        cargarListaDeImagenes();
    }
    private void btn_eliminarImagenListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarImagenListaActionPerformed
        
        Perfil fotoSeleccionada = (Perfil) listaDeImagenes.getSelectedValue();
        if (imagenesVariante != null) {
            imagenesVariante.remove(fotoSeleccionada);
            cargarListaDeImagenes();
        }
    }//GEN-LAST:event_btn_eliminarImagenListaActionPerformed

    private void btn_actualizarImagenListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarImagenListaActionPerformed
        Perfil fotoSeleccionada = (Perfil) listaDeImagenes.getSelectedValue();
        
        if (fotoSeleccionada == null) {
            Notifications.getInstance().show(Notifications.Type.WARNING, "Seleccione una imagen para actualizar");
            return;
        }

        // Validar si la lista de imágenes no es nula
        if (imagenesVariante == null) {
            Notifications.getInstance().show(Notifications.Type.ERROR, "La lista de imágenes no está inicializada");
            return;
        }
        // Seleccionar una nueva imagen
        JnaFileChooser ch = new JnaFileChooser();
        ch.addFilter("Image", "png", "jpg", "jpeg");
        boolean act = ch.showOpenDialog(SwingUtilities.getWindowAncestor(this));
        
        if (act) {
            File file = ch.getSelectedFile();
            Perfil nuevaImagen = new Perfil(file.getAbsolutePath(),file);

            // Verificar si es la misma imagen
            if (nuevaImagen.equals(fotoSeleccionada)) {
                Notifications.getInstance().show(Notifications.Type.INFO, "La imagen seleccionada es la misma");
                return;
            }

            // Reemplazar la imagen en la lista
            int index = imagenesVariante.indexOf(fotoSeleccionada);
            if (index != -1) {
                imagenesVariante.set(index, nuevaImagen); // Reemplazar el elemento
                cargarListaDeImagenes(); // Refrescar la lista
                Notifications.getInstance().show(Notifications.Type.SUCCESS, "Imagen actualizada correctamente");
            } else {
                Notifications.getInstance().show(Notifications.Type.ERROR, "No se pudo encontrar la imagen seleccionada en la lista");
            }
        }
    }//GEN-LAST:event_btn_actualizarImagenListaActionPerformed

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        if (perfil != null) {
            agregar(perfil);
            imagen.setImage(null);
        }
    }//GEN-LAST:event_btn_agregarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        imagen.setImage(null);
    }//GEN-LAST:event_btn_eliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_actualizarImagenLista;
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_eliminarImagenLista;
    private javax.swing.JButton btn_seleccionar;
    private javax.swing.JSpinner cantidad;
    private javax.swing.JComboBox<ColorRopa> cbo_colores;
    private javax.swing.JComboBox<Modelo.Talla> cbo_tallas;
    private javaswingdev.picturebox.PictureBox imagen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JList<Perfil> listaDeImagenes;
    private javax.swing.JPanel panelImagen;
    // End of variables declaration//GEN-END:variables
}
