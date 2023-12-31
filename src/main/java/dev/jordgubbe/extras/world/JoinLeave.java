package dev.jordgubbe.extras.world;

import dev.jordgubbe.extras.Main;
import dev.jordgubbe.extras.utils.ColorUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinLeave implements Listener {

    private final Main plugin;

    public JoinLeave(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        event.setJoinMessage(ColorUtils.format("&a" + player.getName() + " &ejoined the server!"));
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        event.setQuitMessage(ColorUtils.format("&a" + player.getName() + " &eleft the server!"));
    }

}
