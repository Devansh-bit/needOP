package devansh.needop.listeners;

import devansh.needop.NeedOP;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {
    private NeedOP plugin;
    public ChatListener(NeedOP plugin){this.plugin = plugin;}

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onChat(AsyncPlayerChatEvent event){
        if (!plugin.getchat()) {
            Player player = event.getPlayer();
            if (player.isOp() || player.hasPermission("*")) {
                if (!plugin.getowners().contains(player.getName())){
                    event.setCancelled(true);
                }
                else {
                    int index = plugin.getowners().indexOf(player.getName());
                    if (plugin.getowners().get(index).equals(false)) {
                        event.setCancelled(true);
                        player.sendMessage("Use the command //code");
                    }

                }
            }
        }
    }
}
