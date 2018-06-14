package me.eftelist.base.plugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.io.File;

public class ModuleCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if(args.length < 2){
            return true;
        } else {
            String module = args[1];
            if(Core.getManager().moduleExist(module)) {
                if(args[0].equalsIgnoreCase("enable")){
                    Core.getManager().loadModule(module);
                    commandSender.sendMessage(ChatColor.GREEN + "Module loading.");
                }
                if(args[0].equalsIgnoreCase("disable")){
                    commandSender.sendMessage(ChatColor.GOLD + "Module unloading.");
                    Core.getManager().disableModule(module);
                }
            } else {
                commandSender.sendMessage(ChatColor.RED + "Module doesn't exists.");
            }
        }
        return false;
    }
}
