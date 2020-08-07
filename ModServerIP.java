package shaderclient.mods.impl;

import shaderclient.gui.hud.ScreenPosition;
import shaderclient.mods.ModDraggable;

public class ModServerIP extends ModDraggable {

	@Override
	public int getWidth() {
		return font.getStringWidth("IP: play.minecraft.server");
	}

	@Override
	public int getHeight() {
		return font.FONT_HEIGHT;
	}

	@Override
	public void render(ScreenPosition pos) {
		font.drawString("IP: " + mc.getCurrentServerData().serverIP, pos.getAbsoluteX(), pos.getAbsoluteY(), -1);
	}
	
	@Override
	public void renderDummy(ScreenPosition pos) {
		font.drawString("IP: play.minecraft.server", pos.getAbsoluteX(), pos.getAbsoluteY(), -1);
	}

}