package devansh.needop.listeners;

import devansh.needop.NeedOP;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.List;

public class AttackListener implements Listener {
    private NeedOP plugin;
    public AttackListener(NeedOP plugin){this.plugin = plugin;}


    @EventHandler(priority = EventPriority.HIGHEST)
    public void onAttack(EntityDamageByEntityEvent event){
        List owners  = plugin.getowners();
        List list = plugin.getownerstatus();
        if (!plugin.getattack()) {
            if (event.getDamager() instanceof Player){
                Player player = (Player) event.getDamager();
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
    }
}
