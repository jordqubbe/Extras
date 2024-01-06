package dev.jordgubbe.extras.commands;

import dev.jordgubbe.extras.Main;
import dev.jordgubbe.extras.utils.ColorUtils;
import dev.jordgubbe.extras.utils.ConsoleUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.UUID;

public class Vanish implements CommandExecutor {

    private final ArrayList<UUID> vanished = new ArrayList<>();
    private final Main plugin;

    public Vanish(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage(ColorUtils.format(ConsoleUtils.NOT_A_PLAYER.print()));
            return true;
        } else {
            if (player.isOp()) {
                if (command.getName().equalsIgnoreCase("vanish")) {
                    if (vanished.contains(player.getUniqueId())) {
                        for (Player vanish : Bukkit.getOnlinePlayers()) {
                            vanish.showPlayer(plugin, player);
                            player.sendMessage(ColorUtils.format("&aNow visible to others!"));
                            vanished.remove(player.getUniqueId());
                        }
                    } else {
                        for (Player vanish : Bukkit.getOnlinePlayers()) {
                            vanish.hidePlayer(plugin, player);
                            player.sendMessage(ColorUtils.format("&cNow invisible to others!"));
                            vanished.add(player.getUniqueId());
                        }
                    }
                }
            } else {
                player.sendMessage(ColorUtils.format(ConsoleUtils.NO_PERMISSION.print()));
            }
        }
        return true;
    }

}
