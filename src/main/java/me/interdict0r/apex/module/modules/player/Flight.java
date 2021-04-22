package me.interdict0r.apex.module.modules.player;

import me.interdict0r.apex.module.Category;
import me.interdict0r.apex.module.Module;
import org.lwjgl.input.Keyboard;

public class Flight extends Module {

    public Flight() {
        super("flight", "flight module", Category.PLAYER);
        this.setKey(Keyboard.KEY_G);
    }
}
