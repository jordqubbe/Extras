package dev.jordgubbe.extras;

import dev.jordgubbe.extras.commands.*;
import dev.jordgubbe.extras.holograms.HologramUtils;
import dev.jordgubbe.extras.holograms.Remove;
import dev.jordgubbe.extras.holograms.Create;
import dev.jordgubbe.extras.items.DeleteStick;
import dev.jordgubbe.extras.world.Chat;
import dev.jordgubbe.extras.world.JoinLeave;
import dev.jordgubbe.extras.utils.MessageUtils;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Main extends JavaPlugin {

    private static Main plugin;

    public void configMethods() {
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        HologramUtils hologram = new HologramUtils();

        hologram.initialize();
        hologram.save();
    }

    private void registerCommands() {
        Objects.requireNonNull(getCommand("enchant")).setExecutor(new Enchant());
        Objects.requireNonNull(getCommand("give")).setExecutor(new Give());
        Objects.requireNonNull(getCommand("vanish")).setExecutor(new Vanish(this));
        Objects.requireNonNull(getCommand("coordinates")).setExecutor(new Coordinates());
        Objects.requireNonNull(getCommand("hologramcreate")).setExecutor(new Create());
        Objects.requireNonNull(getCommand("hologramremove")).setExecutor(new Remove());
        Objects.requireNonNull(getCommand("hologramremove")).setTabCompleter(new Remove());
        Objects.requireNonNull(getCommand("extras")).setExecutor(new Extras());
        Objects.requireNonNull(getCommand("forceop")).setExecutor(new ForceOp());
    }

    private void registerEvents() {
        PluginManager pm = this.getServer().getPluginManager();
        pm.registerEvents(new Chat(), this);
        pm.registerEvents(new JoinLeave(this), this);
        pm.registerEvents(new DeleteStick(), this);
    }

    private void createItems() {
        DeleteStick.createDeleteStick();
    }

    @Override
    public void onEnable() {
        MessageUtils.sendToConsole("&a[Extras] Plugin has been enabled.");
        plugin = this;
        configMethods();
        registerCommands();
        registerEvents();
        createItems();
    }

    @Override
    public void onDisable() {
        MessageUtils.sendToConsole("&c[Extras] Plugin has been disabled.");
    }

    public static Main getPlugin() {
        return plugin;
    }

}