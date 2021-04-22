package me.interdict0r.apex.module.modules.player;

import me.interdict0r.apex.module.Category;
import me.interdict0r.apex.module.Module;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;

public class Sprint extends Module {


    public Sprint() {
        super("sprint", "makes the player sprint", Category.PLAYER);
        this.setKey(Keyboard.KEY_M);
    }

    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event){
        if(mc.player.moveForward > 0 && !mc.player.isSneaking()){
            mc.player.setSprinting(true);
        }
    }
}
