package shaderclient.mods.impl;

import java.awt.Color;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.settings.KeyBinding;
import shaderclient.gui.hud.ScreenPosition;
import shaderclient.mods.ModDraggable;

public class ModKeystrokes extends ModDraggable {

	public static class RainbowColor {
		public static int rainbowEffect() {
	    	return Color.HSBtoRGB((float)(System.currentTimeMillis() % 3000L) / 3000.0F, 1.0F, 1.0F);
	    }
	}
	
	public static enum KeystrokesMode {
		
		WASD(Key.W, Key.A, Key.S, Key.D),
		WASD_MOUSE(Key.W, Key.A, Key.S, Key.D, Key.LMB, Key.RMB),
		WASD_SPRINT(Key.W, Key.A, Key.S, Key.D, new Key("Sprint", Minecraft.getMinecraft().gameSettings.keyBindSprint, 1, 41, 58, 18)),
		WASD_SPRINT_MOUSE(Key.W, Key.A, Key.S, Key.D, Key.LMB, Key.RMB, new Key("Sprint", Minecraft.getMinecraft().gameSettings.keyBindSprint, 1, 61, 58, 18)),
		;
		
		private final Key[] keys;
		private int width = 0;
		private int height = 0;
		
		private KeystrokesMode(Key... keysIn) {
			this.keys = keysIn;
			
			for(Key key : keys) {
				this.width = Math.max(this.width, key.getX() + key.getWidth());
				this.height = Math.max(this.height, key.getY() + key.getHeight());
			}
		}
		
		public int getHeight() {
			return height;
		}
		
		public int getWidth() {
			return width;
		}
		
		public Key[] getKeys() {
			return keys;
		}
	}
	
	private static class Key {
		
		private static final Key W = new Key("W", Minecraft.getMinecraft().gameSettings.keyBindForward, 21, 1, 18, 18);
		private static final Key A = new Key("A", Minecraft.getMinecraft().gameSettings.keyBindLeft, 1, 21, 18, 18);
		private static final Key S = new Key("S", Minecraft.getMinecraft().gameSettings.keyBindBack, 21, 21, 18, 18);
		private static final Key D = new Key("D", Minecraft.getMinecraft().gameSettings.keyBindRight, 41, 21, 18, 18);
		
		private static final Key LMB = new Key("LMB", Minecraft.getMinecraft().gameSettings.keyBindAttack, 1, 41, 28, 18);
		private static final Key RMB = new Key("RMB", Minecraft.getMinecraft().gameSettings.keyBindUseItem, 31, 41, 28, 18);
		
		private final String name;
		private final KeyBinding keyBind;
		private final int x;
		private final int y;
		private final int width;
		private final int height;
		
		public Key(String name, KeyBinding keyBind, int x, int y, int width, int height) {
			this.name = name;
			this.keyBind =keyBind;	
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
		}
		
		public boolean isDown() {
			return keyBind.isKeyDown();
		}
		
		public int getHeight() {
			return height;
		}
		
		public String getName() {
			return name;
		}
		
		public int getWidth() {
			return width;
		}
		
		public int getX() {
			return x;
		}
		
		public int getY() {
			return y;
		}
	}
	
	
	private KeystrokesMode mode = KeystrokesMode.WASD_SPRINT_MOUSE;
	
	public void setMode(KeystrokesMode mode) {
		this.mode = mode;
	}
	
	@Override
	public int getWidth() {
		return mode.getWidth();
	}

	@Override
	public int getHeight() {
		return mode.getHeight();
	}

	@Override
	public void render(ScreenPosition pos) {
		
		GL11.glPushMatrix();
		
		
		boolean blend = GL11.glIsEnabled(GL11.GL_BLEND);
		
		GL11.glDisable(GL11.GL_BLEND);
		
		for(Key key : mode.getKeys()) {
			
			int textWidth = font.getStringWidth(key.getName());
			
			Gui.drawRect(
			pos.getAbsoluteX() + key.getX(),
			pos.getAbsoluteY() + key.getY(),
			pos.getAbsoluteX() + key.getX() + key.getWidth(),
			pos.getAbsoluteY() + key.getY() + key.getHeight(),
			key.isDown() ? new Color(255, 255, 255, 102).getRGB() : new Color(0, 0, 0, 102).getRGB()
			);
			
			
			font.drawString(
			key.getName(),
			pos.getAbsoluteX() + key.getX() + key.getWidth() / 2 - textWidth / 2,
			pos.getAbsoluteY() + key.getY() + key.getHeight() / 2 - 4,
			key.isDown() ? RainbowColor.rainbowEffect() : RainbowColor.rainbowEffect()
			);
			
		}
		
		
		if(blend) {
			GL11.glEnable(GL11.GL_BLEND);
		}
		GL11.glPopMatrix();
	}


}
