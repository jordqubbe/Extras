package dev.jordgubbe.extras.utils;

import dev.jordgubbe.extras.Main;
import org.bukkit.Bukkit;

public enum Console {

    NOT_A_PLAYER("&cYou must be a player to use this command!"),
    NO_PERMISSION("&cYou do not have permission to use this command!"),
    INVALID_ARGUMENTS("&cInvalid arguments!"),
    NOT_ENOUGH_ARGUMENTS("&cNot enough arguments!"),
    INVALID_COMMAND("&cInvalid command!"),
    INVALID_PLAYER("&cThat player does not exist!"),
    CONFIGURATION_ISSUE("&cThere was an issue with the configuration file!"),
    INVALID("&cInvalid!");

    private final String warningType;

    Console(String warningType) {
        this.warningType = warningType;
    }

    public String print() {
        return warningType;
    }

    public static void sendToConsole(String message) {
        Bukkit.getServer().getConsoleSender().sendMessage(message);
    }

}
