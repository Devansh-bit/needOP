package devansh.needop.listeners;

import devansh.needop.NeedOP;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class MoveListener implements Listener {
    private NeedOP plugin;
    public MoveListener(NeedOP plugin){this.plugin = plugin;}


    @EventHandler(priority = EventPriority.HIGHEST)
    public void onMove(PlayerMoveEvent event) {
        if (!plugin.getmovement()) {
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
