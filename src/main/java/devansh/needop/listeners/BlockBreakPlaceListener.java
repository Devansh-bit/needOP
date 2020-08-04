package devansh.needop.listeners;

import devansh.needop.NeedOP;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.List;

public class BlockBreakPlaceListener implements Listener {

    private NeedOP plugin;
    public BlockBreakPlaceListener(NeedOP plugin){this.plugin = plugin;}


    @EventHandler(priority = EventPriority.HIGHEST)
    public void blockBreak(BlockBreakEvent event){
        List owners = plugin.getowners();
        List list = plugin.getownerstatus();
        if (!plugin.getbreakblocks()) {
            Player player = (Player) event.getPlayer();
            if (player.isOp()) {
                if (!owners.contains(player.getName())){
                    event.setCancelled(true);
                }
                else {
                    int index = owners.indexOf(player.getName());
                    if (list.get(index).equals(false)) {
                        event.setCancelled(true);
                        player.sendMessage("Use the command //code");
                    }

                }
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void blockPlace(BlockPlaceEvent event){

        Player player = event.getPlayer();
        if (player.isOp()) {
            if (!plugin.getowners().contains(player.getName())){
                if (plugin.getplacelocks() == false) {
                    event.setCancelled(true);
                }
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
