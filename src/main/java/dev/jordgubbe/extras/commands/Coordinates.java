package dev.jordgubbe.extras.commands;

import dev.jordgubbe.extras.utils.Color;
import dev.jordgubbe.extras.utils.Console;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Coordinates implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage(Color.format(Console.NOT_A_PLAYER.print()));
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
