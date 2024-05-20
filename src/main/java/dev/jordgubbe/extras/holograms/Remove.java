package dev.jordgubbe.extras.holograms;

import dev.jordgubbe.extras.utils.ColorUtils;
import dev.jordgubbe.extras.utils.MessageUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.*;

public class Remove implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage(MessageUtils.notAPlayer());
            return true;
        } else {
            if (player.isOp() && command.getName().equalsIgnoreCase("hologramremove")) {
                if (args.length > 0) {
                    if (args[0].equalsIgnoreCase(HologramUtils.getFinalName())) {
                        HologramUtils hologram = new HologramUtils();
                        HologramUtils.getHologram().remove();
                        hologram.get().set(HologramUtils.getName(), null);
                        hologram.save();
                        player.sendMessage(ColorUtils.format("&eDeleted the specified Armor Stand Hologram"));
                    }
                } else {
                    player.sendMessage(MessageUtils.NOT_ENOUGH_ARGUMENTS.print());
                }
            } else {
                player.sendMessage(MessageUtils.NO_PERMISSION.print());
            }
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (args.length > 0) {
            HologramUtils hologram = new HologramUtils();
            return new ArrayList<>(hologram.get().getKeys(true));
        }
        return null;
    }

}
