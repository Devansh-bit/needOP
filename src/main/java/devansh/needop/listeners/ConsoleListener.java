package devansh.needop.listeners;

import devansh.needop.NeedOP;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerCommandEvent;

public class ConsoleListener implements Listener {
    private NeedOP plugin;
    public ConsoleListener(NeedOP plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onServerCommand(ServerCommandEvent e) {
        if(e.getCommand() != null) {
            if (plugin.getConsolestatus() == false) {
                if (!e.getCommand().contains("pin")) {

                    e.setCancelled(true);
                    e.getSender().sendMessage("Unknown Command. Type \"/help\" for help");
                    return;
                }
            }
            else {
                return;
            }
        }
    }
}
