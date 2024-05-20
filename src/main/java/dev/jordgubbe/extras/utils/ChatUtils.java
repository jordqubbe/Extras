package dev.jordgubbe.extras.utils;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;

public class ChatUtils {

    public static void sendActionBar(Player player, String message) {
        TextComponent finalMessage = new TextComponent(ColorUtils.format(message));
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, finalMessage);
    }

}
