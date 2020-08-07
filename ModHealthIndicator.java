package shaderclient.mods.impl;

import net.minecraft.entity.EntityLiving;
import shaderclient.gui.hud.ScreenPosition;
import shaderclient.mods.ModDraggable;

public class ModHealthIndicator extends ModDraggable {

	    @Override
	    public int getWidth() {
	        return font.getStringWidth("HP: 20");
	    }

	    @Override
	    public int getHeight() {
	        return font.FONT_HEIGHT;
	    }

	    @Override
	    public void render(ScreenPosition pos) {
	        if (this.mc.pointedEntity != null) {
	            if (this.mc.pointedEntity instanceof EntityLiving) {
	                EntityLiving entityRaytraced = (EntityLiving) this.mc.pointedEntity;
	                font.drawString("HP: " + (int) entityRaytraced.getHealth(), pos.getAbsoluteX() + 1, pos.getAbsoluteY() + 1, -1);
	            }
	        }
	        
	    }
	    
	    @Override
	    public void renderDummy(ScreenPosition pos) {
	        font.drawString("HP: 20", pos.getAbsoluteX() + 1, pos.getAbsoluteY() + 1, 0xFF00FF00);
	    }

	 

}

