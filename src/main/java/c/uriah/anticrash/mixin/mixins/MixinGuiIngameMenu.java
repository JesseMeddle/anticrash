package c.uriah.anticrash.mixin.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import c.uriah.anticrash.util.Reference;

import org.spongepowered.asm.mixin.injection.At;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngameMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;

@Mixin({GuiIngameMenu.class})
public class MixinGuiIngameMenu extends GuiScreen{
	@Inject(method = {"drawScreen"}, at = {@At("TAIL")}, cancellable = true)
	public void drawText(CallbackInfo ci) {
		ScaledResolution sr = new ScaledResolution(mc);
		Minecraft.getMinecraft().fontRenderer.drawStringWithShadow("AntiCrash "+Reference.VERSION+" by Uriah", sr.getScaledWidth()-Minecraft.getMinecraft().fontRenderer.getStringWidth("AntiCrash "+Reference.VERSION+" by Uriah")-2, sr.getScaledHeight()-12, 0xaaaaaa);

	}
}
