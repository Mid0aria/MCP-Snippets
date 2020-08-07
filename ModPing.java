package shaderclient.mods.impl;

import java.awt.Color;
import net.minecraft.client.gui.Gui;
import shaderclient.gui.hud.ScreenPosition;
import shaderclient.mods.ModDraggable;

public class ModPing extends ModDraggable {
		
	@Override
	public int getWidth() {
		return 40;
		
	}

	@Override
	public int getHeight() {
		
		return font.FONT_HEIGHT;
		
	}

	@Override
	public void render(ScreenPosition pos) {
		int ping = mc.getMinecraft().getNetHandler().getPlayerInfo(mc.getMinecraft().thePlayer.getUniqueID()).getResponseTime();
		
		if(ping <= 10) {
			font.drawStringWithShadow("§bPING: " + ping , pos.getAbsoluteX(), pos.getAbsoluteY(), -1);
			return;
		} else if (ping <= 50) {
			font.drawStringWithShadow("§aPING: " + ping , pos.getAbsoluteX(), pos.getAbsoluteY(), -1);
			return;
		} else if (ping <= 100) {
			font.drawStringWithShadow("§2PING: " + ping , pos.getAbsoluteX(), pos.getAbsoluteY(), -1);
			return;
		} else if (ping <= 150) {
			font.drawStringWithShadow("§ePING: " + ping , pos.getAbsoluteX(), pos.getAbsoluteY(), -1);
			return;
		} else if (ping <= 180) {
			font.drawStringWithShadow("§cPING: " + ping , pos.getAbsoluteX(), pos.getAbsoluteY(), -1);
			return;
		} else {
			font.drawStringWithShadow("§4PING: " + ping , pos.getAbsoluteX(), pos.getAbsoluteY(), -1);
			return;
		}
		
	}
	

}