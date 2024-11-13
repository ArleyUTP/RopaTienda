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
        titulo.putClientProperty(FlatClientProperties.STYLE, ""
                + "foreground:#39E079"); // Color verde esmeralda
        this.setLocationRelativeTo(null);
        //Configurar Temporizador para 20 segundos
        Timer timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Cerra el Jframe Actual y Abrir el Siguiente Login
                dispose();
                new Vista_login().setVisible(true);
            }
        });
        timer.setRepeats(false);//Asegura que solo se ejecute una vez
        timer.start();//Inciar el temporizador
        // Temporizador para actualizar la barra de progreso cada 200 ms
        Timer progressTimer = new Timer(200, new ActionListener() {
            private int progress = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                progress += 1; // Incrementa el progreso en 1%
                barraDeCarga.setValue(progress); // Actualiza el valor de la barra
                if (progress >= 100) {
                    ((Timer) e.getSource()).stop(); // Detiene el temporizador cuando llega al 100%
                }
            }
        });
        progressTimer.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();
        barraDeCarga = new raven.swing.spinner.SpinnerProgress();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        panel.setOpaque(false);

        titulo.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        titulo.setForeground(new java.awt.Color(102, 255, 48));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("BIENVENIDO");

        barraDeCarga.setValue(50);
        barraDeCarga.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/dinero.png"))); // NOI18N
        barraDeCarga.setIndeterminate(true);
        barraDeCarga.setStringPainted(true);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titulo)
                .addGap(99, 99, 99))
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(barraDeCarga, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106)
                .addComponent(jLabel1)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(263, 263, 263)
                        .addComponent(jLabel1))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(titulo)
                        .addGap(88, 88, 88)
                        .addComponent(barraDeCarga, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(173, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private raven.swing.spinner.SpinnerProgress barraDeCarga;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel panel;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
