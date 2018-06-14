package me.eftelist.base.plugin;

import me.eftelist.modulesystem.ModuleManager;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin {

    private static Plugin plugin = null;
    private static ModuleManager manager;

    @Override
    public void onLoad() {
    }

    public void onEnable(){
        plugin = this;
        manager = new ModuleManager();
        getCommand("modular").setExecutor(new ModuleCommand());
    }

    public static void registerListener(Listener listener){
        if(plugin != null){
            Bukkit.getPluginManager().registerEvents(listener,getInstance());
        }
    }

    public void onDisable(){
        manager.disableModules();
        plugin = null;
    }

    public static Plugin getInstance(){
        return plugin;
    }

    public static ModuleManager getManager() {
        return manager;
    }
}
