package drawer;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CustomDrawer extends JFrame {

    private JPanel drawerPanel;
    private boolean isDrawerOpen = false;
    private Timer drawerTimer;
    private int drawerWidth = 250; // Ancho del Drawer

    public CustomDrawer() {
        setTitle("Custom Drawer Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Contenedor principal
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(new JLabel("Contenido Principal", SwingConstants.CENTER), BorderLayout.CENTER);
        JButton toggleDrawerButton = new JButton("Abrir Drawer");
        toggleDrawerButton.addActionListener(e -> toggleDrawer());
        mainPanel.add(toggleDrawerButton, BorderLayout.NORTH);

        // Configuración del Drawer
        drawerPanel = new JPanel();
        drawerPanel.setLayout(new BorderLayout());
        drawerPanel.setBackground(new Color(220, 220, 220));
        drawerPanel.setPreferredSize(new Dimension(drawerWidth, getHeight()));

        // Establecer encabezado y color
        setDrawerHeader("Encabezado Personalizado");
        setDrawerHeaderColor(new Color(100, 150, 200));

        // Crear botones dinámicamente
        String[] buttonLabels = {"Formulario 1", "Formulario 2", "Formulario 3"};
        Color[] buttonColors = {Color.RED, Color.GREEN, Color.BLUE};
        addDrawerButtons(buttonLabels, buttonColors);

        // Inicialmente oculto
        drawerPanel.setBounds(getWidth(), 0, drawerWidth, getHeight());
        getLayeredPane().add(drawerPanel, JLayeredPane.PALETTE_LAYER);

        add(mainPanel, BorderLayout.CENTER);
    }

    private void toggleDrawer() {
        if (drawerTimer != null && drawerTimer.isRunning()) {
            return;
        }

        int targetX = isDrawerOpen ? getWidth() : getWidth() - drawerWidth;
        int startX = isDrawerOpen ? getWidth() - drawerWidth : getWidth();

        drawerTimer = new Timer(5, new ActionListener() {
            private int currentX = startX;

            @Override
            public void actionPerformed(ActionEvent e) {
                if ((isDrawerOpen && currentX >= getWidth()) || (!isDrawerOpen && currentX <= targetX)) {
                    drawerTimer.stop();
                    isDrawerOpen = !isDrawerOpen;
                } else {
                    currentX += isDrawerOpen ? 10 : -10;
                    drawerPanel.setLocation(currentX, 0);
                    drawerPanel.repaint();
                }
            }
        });
        drawerTimer.start();
    }

    private void setDrawerHeader(String headerText) {
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(100, 150, 200));
        headerPanel.add(new JLabel(headerText));
        drawerPanel.add(headerPanel, BorderLayout.NORTH);
    }

    private void setDrawerHeaderColor(Color color) {
        JPanel headerPanel = (JPanel) drawerPanel.getComponent(0); // Suponiendo que el encabezado es el primer componente
        headerPanel.setBackground(color);
    }

    private void addDrawerButtons(String[] buttonLabels, Color[] buttonColors) {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        for (int i = 0; i < buttonLabels.length; i++) {
            JButton button = new JButton(buttonLabels[i]);
            button.setBackground(buttonColors[i]);
            final int index = i; // Usar el índice en el evento para identificar qué formulario abrir
            button.addActionListener(e -> showForm(index));
            buttonPanel.add(button);
        }

        drawerPanel.add(buttonPanel, BorderLayout.CENTER);
    }

    private void showForm(int formIndex) {
        // Mostrar formulario según el índice
        switch (formIndex) {
            case 0:
                JOptionPane.showMessageDialog(this, "Cargando: Formulario 1", "Información", JOptionPane.INFORMATION_MESSAGE);
                break;
            case 1:
                JOptionPane.showMessageDialog(this, "Cargando: Formulario 2", "Información", JOptionPane.INFORMATION_MESSAGE);
                break;
            case 2:
                JOptionPane.showMessageDialog(this, "Cargando: Formulario 3", "Información", JOptionPane.INFORMATION_MESSAGE);
                break;
            default:
                JOptionPane.showMessageDialog(this, "Formulario no disponible", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CustomDrawer frame = new CustomDrawer();
            frame.setVisible(true);
        });
    }
}
