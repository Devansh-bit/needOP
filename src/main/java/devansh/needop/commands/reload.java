package devansh.needop.commands;

import devansh.needop.NeedOP;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;


public class reload implements CommandExecutor {
    private NeedOP plugin;
    public reload(NeedOP plugin){this.plugin = plugin;}

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
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
        return false;
    }
}
