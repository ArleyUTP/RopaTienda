package Vista;

import Vista.Vista_login;
import com.formdev.flatlaf.FlatClientProperties;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Vista_bienvenida extends javax.swing.JFrame {

    public Vista_bienvenida() {
        initComponents();
        panel.putClientProperty(FlatClientProperties.STYLE, ""
                + "foreground:#E3F2FD;");  // Azul Claro Suave
        this.setLocationRelativeTo(null);
        // Configuración de la barra de progreso
        barraDeCarga.setStringPainted(true);  // Asegura que el texto se muestre en la barra
        // Temporizador para simular la carga (20 segundos)
        Timer progressTimer = new Timer(200, new ActionListener() { // 200 ms por paso
            private int progress = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                progress += 1; // Incrementar progreso en 1%
                barraDeCarga.setValue(progress); // Actualizar barra de progreso
                barraDeCarga.setString(progress + "%"); // Mostrar porcentaje en texto

                if (progress >= 100) {
                    ((Timer) e.getSource()).stop(); // Detener temporizador al 100%
                    dispose(); // Cerrar ventana actual
                    new Vista_login().setVisible(true); // Abrir la nueva ventana
                }
            }
        });

        progressTimer.start(); // Iniciar temporizador
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        barraDeCarga = new raven.swing.spinner.SpinnerProgress();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        panel.setOpaque(false);
        panel.setLayout(new java.awt.BorderLayout());
        panel.add(jLabel1, java.awt.BorderLayout.CENTER);

        barraDeCarga.setValue(50);
        barraDeCarga.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/WhatsApp Image 2024-11-20 at 20.12.16.jpeg"))); // NOI18N
        barraDeCarga.setIndeterminate(true);
        barraDeCarga.setStringPainted(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(barraDeCarga, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(barraDeCarga, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private raven.swing.spinner.SpinnerProgress barraDeCarga;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}
