package net.crossscar.cshacks.gui;

import net.crossscar.cshacks.gui.CsScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

public class CsOpenButton extends ButtonWidget {
	public CsOpenButton(int x, int y, int width, int height, Screen screen) {
		super(x, y, width, height, Text.of("csHacks"), button -> MinecraftClient.getInstance().setScreen(new CsScreen(screen)), ButtonWidget.DEFAULT_NARRATION_SUPPLIER);
	}
}
