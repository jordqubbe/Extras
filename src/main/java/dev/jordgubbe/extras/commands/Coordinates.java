package dev.jordgubbe.extras.commands;

import dev.jordgubbe.extras.utils.ColorUtils;
import dev.jordgubbe.extras.utils.MessageUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Coordinates implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String s, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage(ColorUtils.format(MessageUtils.NOT_A_PLAYER.print()));
            return true;
        } else {
            if (cmd.getName().equalsIgnoreCase("coordinates")) {
                final int x = (int) player.getLocation().getX();
                final int y = (int) player.getLocation().getY();
                final int z = (int) player.getLocation().getZ();
                player.chat("X: " + x + " Y: " + y + " Z: " + z);
            }
        }
        return true;
    }

}
