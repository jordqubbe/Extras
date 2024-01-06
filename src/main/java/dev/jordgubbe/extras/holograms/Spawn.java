package dev.jordgubbe.extras.holograms;

import dev.jordgubbe.extras.utils.ColorUtils;
import dev.jordgubbe.extras.utils.ConsoleUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class Spawn implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ColorUtils.format(ConsoleUtils.NOT_A_PLAYER.print()));
            return true;
        } else {
            Player player = (Player) sender;
            if (player.isOp()) {
                if (command.getName().equalsIgnoreCase("hologram")) {
                    if (args.length > 0) {
                        ArmorStand hologram = (ArmorStand) player.getWorld().spawnEntity(player.getLocation(), EntityType.ARMOR_STAND);

                        hologram.setVisible(false);
                        hologram.setCustomNameVisible(true);
                        hologram.setGravity(false);
                        hologram.setInvulnerable(true);
                        hologram.setCustomName(ColorUtils.format(args[0].replace("_", " ")));

                        player.sendMessage(ChatColor.YELLOW + "Summoned new Armor Stand Hologram");
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&eName: &r" + args[3].replace("_", " ")));
                    } else {
                        player.sendMessage(ChatColor.RED + "Improper Usage! (/hologram <name>)");
                    }
                }
            } else {
                player.sendMessage(ColorUtils.format(ConsoleUtils.NO_PERMISSION.print()));
            }
        }
        return true;
    }

}
