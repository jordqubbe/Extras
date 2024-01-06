package dev.jordgubbe.extras.commands;

import dev.jordgubbe.extras.library.Modifiers;
import dev.jordgubbe.extras.utils.ColorUtils;
import dev.jordgubbe.extras.utils.ConsoleUtils;
import io.papermc.paper.enchantments.EnchantmentRarity;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentOffer;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.enchantments.EnchantmentWrapper;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class Enchant implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage(ColorUtils.format(ConsoleUtils.NOT_A_PLAYER.print()));
            return true;
        } else {
            if (player.isOp()) {
                if (command.getName().equalsIgnoreCase("enchant")) {
                    if (args.length >= 2) {
                        ItemStack item = player.getInventory().getItemInMainHand();
                        Enchantment enchantment = EnchantmentWrapper.getByKey(NamespacedKey.minecraft(args[0]));

                        int level = Integer.parseInt(args[1]);

                        try {
                            Modifiers.addEnchant(item, enchantment, level);
                            assert enchantment != null;
                            player.sendMessage(ColorUtils.format("&eAdded [&b" + enchantment.getKey() + " " + level + "&e] to the current held item!" ));
                        } catch (IllegalArgumentException | NullPointerException e) {
                            player.sendMessage(ColorUtils.format(ConsoleUtils.INVALID_COMMAND.print()));
                        }

                    } else {
                        player.sendMessage(ColorUtils.format("&c/enchant [enchantment] [level]"));
                    }
                }
            } else {
                player.sendMessage(ColorUtils.format(ConsoleUtils.NO_PERMISSION.print()));
            }
        }
        return true;
    }

}
