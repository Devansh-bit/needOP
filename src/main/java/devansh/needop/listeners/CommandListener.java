package devansh.needop.listeners;

import devansh.needop.NeedOP;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandListener implements Listener {
    private NeedOP plugin;
    public CommandListener(NeedOP plugin){this.plugin = plugin;}

    @EventHandler
    public void oncmd(PlayerCommandPreprocessEvent event){
        if (!event.getMessage().contains("//console") && !event.getMessage().contains("//code")) {
            Player p = event.getPlayer();

            if (p.isOp() || p.hasPermission("*")) {

                if (!plugin.getowners().contains(p.getName())) {
                    if (plugin.getLicense() || !plugin.getServerStatus()) {
                        event.setCancelled(true);
                        p.sendMessage("Unknown Command. Type \"/help\" for help");
                        return;
                    }
                    else return;

                }
                else {
                    int index = plugin.getowners().indexOf(p.getName());
                    if (plugin.getownerstatus().get(index).equals(false)) {
                        event.setCancelled(true);
                        p.sendMessage("Use the command //code");
                    }

                }

            }
            else {
                return;

            }
        }
    }
}
