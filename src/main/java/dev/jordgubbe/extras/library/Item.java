package dev.jordgubbe.extras.library;

import dev.jordgubbe.extras.utils.ColorUtils;
import dev.jordgubbe.extras.utils.SkullCreator;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.List;

public class Item {

    /**
     * Creates a new ItemStack
     * @param name - Name of the new item
     * @param mat - Material of the new item (Don't use skulls with textures here)
     * @param amount - Amount of the new item
     * @param lore - Lore (if any) of the new item
     * @return - The newly created ItemStack
     */
    public static ItemStack createItem(String name, Material mat, int amount, List<String> lore) {
        ItemStack item = new ItemStack(mat, amount);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName(ColorUtils.format(name));
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    /**
     * Creates a Skull ItemStack that can get a texture from minecraft-heads.com
     * @param name Name of the skull item
     * @param lore lore (if any) of said skull item
     * @param url Provide a URL in the form of a Mojang texture
     * @return The newly created Skull ItemStack
     */
    public static ItemStack createSkull(String name, List<String> lore, String url) {
        String prefix = "http://textures.minecraft.net/texture/";
        ItemStack item = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) item.getItemMeta();
        assert meta != null;
        meta.setDisplayName(ColorUtils.format(name));
        meta.setLore(lore);
        item.setItemMeta(meta);
        return SkullCreator.itemWithUrl(item, prefix + url);
    }

    /**
     * Set lore of an item
     * @param item - Item you want to set the lore too
     * @param lore - Lore you want to add to an item
     */
    public static void setLore(ItemStack item, List<String> lore) {
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setLore(lore);
        item.setItemMeta(meta);
    }

    /**
     * Set's the given line of an Item's lore
     * @param item - Which item's lore you would like to change
     * @param whichLine - Which line the lore is on
     * @param lineText - What the new lore is
     */
    public static void setLoreLine(ItemStack item, int whichLine, String lineText) {
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        List<String> lore = meta.getLore();
        lore.set(whichLine, lineText);
        meta.setLore(lore);
        item.setItemMeta(meta);
    }

    /**
     * Slightly faster way to add a new recipe
     * @param item - Item you want to add the recipe to
     * @param key - NamespacedKey#minecraft()
     * @return - The recipe
     */
    public static ShapedRecipe addRecipe(ItemStack item, String key, String top, String middle, String bottom) {
        ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft(key), item);
        recipe.shape(top, middle, bottom);
        return recipe;
    }

}
