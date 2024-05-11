package dev.jordgubbe.extras.items;

import dev.jordgubbe.extras.Main;
import dev.jordgubbe.extras.library.Item;
import dev.jordgubbe.extras.utils.ColorUtils;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class DeleteStick implements Listener {

    public static ItemStack deleteStick;

    public static void createDeleteStick() {
        List<String> lore = new ArrayList<>();
        lore.add(ColorUtils.translate("&7With this stick... Everything is gone..."));
        lore.add(" ");
        lore.add(ColorUtils.translate("&6&lRIGHT-CLICK &7a mob to delete them."));
        lore.add(ColorUtils.translate("&6&lLEFT-CLICK &7a block to delete it."));
        lore.add(" ");
        deleteStick = Item.createItem("&6Delete Stick", Material.BLAZE_ROD, 1, lore);
    }

    @EventHandler
    public void onClickWithStick(PlayerInteractAtEntityEvent event) {
        Player player = event.getPlayer();
        Entity entity = event.getRightClicked();
        if (player.isOp() && player.getInventory().getItemInMainHand().equals(deleteStick)) {
            entity.remove();
            if (entity instanceof Player kick) {
                kick.kickPlayer("Lol");
            } else {
                if (entity.getCustomName() != null) {
                    player.sendMessage(ColorUtils.format("&cRemoved &r" + entity.getCustomName()));
                } else {
                    player.sendMessage(ColorUtils.format("&cRemoved " + entity.getName()));
                }
            }
        }
    }

    @EventHandler
    public void onClickWithStickTwo(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Block block = event.getClickedBlock();
        if (player.isOp() && player.getInventory().getItemInMainHand().equals(deleteStick) && event.getAction().equals(Action.LEFT_CLICK_BLOCK) && block != null) {
            block.getDrops().clear();
            block.breakNaturally();
        }
    }

}
