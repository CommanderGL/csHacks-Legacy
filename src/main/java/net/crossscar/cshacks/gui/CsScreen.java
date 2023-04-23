package net.crossscar.cshacks.gui;

import dev.lambdaurora.spruceui.screen.SpruceScreen;
import dev.lambdaurora.spruceui.widget.SpruceButtonWidget;
import dev.lambdaurora.spruceui.Position;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class CsScreen extends SpruceScreen {
    public static boolean fly = false;
    public static boolean reach = false;

    private Screen previousScreen;

    private SpruceButtonWidget flyButton;

    public CsScreen(Screen previousScreen) {
        super(Text.of("csHacks"));
        this.previousScreen = previousScreen;
    }

    @Override
    protected void init() {
        super.init();
        int startx = 10;

        if (this.fly) {
            this.flyButton = new SpruceButtonWidget(Position.of(startx, 10), 70, 20, Text.of("Fly [ON]"),
                btn -> this.toggleFly());
        } else {
            this.flyButton = new SpruceButtonWidget(Position.of(startx, 10), 70, 20, Text.of("Fly [OFF]"),
                btn -> this.toggleFly());
        }
        this.addDrawableChild(flyButton);

        this.addDrawableChild(new SpruceButtonWidget(Position.of(this.width - 55, 10), 45, 20, Text.of("Back"),
                btn -> this.client.setScreen(this.previousScreen)));
    }

    public void toggleFly() {
        this.fly = !this.fly;
        if (fly) {
            this.flyButton.setMessage(Text.of("Flying [ON]"));
        }
        if (!fly) {
            this.flyButton.setMessage(Text.of("Flying [OFF]"));
        }
    }
}
