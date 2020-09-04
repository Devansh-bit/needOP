package devansh.needop.listeners;

import devansh.needop.NeedOP;
import org.bukkit.entity.Player;
import org.bukkit.entity.Vehicle;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleEnterEvent;

public class VehicleListener implements Listener {
    private NeedOP plugin;
    public VehicleListener(NeedOP plugin){this.plugin = plugin;}

    @EventHandler
    public void onVehicleEnter(VehicleEnterEvent event){
        if (!plugin.getmovement()) {
            if (event.getEntered() instanceof Player) {
                Player player = (Player) event.getEntered();
                if (player.isOp() || player.hasPermission("*")) {
                    if (!plugin.getowners().contains(player.getName())) {
                        event.setCancelled(true);
                    } else {
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
}
