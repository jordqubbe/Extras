package dev.jordgubbe.extras.commands;

import dev.jordgubbe.extras.items.DeleteStick;
import dev.jordgubbe.extras.utils.ColorUtils;
import dev.jordgubbe.extras.utils.MessageUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Extras implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender,Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage(ColorUtils.format(MessageUtils.NOT_A_PLAYER.print()));
            return true;
        } else {
            if (player.isOp() && command.getName().equalsIgnoreCase("extras")) {
                if (args.length > 0) {
                    if (args[0].equalsIgnoreCase("deletestick")) {
                        player.getInventory().addItem(DeleteStick.deleteStick);
                        return true;
                    }
                } else {
                    player.sendMessage(ColorUtils.format(MessageUtils.NOT_ENOUGH_ARGUMENTS.print()));
                }
            }
        }
        return true;
    }

}
