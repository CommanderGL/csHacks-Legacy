package net.crossscar.cshacks.gui;

import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WPlainPanel;
import io.github.cottonmc.cotton.gui.widget.WButton;
import io.github.cottonmc.cotton.gui.widget.data.Insets;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class CsScreen extends LightweightGuiDescription {
    public static boolean fly = false;
    public static boolean reach = false;
    public static WButton flyButton;
    public static WButton reachButton;

    public CsScreen(Screen previousScreen) {
        WPlainPanel root = new WPlainPanel();
        root.setInsets(new Insets(25));
        setRootPanel(root);

        WButton backButton = new WButton(Text.of("Back"));
        backButton.setOnClick(() -> MinecraftClient.getInstance().setScreen(previousScreen));
        root.add(backButton, 12, 0, 46, 20);

        WButton flyButton = new WButton(Text.of("Flying [OFF]"));
        flyButton.setOnClick(() -> this.toggleFly());
        root.add(flyButton, 0, 30, 70, 20);
        this.flyButton = flyButton;
        
        WButton reachButton = new WButton(Text.of("Reach [OFF]"));
        reachButton.setOnClick(() -> this.toggleReach());
        root.add(reachButton, 0, 60, 70, 20);
        this.reachButton = reachButton;

        if (fly) {
            flyButton.setLabel(Text.of("Flying [ON]"));
        }
        
        if (reach) {
            reachButton.setLabel(Text.of("Reach [ON]"));
        }

        root.validate(this);
    }

    public void toggleFly() {
        this.fly = !this.fly;
        if (fly) {
            this.flyButton.setLabel(Text.of("Flying [ON]"));
        }
        if (!fly) {
            this.flyButton.setLabel(Text.of("Flying [OFF]"));
        }
    }
    
    public void toggleReach() {
        this.reach = !this.reach;
        if (reach) {
            this.reachButton.setLabel(Text.of("Reach [ON]"));
        }
        if (!reach) {
            this.reachButton.setLabel(Text.of("Reach [OFF]"));
        }
    }
}
