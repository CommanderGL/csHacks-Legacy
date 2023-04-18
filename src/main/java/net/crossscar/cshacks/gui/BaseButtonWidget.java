package net.crossscar.cshacks.gui;

import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

public class BaseButtonWidget extends ButtonWidget {
	public BaseButtonWidget(int x, int y, int width, int height, Text text, ButtonWidget.PressAction onPress) {
		super(x, y, width, height, text, onPress, ButtonWidget.DEFAULT_NARRATION_SUPPLIER);
	}
}
