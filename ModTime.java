package shaderclient.mods.impl;
 
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import shaderclient.gui.hud.ScreenPosition;
import shaderclient.mods.ModDraggable;


public class ModTime extends ModDraggable {
	
	@Override
	public int getWidth() {
    // Hour:Minute:Second AM/PM PST
		return font.getStringWidth("Time: AA:AA:AA AA AAA");
	}

	@Override
	public int getHeight() {
		return font.FONT_HEIGHT;
	}

	@Override
	public void render(ScreenPosition pos) {
		String pattern = "hh:mm:ss a z";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String time = simpleDateFormat.format(new Date());
		font.drawString("Time: " + time, pos.getAbsoluteX() + 1, pos.getAbsoluteY() + 1, -1);
	}
	
	@Override
	public void renderDummy(ScreenPosition pos) {
		String pattern = "hh:mm:ss a z";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String time = simpleDateFormat.format(new Date());
		font.drawString("Time: " + time, pos.getAbsoluteX() + 1, pos.getAbsoluteY() + 1, -1);
	}
	
}