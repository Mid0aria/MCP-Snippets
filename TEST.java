package shaderclient.mods.impl;

import shaderclient.gui.hud.ScreenPosition;
import shaderclient.mods.ModDraggable;

public class TEST extends ModDraggable{

	@Override
	public int getWidth() {
		return 50;
	}

	@Override
	public int getHeight() {
		return font.FONT_HEIGHT;
	}

	@Override
	public void render(ScreenPosition pos) {
		font.drawString("§6Test" , pos.getAbsoluteX(), pos.getAbsoluteY(), -1);
	}
	
	@Override
	public void renderDummy(ScreenPosition pos) {
		font.drawString("§6Test"  , pos.getAbsoluteX(), pos.getAbsoluteY(), -1);
	}

}
