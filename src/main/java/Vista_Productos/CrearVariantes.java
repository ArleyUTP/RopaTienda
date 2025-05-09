package Vista_Productos;

import Modelo.*;
import Persistencia.ColorDAO;
import Persistencia.FotosInventarioDAO;
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

    private ProductoInventario productoInventarioCargado;
    private List<Perfil> imagenesVariante;
    private Perfil perfilCapturado;
    private DefaultListModel<Perfil> modeloImagenes;

    public CrearVariantes() {
        initComponents();
        this.imagenesVariante = new ArrayList<>();
        this.modeloImagenes = new DefaultListModel<>(); // Se inicializa un único modelo
        listaDeImagenes.setModel(modeloImagenes); // Vincula el modelo con el JList
        listaDeImagenes.setCellRenderer(new ImageListRenderer(listaDeImagenes)); // Renderizado personalizado
        llenarListas();
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
        int idvariante = productoInventarioCargado != null ? productoInventarioCargado.getIdVariante() : 0;
        Talla tallaSeleccionada = (Talla) cbo_tallas.getSelectedItem();
        ColorRopa colorSeleccionado = (ColorRopa) cbo_colores.getSelectedItem();
        int cantidadSeleccionada = (int) cantidad.getValue();

        return new Object[]{
            idvariante,
            tallaSeleccionada,
            colorSeleccionado,
            cantidadSeleccionada,
            (List<Perfil>) imagenesVariante
        };
    }

    private void cargarListaDeImagenes() {
        DefaultListModel<Perfil> modelo = new DefaultListModel<>();

        if (productoInventarioCargado != null) {
            // Si el productoInventarioCargado no es null, cargar imágenes desde la base de datos
            FotosInventarioDAO fotosInventarioDAO = new FotosInventarioDAO();
            List<FotosInventario> fotosInventarios = fotosInventarioDAO.obtenerFotosInventarioPorIdInventario(productoInventarioCargado);

            if (!fotosInventarios.isEmpty()) {
                imagenesVariante.clear(); // Limpia la lista local antes de agregar nuevas imágenes
                fotosInventarios.forEach(fotoinventario -> {
                    Perfil imagen_a_cargar = fotoinventario.getImagen();
                    imagenesVariante.add(imagen_a_cargar); // Actualiza la lista local
                    modelo.addElement(imagen_a_cargar); // Actualiza el modelo del JList
                });
            } else {
                System.out.println("No se encontraron imágenes en la base de datos para el producto cargado.");
            }
        } else if (imagenesVariante != null) {
            // Si no hay producto cargado, utilizar la lista local de imágenes (imagenesVariante)
            imagenesVariante.forEach(modelo::addElement);
        } else {
            System.out.println("La lista de imágenes variante está vacía.");
        }

        // Establecer el modelo actualizado en la lista
        listaDeImagenes.setModel(modelo);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
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

    private void btn_seleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_seleccionarActionPerformed
// TODO add your handling code here:
        JnaFileChooser ch = new JnaFileChooser();
        ch.addFilter("Image", "png", "jpg", "jpeg");
        boolean act = ch.showOpenDialog(SwingUtilities.getWindowAncestor(this));
        if (act) {
            File file = ch.getSelectedFile();
            perfilCapturado = new Perfil(file.getAbsolutePath(), file);
            // Validar si la imagen ya existe en la lista
            if (imagenesVariante.contains(perfilCapturado)) {
                Notifications.getInstance().show(Notifications.Type.ERROR, "La imagen seleccionada ya existe");
                return; // Retorno temprano para evitar continuar
            }

            // Si no existe, se agrega la imagen
            imagen.setImage(new ImageIcon(file.getAbsolutePath()));
        }

    }//GEN-LAST:event_btn_seleccionarActionPerformed

    private void agregar(Perfil pefil_a_agregar) {
        imagenesVariante.add(pefil_a_agregar);
        this.perfilCapturado = null;
        cargarListaDeImagenes();
    }
    private void btn_eliminarImagenListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarImagenListaActionPerformed
        Perfil fotoSeleccionada = (Perfil) listaDeImagenes.getSelectedValue();
        if (fotoSeleccionada == null) {
            Notifications.getInstance().show(Notifications.Type.WARNING, "Seleccione una imagen para eliminar.");
            return;
        }
        if (productoInventarioCargado != null) {
            FotosInventarioDAO fotosInventarioDAO = new FotosInventarioDAO();
            if (fotosInventarioDAO.eliminarFotoInventario(fotoSeleccionada)) {
                Notifications.getInstance().show(Notifications.Type.SUCCESS, "Imagen eliminada correctamente");
                imagenesVariante.remove(fotoSeleccionada);
                cargarListaDeImagenes();
            } else {
                Notifications.getInstance().show(Notifications.Type.ERROR, "No se pudo eliminar la imagen.");
            }
        } else {
            if (imagenesVariante.remove(fotoSeleccionada)) {
                cargarListaDeImagenes();
                Notifications.getInstance().show(Notifications.Type.SUCCESS, "Imagen eliminada correctamente");
            } else {
                Notifications.getInstance().show(Notifications.Type.ERROR, "No se pudo eliminar la imagen.");
            }
        }
    }//GEN-LAST:event_btn_eliminarImagenListaActionPerformed

    private void btn_actualizarImagenListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarImagenListaActionPerformed
        Perfil fotoSeleccionada = (Perfil) listaDeImagenes.getSelectedValue();
        if (fotoSeleccionada == null) {
            Notifications.getInstance().show(Notifications.Type.WARNING, "Seleccione una imagen para actualizar.");
            return;
        }

        JnaFileChooser ch = new JnaFileChooser();
        ch.addFilter("Image", "png", "jpg", "jpeg");
        boolean act = ch.showOpenDialog(SwingUtilities.getWindowAncestor(this));

        if (act) {
            File file = ch.getSelectedFile();
            Perfil nuevaImagen = new Perfil(file.getAbsolutePath(), file);

            // Verificar duplicados
            if (imagenesVariante.stream().anyMatch(nuevaImagen::equals)) {
                Notifications.getInstance().show(Notifications.Type.INFO, "La imagen ya existe en la lista");
                return;
            }
            int index = imagenesVariante.indexOf(fotoSeleccionada);
            System.out.println("indice de foto selecionada: " + index);
            System.out.println("id de foto selecionada" + fotoSeleccionada.getId());
            if (index != -1) {
                if (productoInventarioCargado != null) {
                    FotosInventario fotosInventario = new FotosInventario();
                    fotosInventario.setId(fotoSeleccionada.getId());
                    fotosInventario.setIdInventario(productoInventarioCargado.getIdVariante());
                    fotosInventario.setImagen(nuevaImagen);
                    FotosInventarioDAO fotosInventarioDAO = new FotosInventarioDAO();
                    if (fotosInventarioDAO.actualizarFotoInventario(fotosInventario)) {
                        Notifications.getInstance().show(Notifications.Type.SUCCESS, "Imagen actualizada en la base de datos.");
                    } else {
                        Notifications.getInstance().show(Notifications.Type.ERROR, "No se pudo actualizar la imagen en la base de datos.");
                        return;
                    }
                }
                // Actualizar en la lista local
                imagenesVariante.set(index, nuevaImagen);
                cargarListaDeImagenes();
                Notifications.getInstance().show(Notifications.Type.SUCCESS, "Imagen actualizada correctamente.");
            } else {
                Notifications.getInstance().show(Notifications.Type.ERROR, "No se pudo encontrar la imagen seleccionada en la lista.");
            }
        }
    }//GEN-LAST:event_btn_actualizarImagenListaActionPerformed

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        if (productoInventarioCargado != null) {
            if (perfilCapturado != null) {
                FotosInventarioDAO fotosInventarioDAO = new FotosInventarioDAO();
                FotosInventario fotosInventario = new FotosInventario();
                fotosInventario.setIdInventario(productoInventarioCargado.getIdVariante());
                fotosInventario.setImagen(perfilCapturado);
                if (fotosInventarioDAO.crearFotoInventario(fotosInventario)) {
                    Notifications.getInstance().show(Notifications.Type.SUCCESS, "Imagen Agregada Correctamente");
                }
                agregar(perfilCapturado);
            }
        } else {
            if (perfilCapturado != null) {
                agregar(perfilCapturado);
                perfilCapturado = null; // Limpia el perfil capturado después de agregarlo.
                imagen.setImage(null);
            }
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

    public void cargarDatos(ProductoInventario productoInventario) {
        this.productoInventarioCargado = productoInventario;
        cbo_tallas.setSelectedItem(productoInventario.getTalla());
        cbo_colores.setSelectedItem(productoInventario.getColorRopa());
        this.cantidad.setValue(productoInventario.getStock());

        DefaultListModel<Perfil> modelo = new DefaultListModel<>();
        listaDeImagenes.setModel(modelo); // Limpia la lista de imágenes previamente cargadas

        if (productoInventarioCargado != null) {
            try {
                FotosInventarioDAO fotosInventarioDAO = new FotosInventarioDAO();
                List<FotosInventario> fotosInventarios = fotosInventarioDAO.obtenerFotosInventarioPorIdInventario(productoInventario);

                if (fotosInventarios != null && !fotosInventarios.isEmpty()) {
                    imagenesVariante.clear(); // Limpia la lista local
                    fotosInventarios.forEach(fotoInventario -> {
                        Perfil imagen_a_cargar = fotoInventario.getImagen();
                        imagenesVariante.add(imagen_a_cargar); // Actualiza la lista local
                        modelo.addElement(imagen_a_cargar); // Actualiza el modelo del JList
                    });
                    listaDeImagenes.setModel(modelo);
                } else {
                    Notifications.getInstance().show(Notifications.Type.INFO, "No hay imágenes asociadas a este producto.");
                }
            } catch (Exception e) {
                Notifications.getInstance().show(Notifications.Type.ERROR, "Error al cargar las imágenes: " + e.getMessage());
            }
        }
    }

}
