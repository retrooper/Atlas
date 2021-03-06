package cc.funkemunky.api.listeners;

import cc.funkemunky.api.Atlas;
import cc.funkemunky.api.utils.MiscUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginDisableEvent;

//@Init
public class PluginShutdownListeners implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onEvent(PluginDisableEvent event) {
        if(event.getPlugin().getDescription().getDepend().contains("Atlas")) {
            MiscUtils.printToConsole("&c" + event.getPlugin().getName() + " &7is being shutdown. Removing its hooks and listeners...");
            Atlas.getInstance().getEventManager().unregisterAll(event.getPlugin());
            Atlas.getInstance().getSchedular().shutdownNow();
            Atlas.getInstance().getFunkeCommandManager().removeAll(event.getPlugin());
            MiscUtils.printToConsole("&aCompleted!");
        }
    }
}
