package dev.jordgubbe.extras.storage;

import dev.jordgubbe.extras.Main;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

public class PersistentData {

    public static void addDataToItem(ItemStack item, Plugin plugin, String key, PersistentDataType type, String storedData, Boolean override) {
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        PersistentDataContainer container = meta.getPersistentDataContainer();
        if ((!container.has(new NamespacedKey(plugin, key), type)) && override) {
            container.set(new NamespacedKey(plugin, key), type, storedData);
        }
        item.setItemMeta(meta);
    }

    public static void addDataToEntity(Entity entity, Plugin plugin, String key, PersistentDataType type, String storedData) {
        PersistentDataContainer data = entity.getPersistentDataContainer();
        data.set(new NamespacedKey(plugin, key), type, storedData);
    }

}
