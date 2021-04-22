package me.interdict0r.apex;

import me.interdict0r.apex.module.Module;
import me.interdict0r.apex.module.ModuleManager;
import me.interdict0r.apex.proxy.CommonProxy;
import me.interdict0r.apex.ui.Hud;
import me.interdict0r.apex.util.Refrence;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
import org.lwjgl.input.Keyboard;

@Mod(modid = Refrence.MOD_ID, name = Refrence.NAME, version = Refrence.VERSION)
public class Main {

    public static ModuleManager moduleManager;
    public static Hud hud;

    @Instance
    public Main instance;

    @SidedProxy(clientSide = Refrence.CLIENT_PROXY_CLASS, serverSide = Refrence.COMMON_PROXY_CLASS)
    public static CommonProxy proxy;

    @EventHandler
    public void PreInit(FMLPreInitializationEvent event){

    }

    @EventHandler
    public void init(FMLPreInitializationEvent event){
        MinecraftForge.EVENT_BUS.register(instance);
        MinecraftForge.EVENT_BUS.register(new Hud());
        MinecraftForge.EVENT_BUS.register(new ModuleManager());
        moduleManager = new ModuleManager();


        hud = new Hud();
    }

    @EventHandler
    public void PostInit(FMLPreInitializationEvent event){

    }

    @SubscribeEvent
    public void key(KeyInputEvent key) {
        if (Minecraft.getMinecraft().world == null || Minecraft.getMinecraft().player == null)
            return;
        try {
                if(Keyboard.isCreated()){
                    if(Keyboard.getEventKeyState()){
                        int keyCode = Keyboard.getEventKey();
                        if(keyCode <= 0)
                            return;
                        for(Module m : moduleManager.modules){
                            if(m.getKey() == keyCode && keyCode > 0){
                                m.toggle();
                            }
                        }
                    }
                }
            }catch(Exception q) { q.printStackTrace(); }
    }
}
