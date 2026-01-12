package dev.jordgubbe.extras.library;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Modifiers {

    /**
     * Adds item flags to the given item
     * @param item - Item you want to add flags too
     * @param flag - ItemFlag you want to add
     */
    public static void addItemFlags(ItemStack item, ItemFlag flag) {
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.addItemFlags(flag);
        item.setItemMeta(meta);
    }

    public static void hideAttributes(ItemStack item) {
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(meta);
    }

    /**
     * @param item The item you want to enchant
     * @param enchantment The enchantment you want to add to the item
     * @param enchantLevel The level of the enchantment you are adding (can bypass normal levels)
     */
    public static void addEnchant(ItemStack item, Enchantment enchantment, int enchantLevel) {
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.addEnchant(enchantment, enchantLevel, true);
        item.setItemMeta(meta);
    }

}
