package Vista_Usuarios;

import Modelo.Usuario;
import Persistencia.UsuarioDAO;
import Vista_Usuarios.table.CheckBoxTableHeaderRenderer;
import Vista_Usuarios.table.ProfileTableRenderer;
import Vista_Usuarios.table.TableHeaderAlignment;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;
import raven.popup.DefaultOption;
import raven.popup.GlassPanePopup;
import raven.popup.component.SimplePopupBorder;
import raven.toast.Notifications;

public class Man_Usuarios extends javax.swing.JPanel {

    public Man_Usuarios() {
        initComponents();
        init();
        cargarDatosTabla();
    }

    private void init() {
        panel.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:25;"
                + "background:$Table.background");
        table.getTableHeader().putClientProperty(FlatClientProperties.STYLE, ""
                + "height:30;"
                + "hoverBackground:null;"
                + "pressedBackground:null;"
                + "separatorColor:$TableHeader.background;"
                + "font:bold;");

        table.putClientProperty(FlatClientProperties.STYLE, ""
                + "rowHeight:70;"
                + "showHorizontalLines:true;"
                + "intercellSpacing:0,1;"
                + "cellFocusColor:$TableHeader.hoverBackground;"
                + "selectionBackground:$TableHeader.hoverBackground;"
                + "selectionForeground:$Table.foreground;");
        scroll.getVerticalScrollBar().putClientProperty(FlatClientProperties.STYLE, ""
                + "trackArc:999;"
                + "trackInsets:3,3,3,3;"
                + "thumbInsets:3,3,3,3;"
                + "background:$Table.background;");
        lbl_titulo.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:bold +5;");
        txt_busqueda.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Busqueda...");
        txt_busqueda.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, new ImageIcon(getClass().getResource("/Icon/busqueda.png")));
        txt_busqueda.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:15;"
                + "borderWidth:0;"
                + "focusWidth:0;"
                + "innerFocusWidth:0;"
                + "margin:5,20,5,20;"
                + "background:$Panel.background");
        btn_crear.putClientProperty(FlatClientProperties.STYLE, ""
                + "background:#39E079");
        btn_editar.putClientProperty(FlatClientProperties.STYLE, ""
                + "");
        btn_eliminar.putClientProperty(FlatClientProperties.STYLE, ""
                + "");
        table.getColumnModel().getColumn(0).setHeaderRenderer(new CheckBoxTableHeaderRenderer(table, 0));
        table.getTableHeader().setDefaultRenderer(new TableHeaderAlignment(table));
        cargarPerfiles();
        testData();
    }

    void cargarPerfiles() {
        table.getColumnModel().getColumn(2).setCellRenderer(new ProfileTableRenderer(table));
    }

    private void testData() {
        DefaultTableModel modelo = (DefaultTableModel) table.getModel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        scroll = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        lbl_titulo = new javax.swing.JLabel();
        txt_busqueda = new javax.swing.JTextField();
        btn_eliminar = new Vista_Usuarios.table.ButtonAction();
        btn_editar = new Vista_Usuarios.table.ButtonAction();
        btn_crear = new Vista_Usuarios.table.ButtonAction();

        scroll.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "SELECT", "#", "Nombre", "Apellido", "DNI", "Correo", "Usuario", "Rol"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.getTableHeader().setReorderingAllowed(false);
        scroll.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMaxWidth(40);
            table.getColumnModel().getColumn(2).setPreferredWidth(200);
        }

        lbl_titulo.setText("Usuarios");

        txt_busqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_busquedaKeyReleased(evt);
            }
        });

        btn_eliminar.setText("Eliminar");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        btn_editar.setText("Editar");
        btn_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarActionPerformed(evt);
            }
        });

        btn_crear.setText("Crear");
        btn_crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_crearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_titulo)
                            .addComponent(txt_busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(300, 367, Short.MAX_VALUE)
                        .addComponent(btn_crear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)))
                .addContainerGap())
            .addComponent(scroll)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_crear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_busquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busquedaKeyReleased

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.buscarUsuarios(txt_busqueda, table);
        cargarPerfiles();
    }//GEN-LAST:event_txt_busquedaKeyReleased

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        // TODO add your handling code here:
        List<Usuario> selectedUsers = getSelectedUsers();
        if (!selectedUsers.isEmpty()) {
            int dialogResult = JOptionPane.showConfirmDialog(this, "¿Estás seguro de eliminar los usuarios seleccionados?", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (dialogResult == JOptionPane.YES_OPTION) {
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                for (Usuario usuario : selectedUsers) {
                    usuarioDAO.eliminar(usuario);
                }
                Notifications.getInstance().show(Notifications.Type.SUCCESS, "Usuario(s) eliminado(s) exitosamente");
                cargarDatosTabla();
            }
        } else {
            Notifications.getInstance().show(Notifications.Type.WARNING, "Debes seleccionar al menos un usuario para eliminar");
        }
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void btn_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarActionPerformed
        // Lista para almacenar los usuarios seleccionados en la tabla
        List<Usuario> selectedUsers = getSelectedUsers();
        if (!selectedUsers.isEmpty()) {
            if (selectedUsers.size() == 1) {
                Usuario usuario = selectedUsers.get(0);
                Crear crear = new Crear();
                crear.cargarDatos(usuario);
                String[] actions = new String[]{"Cancelar", "Actualizar"};
                GlassPanePopup.showPopup(
                        new SimplePopupBorder(crear, "Editar Usuario [" + usuario.getNombre() + "]", actions, (popupComponent, i) -> {
                            if (i == 1) { // Opción de "Actualizar"
                                if (!crear.validar()) {
                                    return;
                                }
                                Usuario usuarioEditado = crear.obtenerDatos();
                                UsuarioDAO usuarioDAO = new UsuarioDAO();
                                try {
                                    usuarioDAO.actualizarUsuario(usuarioEditado);
                                } catch (IOException ex) {
                                    // Manejo de excepciones
                                }
                                popupComponent.closePopup();
                                Notifications.getInstance().show(Notifications.Type.SUCCESS, "Usuario actualizado exitosamente");
                                cargarDatosTabla();

                            } else {
                                popupComponent.closePopup(); // Cerrar el popup sin hacer nada
                            }
                        })
                );
            } else {
                Notifications.getInstance().show(Notifications.Type.WARNING, "Seleccionar solo un Usuario para Editar");
            }
        } else {
            Notifications.getInstance().show(Notifications.Type.WARNING, "Selecciona un usuario para editar");
        }
    }//GEN-LAST:event_btn_editarActionPerformed

    private void btn_crearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_crearActionPerformed
        Vista_Usuarios.Crear crear = new Crear();
        DefaultOption option = new DefaultOption() {
            @Override
            public boolean closeWhenClickOutside() {
                return true;
            }
        };
        String actions[] = new String[]{"Cancelar", "Guardar"};
        GlassPanePopup.showPopup(
                new SimplePopupBorder(crear, "Crear Usuario", actions, (pc, i) -> {
                    if (i == 1) {
                        if (!crear.validar()) {
                            // Si las validaciones fallan, no se cierra el popup y se muestra el error correspondiente
                            return;
                        }
                        // Lógica para crear el usuario
                        Usuario usuario = crear.crearUsuario();
                        UsuarioDAO usuarioDAO = new UsuarioDAO();
                        try {
                            usuarioDAO.crearUsuario(usuario);
                        } catch (IOException ex) {
                            // Manejo de excepciones
                        }
                        pc.closePopup();
                        Notifications.getInstance().show(Notifications.Type.SUCCESS, "Usuario creado correctamente");

                    } else {
                        pc.closePopup();
                    }
                }),
                option
        );
    }//GEN-LAST:event_btn_crearActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Vista_Usuarios.table.ButtonAction btn_crear;
    private Vista_Usuarios.table.ButtonAction btn_editar;
    private Vista_Usuarios.table.ButtonAction btn_eliminar;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl_titulo;
    private javax.swing.JPanel panel;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTable table;
    private javax.swing.JTextField txt_busqueda;
    // End of variables declaration//GEN-END:variables
private List<Usuario> getSelectedUsers() throws NullPointerException {
        List<Usuario> selectedUsers = new ArrayList<>();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        for (int i = 0; i < table.getRowCount(); i++) {
            Boolean isSelected = (Boolean) table.getValueAt(i, 0); // Columna de selección
            if (isSelected != null && isSelected) {
                int userId = (Integer) table.getValueAt(i, 1); // Columna de ID o #
                Usuario usuario = usuarioDAO.obtenerUsuarioPorId(userId); // Obtener el usuario de la base de datos
                selectedUsers.add(usuario);
            }
        }
        return selectedUsers;
    }

    private void cargarDatosTabla() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Borra todas las filas actuales

        btn_crear.setEnabled(false);
        btn_editar.setEnabled(false);
        btn_eliminar.setEnabled(false);

        SwingWorker<List<Usuario>, Void> worker = new SwingWorker<List<Usuario>, Void>() {
            @Override
            protected List<Usuario> doInBackground() throws Exception {
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                return usuarioDAO.obtenerTodosLosUsuarios();
            }

            @Override
            protected void done() {
                try {
                    List<Usuario> usuarios = get();
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    for (Usuario usuario : usuarios) {
                        Object[] fila = new Object[]{
                            false, // Checkbox
                            usuario.getId(),
                            usuario,
                            usuario.getApellido(),
                            usuario.getDni(),
                            usuario.getCorreo(),
                            usuario.getUsuario(),
                            usuario.getRol()
                        };
                        model.addRow(fila);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error al cargar los datos en la tabla", "Error", JOptionPane.ERROR_MESSAGE);
                } finally {
                    // Rehabilitar los botones después de cargar
                    btn_crear.setEnabled(true);
                    btn_editar.setEnabled(true);
                    btn_eliminar.setEnabled(true);
                }
            }
        };

        worker.execute();
    }
}
