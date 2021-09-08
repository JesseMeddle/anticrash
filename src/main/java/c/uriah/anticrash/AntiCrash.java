package c.uriah.anticrash;

import c.uriah.anticrash.proxy.CommonProxy;
import c.uriah.anticrash.util.Reference;
import net.minecraft.client.gui.FontRenderer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class AntiCrash {
	
	public static FontRenderer fontRenderer;
	
	@Instance
	public AntiCrash instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@EventHandler
	public void PreInit (FMLPreInitializationEvent event) {
		
	}
	
	@EventHandler
	public void init (FMLPreInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(this);
		System.out.println("[AntiCrash] initialization completed.");
	}
	
	@EventHandler
	public void PositInit (FMLPreInitializationEvent event) {
		
	}
}
