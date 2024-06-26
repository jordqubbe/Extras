package dev.jordgubbe.extras.world;

import dev.jordgubbe.extras.utils.ColorUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Chat implements Listener {

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        event.setCancelled(true);

        if (player.isOp()) {
            Bukkit.broadcastMessage(ColorUtils.format("&c" + player.getDisplayName() + " &r&6» &r" + event.getMessage()));
        } else {
            Bukkit.broadcastMessage(ColorUtils.format("&a" + player.getDisplayName() + " &r&6» &r" + event.getMessage()));
        }
    }

}
