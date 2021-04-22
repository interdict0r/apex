package me.interdict0r.apex.module.modules.render;

import me.interdict0r.apex.module.Category;
import me.interdict0r.apex.module.Module;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;
import me.interdict0r.apex.module.Category;
import org.lwjgl.input.Keyboard;

import java.util.Arrays;

public class FullBright extends Module {

    public FullBright() {
        super("fullbright", "fullbright", Category.RENDER);
        this.setKey(Keyboard.KEY_L);
    }

    @Override
    public void onEnable(){
        Arrays.fill(mc.world.provider.getLightBrightnessTable(), 1.0F);
    }

    @Override
    public void onDisable(){
        Arrays.fill(mc.world.provider.getLightBrightnessTable(), 0.5F);
    }
}
