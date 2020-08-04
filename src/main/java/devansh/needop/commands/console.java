package devansh.needop.commands;

import devansh.needop.NeedOP;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class console implements CommandExecutor {
    private NeedOP plugin;
    public console(NeedOP plugin){this.plugin = plugin;}

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            int index = plugin.getowners().indexOf(player.getName());
            if(plugin.getowners().contains(player.getName())){
                if (player.isOp()){
                    if(args.length == 1 && !args[0].equals(null)){
                        if (args[0].equals(plugin.getpasswords().get(index))){
                            if(plugin.getConsolestatus()){
                                player.sendMessage("The console has been turned" + ChatColor.RED + "" + ChatColor.BOLD + "OFF");
                                plugin.setConsolestatus(false);
                            }
                            else{
                                player.sendMessage("The console has been turned" + ChatColor.RED + "" + ChatColor.BOLD + "ON");
                                plugin.setConsolestatus(true);
                            }
                        }
                        else{
                            player.sendMessage("The password was incorrect!");
                        }
                    }
                }

            }
            else {
                player.sendMessage("Unknown command. Type \"/help\" for help");
            }
        }
        else {
            sender.sendMessage(ChatColor.BOLD + "Cannot execute through CONSOLE!");
        }
        return false;
    }
}
