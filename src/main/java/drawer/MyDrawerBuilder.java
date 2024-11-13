package drawer;

import raven.drawer.component.SimpleDrawerBuilder;
import raven.drawer.component.footer.SimpleFooterData;
import raven.drawer.component.header.SimpleHeaderData;
import raven.drawer.component.menu.SimpleMenuOption;
import raven.drawer.component.menu.data.MenuItem;
import raven.swing.AvatarIcon;

public class MyDrawerBuilder extends SimpleDrawerBuilder {

    @Override
    public SimpleHeaderData getSimpleHeaderData() {
                    return new SimpleHeaderData()
                    .setIcon(new AvatarIcon("src/main/resources/Perfiles/perfil.png", 60, 60, 999))
                    .setTitle("Arley User")
                    .setDescription("arleyuser@example.com");
    }

    @Override
    public SimpleMenuOption getSimpleMenuOption() {
    return new SimpleMenuOption()
            .setMenus(new MenuItem[]{});
    }

    @Override
    public SimpleFooterData getSimpleFooterData() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
