package dev.jordgubbe.extras.commands;

import dev.jordgubbe.extras.utils.Color;
import dev.jordgubbe.extras.utils.Console;
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
            sender.sendMessage(Color.format(Console.NOT_A_PLAYER.print()));
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
                                player.sendMessage(Color.format("&eAdded: &a" + amount + " " + args[0].toUpperCase().replace("_", " ")));
                            } else {
                                player.sendMessage(Color.format("&eAdded: &a" + amount + " " + args[0].toUpperCase().replace("_", " ") + "S"));
                            }
                        } catch (IllegalArgumentException exception) {
                            player.sendMessage(Color.format("&cThat is not a valid material!"));
                        }
                    } else {
                        player.sendMessage(Color.format("&c/material|item [material type] [amount]"));
                    }
                }
            } else {
                player.sendMessage(Color.format(Console.NO_PERMISSION.print()));
            }
        }
        return true;
    }

}
