package dev.jordgubbe.extras;

import dev.jordgubbe.extras.commands.Coordinates;
import dev.jordgubbe.extras.commands.Enchant;
import dev.jordgubbe.extras.commands.Give;
import dev.jordgubbe.extras.commands.Vanish;
import dev.jordgubbe.extras.logistics.Chat;
import dev.jordgubbe.extras.logistics.JoinLeave;
import dev.jordgubbe.extras.utils.Console;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Main extends JavaPlugin {

    public void configMethods() {
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
    }

    private void registerCommands() {
        Objects.requireNonNull(getCommand("enchant")).setExecutor(new Enchant());
        Objects.requireNonNull(getCommand("give")).setExecutor(new Give());
        Objects.requireNonNull(getCommand("vanish")).setExecutor(new Vanish());
        Objects.requireNonNull(getCommand("coordinates")).setExecutor(new Coordinates());
    }

    private void registerEvents() {
        PluginManager pm = this.getServer().getPluginManager();
        pm.registerEvents(new Chat(), this);
        pm.registerEvents(new JoinLeave(this), this);
    }

    @Override
    public void onEnable() {
        Console.sendToConsole("&a[BasicsRevamped] Plugin has been enabled.");
        configMethods();
        registerCommands();
        registerEvents();
    }

    @Override
    public void onDisable() {
        Console.sendToConsole("&c[BasicsRevamped] Plugin has been disabled.");
    }
}
