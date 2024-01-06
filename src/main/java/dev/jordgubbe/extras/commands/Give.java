package dev.jordgubbe.extras.commands;

import dev.jordgubbe.extras.utils.ColorUtils;
import dev.jordgubbe.extras.utils.ConsoleUtils;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Give implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage(ColorUtils.format(ConsoleUtils.NOT_A_PLAYER.print()));
            return true;
        } else {
            if (player.isOp()) {
                if (command.getName().equalsIgnoreCase("give")) {
                    if (args.length >= 2) {
                        try {
                            Material material = Material.valueOf(args[0].toUpperCase());
                            int amount = Integer.parseInt(args[1]);
                            for (int i = 0; i < amount; i++) {
                                player.getInventory().addItem(new ItemStack(material));
                            }
                            if (amount == 1) {
                                player.sendMessage(ColorUtils.format("&eAdded: &a" + amount + " " + args[0].toUpperCase().replace("_", " ")));
                            } else {
                                player.sendMessage(ColorUtils.format("&eAdded: &a" + amount + " " + args[0].toUpperCase().replace("_", " ") + "S"));
                            }
                        } catch (IllegalArgumentException exception) {
                            player.sendMessage(ColorUtils.format("&cThat is not a valid material!"));
                        }
                    } else {
                        player.sendMessage(ColorUtils.format("&c/material|item [material type] [amount]"));
                    }
                }
            } else {
                player.sendMessage(ColorUtils.format(ConsoleUtils.NO_PERMISSION.print()));
            }
        }
        return true;
    }

}
