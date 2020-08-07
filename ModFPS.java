package shaderclient.mods.impl;

import shaderclient.gui.hud.ScreenPosition;
import shaderclient.mods.ModDraggable;

public class ModFPS extends ModDraggable{

	
	@Override
	public int getWidth() {
		return 25;
	}

	@Override
	public int getHeight() {
		return font.FONT_HEIGHT;
	}

	@Override
	public void render(ScreenPosition pos) {
		int fps = mc.getDebugFPS();
		font.drawString("FPS: " + fps , pos.getAbsoluteX(), pos.getAbsoluteY(), -1);
	}



}
