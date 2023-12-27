package dev.jordgubbe.extras.utils;

import dev.jordgubbe.extras.Main;
import org.bukkit.Bukkit;

public class Console {

    private static final Main plugin = new Main();

    public static void sendToConsole(String message) {
        plugin.getServer().getConsoleSender().sendMessage(Color.format(message));
    }

}
