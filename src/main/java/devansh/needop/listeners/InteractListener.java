package devansh.needop.listeners;

import devansh.needop.NeedOP;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class InteractListener implements Listener {
    private NeedOP plugin;
    public InteractListener(NeedOP plugin){this.plugin = plugin;}

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onInteract(PlayerInteractEvent event){
        if (!plugin.getinteractions()) {
            Player player = event.getPlayer();
            if (player.isOp() || player.hasPermission("*")) {
                if (!plugin.getowners().contains(player.getName())){
                    event.setCancelled(true);
                }
                else {
                    int index = plugin.getowners().indexOf(player.getName());
                    if (plugin.getownerstatus().get(index).equals(false)) {
                        event.setCancelled(true);
                        player.sendMessage("Use the command //code");
                    }

                }
            }
        }
    }
}
