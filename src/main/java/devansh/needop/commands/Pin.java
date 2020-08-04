package devansh.needop.commands;

import devansh.needop.NeedOP;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Pin implements CommandExecutor {
    private NeedOP plugin;
    public Pin(NeedOP plugin){this.plugin = plugin;}

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (plugin.getIncorrectconsolepass() < 3) {
            if (args.length == 1 && args[0] != null) {
                if (!(sender instanceof Player)) {
                    if (plugin.getconsolepass().equals(args[0])) {
                        plugin.setIncorrectconsolepass(0);
                        if (plugin.getConsolestatus() == true) {
                            plugin.setConsolestatus(false);
                            sender.sendMessage("Console has been turned OFF");
                        } else {
                            plugin.setConsolestatus(true);
                            sender.sendMessage("Console has been turned ON");
                        }
                    } else {
                        sender.sendMessage("The Password was incorrect!");
                        plugin.setIncorrectconsolepass(plugin.getIncorrectconsolepass() + 1);
                    }
                }
            }

        }
        else {
            sender.sendMessage("The console has been LOCKED! Refer config.yml");
            plugin.setConsolestatus(false);
        }
        return false;
    }
}
