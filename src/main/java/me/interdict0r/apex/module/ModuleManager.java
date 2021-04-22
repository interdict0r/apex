package me.interdict0r.apex.module;

import akka.actor.Kill;
import me.interdict0r.apex.Main;
import me.interdict0r.apex.module.modules.exploits.EzDupe;
import me.interdict0r.apex.module.modules.player.Flight;
import me.interdict0r.apex.module.modules.player.Sprint;
import me.interdict0r.apex.module.modules.pvp.KillAura;
import me.interdict0r.apex.module.modules.render.FullBright;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager {

    public ArrayList<Module> modules;

    public ModuleManager(){
        (modules = new ArrayList<Module>()).clear();
        // player
        this.modules.add(new Sprint());
        this.modules.add(new FullBright());
        this.modules.add(new KillAura());
        this.modules.add(new EzDupe());
        this.modules.add(new Flight());
    }

    public Module getModule (String name){

        for(Module m : this.modules){
            if(m.getName().equalsIgnoreCase(name)){
                return m;
            }
        }
        return null;
    }

    public ArrayList<Module> getModuleList(){
        return this.modules;
    }

    public static List<Module> getModulesByCategory(Category c){
        List<Module> modules = new ArrayList<Module>();

        for(Module m : Main.moduleManager.modules){
            if(m.getCategory() == c){
                modules.add(m);
            }
        }
        return modules;
    }
}
