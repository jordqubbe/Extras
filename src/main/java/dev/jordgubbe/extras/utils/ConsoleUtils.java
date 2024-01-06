package dev.jordgubbe.extras.utils;

import org.bukkit.Bukkit;

public enum ConsoleUtils {

    NOT_A_PLAYER("&cYou must be a player to use this command!"),
    NO_PERMISSION("&cYou do not have permission to use this command!"),
    INVALID_ARGUMENTS("&cInvalid arguments!"),
    NOT_ENOUGH_ARGUMENTS("&cNot enough arguments!"),
    INVALID_COMMAND("&cInvalid command!"),
    INVALID_PLAYER("&cThat player does not exist!"),
    CONFIGURATION_ISSUE("&cThere was an issue with the configuration file!");

    private final String warningType;

    ConsoleUtils(String warningType) {
        this.warningType = warningType;
    }

    public String print() {
        return warningType;
    }

    public static String notAPlayer() {
        return ColorUtils.format(NOT_A_PLAYER.warningType);
    }

    public static void sendToConsole(String message) {
        Bukkit.getServer().getConsoleSender().sendMessage(message);
    }

}
