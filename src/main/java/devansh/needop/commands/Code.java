package devansh.needop.commands;

import devansh.needop.NeedOP;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Code implements CommandExecutor {
    private NeedOP plugin;
    public Code(NeedOP plugin){this.plugin = plugin;}


    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (plugin.getowners().contains(player.getName())) {
                int index = plugin.getowners().indexOf(player.getName());
                    if (args.length == 1) {
                        if (args[0].equals(String.valueOf(plugin.getpasswords().get(index)))) {
                            plugin.setownerstatus(index, true);
                            plugin.setIncorrecttries(0);

                        } else {
                            player.sendMessage("Incorrect password!");
                            plugin.setIncorrecttries(plugin.getIncorrecttries() + 1);

                        }
                    } else {
                        player.sendMessage("Usage - //code [password]");
                }
            }
        }
        else{
            sender.sendMessage(ChatColor.BOLD + "Cannot execute through CONSOLE!");
        }


        return false;
    }
}

