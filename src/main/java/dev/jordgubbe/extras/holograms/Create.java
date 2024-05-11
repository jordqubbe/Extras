package dev.jordgubbe.extras.holograms;

import dev.jordgubbe.extras.utils.ColorUtils;
import dev.jordgubbe.extras.utils.MessageUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class Create implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage(ColorUtils.format(MessageUtils.NOT_A_PLAYER.print()));
            return true;
        } else {
            if (player.isOp() && command.getName().equalsIgnoreCase("hologramcreate")) {
                if (args.length > 0) {
                    String[] name = String.join(" ", args).split("\\|");
                    HologramUtils hologram = new HologramUtils(name);
                    hologram.spawn(player.getLocation());
                    player.sendMessage(ColorUtils.format("&eSummoned new Armor Stand Hologram"));
                } else {
                    player.sendMessage(ChatColor.RED + "Improper Usage! (/hologramcreate <name>)");
                }
            } else {
                player.sendMessage(ColorUtils.format(MessageUtils.NO_PERMISSION.print()));
            }
        }
        return true;
    }
}
