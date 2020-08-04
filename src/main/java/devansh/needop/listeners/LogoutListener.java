package devansh.needop.listeners;

import devansh.needop.NeedOP;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LogoutListener implements Listener {
    private NeedOP plugin;
    public LogoutListener(NeedOP plugin){this.plugin = plugin;}

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onQuit(PlayerQuitEvent event){
        Player player = event.getPlayer();
        if (plugin.getowners().contains(player.getName())){
            int index = plugin.getowners().indexOf(player.getName());
            plugin.setownerstatus(index, false);
        }
    }
}
