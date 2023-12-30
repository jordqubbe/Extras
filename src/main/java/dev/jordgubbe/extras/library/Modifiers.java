package dev.jordgubbe.extras.library;

import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.UUID;

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

    /**
     * Adds an attribute modifier to the given item
     * @param item - Item that is getting the modifier
     * @param attribute - Given
     * @param name - Name of the item's attribute
     * @param level - The value of the bonus on the modifier
     * @param operation - Scale or add
     * @param slot - Which slot gives the bonus
     */
    public static void addAttributeModifier(ItemStack item, Attribute attribute, String name, int level, AttributeModifier.Operation operation, EquipmentSlot slot) {
        AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), name, level, operation, slot);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.addAttributeModifier(attribute, modifier);
        item.setItemMeta(meta);
    }

}
