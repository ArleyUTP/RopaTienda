package Vista;

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
// Configurar Temporizador para 20 segundos
    Timer timer = new Timer(20, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Cerrar el Jframe actual y abrir el siguiente login
            dispose();
            new Vista_login().setVisible(true);
        }
    });
    timer.setRepeats(false); // Asegura que solo se ejecute una vez
    timer.start(); // Iniciar el temporizador

    // Configuración de la barra de progreso
    barraDeCarga.setStringPainted(true);  // Asegura que el texto se muestre en la barra
    barraDeCarga.setIndeterminate(false); // Desactiva el modo indeterminado

    // Temporizador para actualizar la barra de progreso cada 200 ms
    Timer progressTimer = new Timer(20, new ActionListener() {
        private int progress = 0;

        @Override
        public void actionPerformed(ActionEvent e) {
            progress += 1; // Incrementa el progreso en 1%
            barraDeCarga.setValue(progress); // Actualiza el valor de la barra de progreso
            barraDeCarga.setString(progress + "%"); // Establece el texto del porcentaje en la barra

            if (progress >= 100) {
                ((Timer) e.getSource()).stop(); // Detiene el temporizador cuando llega al 100%
            }
        }
    });
    progressTimer.start();

    // Configurar la barra de progreso para que tenga valores entre 0 y 100
    barraDeCarga.setMinimum(0);
    barraDeCarga.setMaximum(100);
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
        barraDeCarga.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/dinero.png"))); // NOI18N
        barraDeCarga.setIndeterminate(true);
        barraDeCarga.setStringPainted(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(barraDeCarga, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                        .addGap(64, 64, 64)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(barraDeCarga, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                .addGap(83, 83, 83))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private raven.swing.spinner.SpinnerProgress barraDeCarga;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}
