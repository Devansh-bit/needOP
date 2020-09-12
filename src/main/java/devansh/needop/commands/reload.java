package devansh.needop.commands;

import devansh.needop.NeedOP;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.PluginManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class reload implements CommandExecutor {
    private NeedOP plugin;
    public reload(NeedOP plugin){this.plugin = plugin;}

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1 ) {
            if (args[0].equalsIgnoreCase("reload")) {
                if (sender.hasPermission("needop.reload")) {
                    HandlerList.unregisterAll(plugin.attackListener);
                    HandlerList.unregisterAll(plugin.breakPlaceListener);
                    HandlerList.unregisterAll(plugin.chatListener);
                    HandlerList.unregisterAll(plugin.commandListener);
                    HandlerList.unregisterAll(plugin.consoleListener);
                    HandlerList.unregisterAll(plugin.interactListener);
                    HandlerList.unregisterAll(plugin.logoutListener);
                    HandlerList.unregisterAll(plugin.moveListener);
                    HandlerList.unregisterAll(plugin.vehicleListener);
                    plugin.reloadConfig();
                    plugin.setowners(plugin.getConfig().getStringList("permission"));
                    plugin.setpasswords(plugin.getConfig().getStringList("password"));
                    plugin.setConsolestatus(plugin.getConfig().getBoolean("console-enable"));
                    plugin.setconsolepass(plugin.getConfig().getString("secret-password"));
                    plugin.setAttack(plugin.getConfig().getBoolean("damage-other-entities"));
                    plugin.setBreakblocks(plugin.getConfig().getBoolean("break-blocks"));
                    plugin.setMovement(plugin.getConfig().getBoolean("move"));
                    plugin.setPlaceblocks(plugin.getConfig().getBoolean("place-blocks"));
                    plugin.setInteractions(plugin.getConfig().getBoolean("interactions"));
                    plugin.setChat(plugin.getConfig().getBoolean("chat"));
                    plugin.list = new ArrayList<Boolean>(Arrays.asList(new Boolean[plugin.getowners().size()]));
                    Collections.fill(plugin.list, Boolean.FALSE);
                    PluginManager pm = plugin.getServer().getPluginManager();
                    pm.registerEvents(plugin.attackListener, plugin);
                    pm.registerEvents(plugin.breakPlaceListener, plugin);
                    pm.registerEvents(plugin.chatListener, plugin);
                    pm.registerEvents(plugin.vehicleListener, plugin);
                    pm.registerEvents(plugin.consoleListener, plugin);
                    pm.registerEvents(plugin.interactListener, plugin);
                    pm.registerEvents(plugin.moveListener, plugin);
                    pm.registerEvents(plugin.logoutListener, plugin);
                    pm.registerEvents(plugin.commandListener, plugin);
                    sender.sendMessage(ChatColor.GREEN + "The plugin has been reloaded successfully!");
                } else {
                    sender.sendMessage(ChatColor.RED + "You don't have permission!");
                }
                return false;
            }
        }
        return false;
    }
}
