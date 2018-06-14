package com.example.moduleexample;

import me.eftelist.base.plugin.Core;
import me.eftelist.modulesystem.IModule;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class ExampleModule implements IModule {

    private boolean enabled = false;

    public void onLoad() {
        enabled = false;
    }

    public void onEnable() {
        enabled = true;
        Core.registerListener(new Listener() {
            @EventHandler
            public void handle(PlayerJoinEvent event){
                if(getEnabled()){
                    Bukkit.broadcastMessage("Works...");
                }
            }
        });
    }

    public void onDisable() {
        enabled = false;
    }

    public boolean getEnabled() {
        return enabled;
    }
}
