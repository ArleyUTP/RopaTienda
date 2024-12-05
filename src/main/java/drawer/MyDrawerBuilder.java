package drawer;

import Dashboard.Dashboard;
import Modelo.Usuario;
import Vista_Orden.Orden;
import Vista_Productos.Mantenimiento_Productos;
import Vista_Usuarios.Man_Usuarios;
import java.awt.BorderLayout;
import java.awt.Color;
import raven.drawer.component.DrawerPanel;
import raven.drawer.component.SimpleDrawerBuilder;
import raven.drawer.component.footer.SimpleFooterData;
import raven.drawer.component.header.SimpleHeaderData;
import raven.drawer.component.menu.MenuAction;
import raven.drawer.component.menu.MenuEvent;
import raven.drawer.component.menu.MenuValidation;
import raven.drawer.component.menu.SimpleMenuOption;

public class MyDrawerBuilder extends SimpleDrawerBuilder {
    
    public Usuario usuario;
//    private JPanel contenedor;
    private Vista.ContedorDePaneles contenedor;
    
    public MyDrawerBuilder(Vista.ContedorDePaneles contenedor) {
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
            menu.setBackground(Color.decode("#39E079"));
        }

        // Cambiar color del footer si es necesario
        if (footer != null) {
            footer.setBackground(new java.awt.Color(80, 200, 120));
        }
    }
    
    @Override
    public SimpleHeaderData getSimpleHeaderData() {
        return new SimpleHeaderData();
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
                        if (index == 0) {
                            if (subIndex == 0) {
                                Dashboard dashboard = new Dashboard();
                                contenedor.removeAll(); // Asegúrate de limpiar antes de añadir
                                contenedor.add(dashboard, BorderLayout.CENTER);
                                contenedor.revalidate();
                                contenedor.repaint();
                            }
                        } else if (index == 1) { // Mantenimientos
                            switch (subIndex) {
                                case 0 -> {
                                }
                                case 1 -> {
                                    Mantenimiento_Productos mantenimiento_Productos = new Mantenimiento_Productos();
                                    mantenimiento_Productos.setSize(contenedor.getWidth(), contenedor.getHeight()); // Ajustar tamaño
                                    contenedor.setLayout(new BorderLayout()); // Configurar el diseño del contenedor
                                    contenedor.removeAll(); // Limpiar los componentes previos
                                    contenedor.add(mantenimiento_Productos, BorderLayout.CENTER); // Agregar el panel en el centro
                                    contenedor.revalidate(); // Validar el nuevo diseño
                                    contenedor.repaint(); // Repintar para asegurar que se vea

                                }
                                case 2 -> {
                                    Man_Usuarios man_Usuarios = new Man_Usuarios();
                                    contenedor.setLayout(new BorderLayout());
                                    contenedor.removeAll(); // Asegúrate de limpiar antes de añadir
                                    contenedor.add(man_Usuarios, BorderLayout.NORTH);
                                    contenedor.revalidate();
                                    contenedor.repaint();
                                }
                                default -> {
                                }
                            }
                        } else if (index == 2) {
                            if (subIndex == 0) {
                                
                            } else if (subIndex == 1) {
                                if (contenedor != null) {
                                    Orden orden = new Orden();
                                    orden.setUsuarioActual(contenedor.getUsuarioActual());
                                    contenedor.setLayout(new BorderLayout());
                                    contenedor.removeAll(); // Asegúrate de limpiar antes de añadir
                                    contenedor.add(orden, BorderLayout.CENTER);
                                    contenedor.revalidate();
                                    contenedor.repaint();
                                    System.out.println("Usuario Actual " + contenedor.getUsuarioActual().getNombre());
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
