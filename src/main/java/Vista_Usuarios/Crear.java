package Vista_Usuarios;

import Modelo.Autogenerar;
import Modelo.Perfil;
import Modelo.Usuario;
import Persistencia.UsuarioDAO;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.util.UIScale;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaswingdev.picturebox.DefaultPictureBoxRender;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import jnafilechooser.api.JnaFileChooser;
import raven.toast.Notifications;

public class Crear extends javax.swing.JPanel {

    private Perfil perfil;
    private int id;

    public Crear() {
        initComponents();
        btn_activo.setSelected(true);
        datePicker.setCloseAfterSelected(true);
        datePicker.setEditor(txt_fechaNacimiento);
        imagen.setPictureBoxRender(new DefaultPictureBoxRender() {
            @Override
            public Shape render(Rectangle rectangle) {
                return createRound(rectangle, UIScale.scale(10));
            }

        });
        panelImagen.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:0,0,0,0,$Component.borderColor,,10;"
                + "background:$TextArea.background");
        chb_generar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Autogenerar autogenerar = new Autogenerar();
                if (chb_generar.isSelected()) {
                    txt_clave.setText(autogenerar.generarClave());
                } else {
                    txt_clave.setText("");
                }
            }

        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        datePicker = new raven.datetime.component.date.DatePicker();
        grupoEstado = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_apellido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_dni = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_fechaNacimiento = new javax.swing.JFormattedTextField();
        txt_clave = new javax.swing.JTextField();
        txt_usuario = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_correo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbo_rol = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        btn_activo = new javax.swing.JRadioButton();
        btn_inactivo = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        panelImagen = new javax.swing.JPanel();
        imagen = new javaswingdev.picturebox.PictureBox();
        jToolBar1 = new javax.swing.JToolBar();
        btn_seleccionar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        chb_generar = new javax.swing.JCheckBox();

        jLabel1.setText("Nombre");

        txt_nombre.setToolTipText("Nombre");
        txt_nombre.setToolTipText("Nombre");
        txt_nombre.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_nombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_nombreFocusLost(evt);
            }
        });
        txt_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_nombreKeyReleased(evt);
            }
        });

        jLabel3.setText("Apellido");

        txt_apellido.setToolTipText("Apellido");
        txt_apellido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_apellidoFocusLost(evt);
            }
        });
        txt_apellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_apellidoKeyReleased(evt);
            }
        });

        jLabel4.setText("F.Nacimiento");

        txt_dni.setToolTipText("DNI");
        txt_dni.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_dniFocusLost(evt);
            }
        });
        txt_dni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_dniKeyReleased(evt);
            }
        });

        jLabel5.setText("DNI");

        txt_fechaNacimiento.setToolTipText("Fecha De Nacimiento");
        txt_fechaNacimiento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_fechaNacimientoFocusLost(evt);
            }
        });

        txt_clave.setEditable(false);
        txt_clave.setToolTipText("Clave");
        txt_clave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_claveActionPerformed(evt);
            }
        });

        txt_usuario.setEditable(false);
        txt_usuario.setToolTipText("Usuario");

        jLabel7.setText("Usuario");

        jLabel8.setText("Correo");

        txt_correo.setToolTipText("Correo");
        txt_correo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_correoFocusLost(evt);
            }
        });

        jLabel9.setText("Rol");

        jLabel10.setText("Clave");

        cbo_rol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Vendedor" }));
        cbo_rol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_rolActionPerformed(evt);
            }
        });

        jLabel2.setText("Estado");

        grupoEstado.add(btn_activo);
        btn_activo.setText("Activo");

        grupoEstado.add(btn_inactivo);
        btn_inactivo.setText("Inactivo");

        jLabel6.setText("Imagen");

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

        btn_eliminar.setForeground(new java.awt.Color(255, 0, 0));
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, imagenLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        imagenLayout.setVerticalGroup(
            imagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imagenLayout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 144, Short.MAX_VALUE))
        );

        panelImagen.add(imagen, java.awt.BorderLayout.CENTER);

        chb_generar.setText("Generar");
        chb_generar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chb_generarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_activo)
                        .addGap(18, 18, 18)
                        .addComponent(btn_inactivo)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(panelImagen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_fechaNacimiento, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbo_rol, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_dni, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_apellido, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_nombre, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_correo, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_usuario, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_clave, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chb_generar)
                        .addGap(26, 26, 26))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txt_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txt_dni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txt_fechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(txt_correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_clave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(chb_generar)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(cbo_rol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_activo)
                        .addComponent(btn_inactivo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(panelImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        txt_nombre.getAccessibleContext().setAccessibleName("");
        txt_nombre.getAccessibleContext().setAccessibleDescription("");
    }// </editor-fold>//GEN-END:initComponents

    private void cbo_rolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_rolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_rolActionPerformed

    private void txt_nombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombreKeyReleased

        generarUsuario();
    }//GEN-LAST:event_txt_nombreKeyReleased

    private void txt_apellidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_apellidoKeyReleased
        // TODO add your handling code here:
        generarUsuario();
    }//GEN-LAST:event_txt_apellidoKeyReleased

    private void btn_seleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_seleccionarActionPerformed
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        JnaFileChooser ch = new JnaFileChooser();
        ch.addFilter("Image", "png", "jpg","jpeg");
        boolean act = ch.showOpenDialog(SwingUtilities.getWindowAncestor(this));
        if (act) {
            File file = ch.getSelectedFile();
            System.out.println("Link: "+file.getAbsolutePath());
            try {
                if (usuarioDAO.validarImagen(file)) {
                    imagen.setImage(new ImageIcon(file.getAbsolutePath()));
                    perfil = new Perfil(file);
                }
            } catch (IOException ex) {
                Logger.getLogger(Crear.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btn_seleccionarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        imagen.setImage(null);
        perfil = null;
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void chb_generarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chb_generarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chb_generarActionPerformed

    private void txt_dniKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dniKeyReleased
        // TODO add your handling code here:
        generarUsuario();
    }//GEN-LAST:event_txt_dniKeyReleased

    private void txt_claveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_claveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_claveActionPerformed

    private void txt_nombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_nombreFocusLost
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.ValidarCampoTexto(txt_nombre, txt_nombre.getToolTipText());
    }//GEN-LAST:event_txt_nombreFocusLost

    private void txt_apellidoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_apellidoFocusLost
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.ValidarCampoTexto(txt_apellido, txt_apellido.getToolTipText());
    }//GEN-LAST:event_txt_apellidoFocusLost

    private void txt_dniFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dniFocusLost
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.validarDNI(txt_dni);
    }//GEN-LAST:event_txt_dniFocusLost

    private void txt_fechaNacimientoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_fechaNacimientoFocusLost
        Date fechaNacimiento = datePicker.isDateSelected() ? Date.valueOf(datePicker.getSelectedDate()) : null;
        if (fechaNacimiento == null) {
            Notifications.getInstance().show(Notifications.Type.ERROR, "La Fecha de Nacimiento no puede estar Vacio");
        }
    }//GEN-LAST:event_txt_fechaNacimientoFocusLost

    private void txt_correoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_correoFocusLost
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.ValidarFormatoCorreo(txt_correo, txt_correo.getToolTipText());
    }//GEN-LAST:event_txt_correoFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton btn_activo;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JRadioButton btn_inactivo;
    private javax.swing.JButton btn_seleccionar;
    private javax.swing.JComboBox<String> cbo_rol;
    private javax.swing.JCheckBox chb_generar;
    private raven.datetime.component.date.DatePicker datePicker;
    private javax.swing.ButtonGroup grupoEstado;
    private javaswingdev.picturebox.PictureBox imagen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JPanel panelImagen;
    private javax.swing.JTextField txt_apellido;
    private javax.swing.JTextField txt_clave;
    private javax.swing.JTextField txt_correo;
    private javax.swing.JTextField txt_dni;
    private javax.swing.JFormattedTextField txt_fechaNacimiento;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables

    private void generarUsuario() {
        String nombre = txt_nombre.getText();
        String apellido = txt_apellido.getText();
        String dni = txt_dni.getText();
        if (nombre.isEmpty() || apellido.isEmpty() || dni.isEmpty()) {
            return;
        }
        Autogenerar autogenerar = new Autogenerar();
        String usuarioGenerado = autogenerar.generarUsuario(nombre, apellido, dni);
        txt_usuario.setText(usuarioGenerado);
    }

    public Usuario crearUsuario() {
        String nombre = txt_nombre.getText().trim();
        String apellido = txt_apellido.getText().trim();
        String dni = txt_dni.getText().trim();
        Date fechaNacimiento = datePicker.isDateSelected() ? Date.valueOf(datePicker.getSelectedDate()) : null;
        String correo = txt_correo.getText().trim();
        String usuarioString = txt_usuario.getText().trim();
        String contraseña = txt_clave.getText().trim();
        String rol = cbo_rol.getSelectedItem() != null ? cbo_rol.getSelectedItem().toString().toLowerCase() : "";
        String estado = btn_activo.isSelected() ? "activo" : (btn_inactivo.isSelected() ? "inactivo" : null);

        if (nombre.isEmpty() || apellido.isEmpty() || dni.isEmpty() || correo.isEmpty()
                || usuarioString.isEmpty() || contraseña.isEmpty() || estado == null || fechaNacimiento == null || rol.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setDni(dni);
        usuario.setCorreo(correo);
        usuario.setUsuario(usuarioString);
        usuario.setClave(contraseña);
        usuario.setEstado(estado);
        usuario.setRol(rol);
        usuario.setFechaNacimiento(fechaNacimiento);
        usuario.setPerfil(perfil);  // Asignar el perfil con la imagen
        return usuario;
    }

// Método para cargar los datos del usuario en los campos de texto
    public void cargarDatos(Usuario usuario) {
        id = usuario.getId();
        txt_nombre.setText(usuario.getNombre());
        txt_apellido.setText(usuario.getApellido());
        txt_dni.setText(usuario.getDni());
        if (usuario.getFechaNacimiento() != null) {
            LocalDate fechaNacimiento = usuario.getFechaNacimiento().toLocalDate();
            System.out.println("Fecha convertida a LocalDate: " + fechaNacimiento);
            datePicker.setSelectedDate(fechaNacimiento);
        } else {
            System.out.println("Fecha de nacimiento es nula.");
            datePicker.clearSelectedDate();
        }
        txt_correo.setText(usuario.getCorreo());
        txt_usuario.setText(usuario.getUsuario());
        txt_clave.setText(usuario.getClave());

        // Configurar el rol en el ComboBox
        if (usuario.getRol().equalsIgnoreCase("admin")) {
            cbo_rol.setSelectedItem("Admin");
        } else if (usuario.getRol().equalsIgnoreCase("vendedor")) {
            cbo_rol.setSelectedItem("Vendedor");
        }
        // Configurar el estado en los RadioButtons
        if (usuario.getEstado().equalsIgnoreCase("activo")) {
            btn_activo.setSelected(true);
        } else if (usuario.getEstado().equalsIgnoreCase("inactivo")) {
            btn_inactivo.setSelected(true);
        }
        perfil = usuario.getPerfil();
        if (perfil != null && perfil.getIcon() != null) {
            imagen.setImage(perfil.getIcon());
        } else {
            imagen.setImage(null);
        }
    }

    public Usuario obtenerDatos() {
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre(txt_nombre.getText());
        usuario.setApellido(txt_apellido.getText());
        usuario.setDni(txt_dni.getText());
        Date fechaNacimiento = datePicker.isDateSelected() ? Date.valueOf(datePicker.getSelectedDate()) : null;
        System.out.println("El valor de la fecha de Nacimiento al obtener datos es: " + fechaNacimiento);
        usuario.setFechaNacimiento(fechaNacimiento);
        usuario.setCorreo(txt_correo.getText());
        usuario.setUsuario(txt_usuario.getText());
        usuario.setClave(txt_clave.getText());
        usuario.setRol(cbo_rol.getSelectedItem().toString().toLowerCase());
        usuario.setEstado(btn_activo.isSelected() ? "activo" : "inactivo");
        usuario.setPerfil(perfil);  // Asignar el perfil directamente
        return usuario;
    }

    public boolean validar() {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        if (!usuarioDAO.ValidarCampoTexto(txt_nombre, txt_nombre.getToolTipText())) {
            return false;
        }

        if (!usuarioDAO.ValidarCampoTexto(txt_apellido, txt_apellido.getToolTipText())) {
            return false;
        }

        if (!usuarioDAO.validarDNI(txt_dni)) {
            return false;
        }

        Date fechaNacimiento = datePicker.isDateSelected() ? Date.valueOf(datePicker.getSelectedDate()) : null;
        if (fechaNacimiento == null) {
            Notifications.getInstance().show(Notifications.Type.ERROR, "La Fecha de Nacimiento no puede estar vacía");
            return false;
        }

        if (!usuarioDAO.ValidarFormatoCorreo(txt_correo, txt_correo.getToolTipText())) {
            return false;
        }

        if (!usuarioDAO.validarLongitud(txt_usuario, 3, 20, "El nombre de usuario debe tener entre 3 y 20 caracteres")) {
            return false;
        }

        if (perfil == null) {
            Notifications.getInstance().show(Notifications.Type.ERROR, "Debe seleccionar un foto de Perfil");
            return false;
        }

        return true; // Si todas las validaciones pasan
    }

}
