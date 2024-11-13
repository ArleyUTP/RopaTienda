package drawer;

import Vista_Orden.Orden;
import Vista_Usuarios.Mantenimiento_Usuarios;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import raven.drawer.component.DrawerPanel;
import raven.drawer.component.SimpleDrawerBuilder;
import raven.drawer.component.footer.SimpleFooterData;
import raven.drawer.component.header.SimpleHeaderData;
import raven.drawer.component.menu.MenuAction;
import raven.drawer.component.menu.MenuEvent;
import raven.drawer.component.menu.MenuValidation;
import raven.drawer.component.menu.SimpleMenuOption;
import raven.swing.AvatarIcon;
import raven.toast.Notifications;

public class MyDrawerBuilder extends SimpleDrawerBuilder {

    private JPanel contenedor;

    public MyDrawerBuilder(JPanel contenedor) {
        this.contenedor = contenedor;  // Inicialización del panel contenedor
    }

    public MyDrawerBuilder() {
    }

    @Override
    public void build(DrawerPanel drawerPanel) {
        super.build(drawerPanel);

        // Cambiar color de fondo del header
        if (header != null) {
            header.setBackground(new java.awt.Color(80, 200, 120)); // Verde esmeralda
        }

        // Cambiar color de fondo del scroll del menú
        if (menuScroll != null) {
            menuScroll.getViewport().setBackground(new java.awt.Color(80, 200, 120));
            menuScroll.setBackground(new java.awt.Color(80, 200, 120));
        }

        // Cambiar color de fondo del menú
        if (menu != null) {
            menu.setBackground(new java.awt.Color(80, 200, 120));
        }

        // Cambiar color del footer si es necesario
        if (footer != null) {
            footer.setBackground(new java.awt.Color(80, 200, 120));
        }
    }

    @Override
    public SimpleHeaderData getSimpleHeaderData() {
        return new SimpleHeaderData()
                .setIcon(new AvatarIcon("src/main/resources/Perfiles/perfil.png", 60, 60, 999))
                .setTitle("Arley User")
                .setDescription("arleyuser@example.com");
    }

    @Override
    public SimpleMenuOption getSimpleMenuOption() {
        String menus[][] = {
            {"~Menu Principal~"},
            {"Dashboard"},
            {"~Mantenimientos~"},
            {"Mantenimientos", "Productos", "Usuarios"},
            {"~Generar~"},
            {"Generar", "Order", "Factura"}
        };

        String icons[] = {
            "menu.svg",
            "maintenance.svg" // Icono para Mantenimientos
        };

        return new SimpleMenuOption()
                .setMenus(menus)
                .setIcons(icons)
                .setBaseIconPath("gamarra/drawer/icon") // Carpeta de iconos
                .setIconScale(0.45f)
                .addMenuEvent(new MenuEvent() {
                    @Override
                    public void selected(MenuAction action, int index, int subIndex) {
                        if (index == 1) { // Mantenimientos
                            if (subIndex == 0) {

                            } else if (subIndex == 1) {

                            } else if (subIndex == 2) {
                                Mantenimiento_Usuarios mantenimiento_Usuarios = new Mantenimiento_Usuarios();
                                mantenimiento_Usuarios.setVisible(true);
                            }
                        } else if (index == 2) {
                            if (subIndex == 0) {

                            } else if (subIndex == 1) {
                                if (contenedor != null) {
                                    Orden orden = new Orden();
                                    contenedor.setLayout(new BorderLayout());
                                    contenedor.removeAll(); // Asegúrate de limpiar antes de añadir
                                    contenedor.add(orden, BorderLayout.CENTER);
                                    contenedor.revalidate();
                                    contenedor.repaint();
                                } else {
                                    System.out.println("El contenedor es nulo. No se puede mostrar el panel.");
                                }
                            }
                        }
                        System.out.println("Menu selected " + index + " " + subIndex);
                    }
                })
                .setMenuValidation(new MenuValidation() {
                    @Override
                    public boolean menuValidation(int index, int subIndex) {
                        return true; // Todos los menús están habilitados
                    }
                });
    }

    @Override
    public SimpleFooterData getSimpleFooterData() {
        return new SimpleFooterData();
    }

}
