package me.interdict0r.apex.module.modules.pvp;

import me.interdict0r.apex.module.Category;
import me.interdict0r.apex.module.Module;
import org.lwjgl.input.Keyboard;

public class KillAura extends Module {

    public KillAura() {
        super("killaura", "automatic attack module", Category.PVP);
        this.setKey(Keyboard.KEY_R);
    }
}
