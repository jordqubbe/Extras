package dev.jordgubbe.extras;

import dev.jordgubbe.extras.commands.*;
import dev.jordgubbe.extras.holograms.Spawn;
import dev.jordgubbe.extras.world.Chat;
import dev.jordgubbe.extras.world.JoinLeave;
import dev.jordgubbe.extras.utils.ConsoleUtils;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
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
        Objects.requireNonNull(getCommand("vanish")).setExecutor(new Vanish(this));
        Objects.requireNonNull(getCommand("coordinates")).setExecutor(new Coordinates());
        Objects.requireNonNull(getCommand("hologram")).setExecutor(new Spawn());
        Objects.requireNonNull(getCommand("reload")).setExecutor(new Reload(this));
    }

    private void registerEvents() {
        PluginManager pm = this.getServer().getPluginManager();
        pm.registerEvents(new Chat(), this);
        pm.registerEvents(new JoinLeave(this), this);
    }

    @Override
    public void onEnable() {
        ConsoleUtils.sendToConsole("&a[Extras] Plugin has been enabled.");
        configMethods();
        registerCommands();
        registerEvents();
    }

    @Override
    public void onDisable() {
        ConsoleUtils.sendToConsole("&c[Extras] Plugin has been disabled.");
    }
}
