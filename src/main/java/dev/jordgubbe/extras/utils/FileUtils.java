package dev.jordgubbe.extras.utils;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class FileUtils {

    String pluginName;
    String fileName;
    File file;
    FileConfiguration config;

    public void initialize(String pluginName, String fileName) {
        this.pluginName = pluginName;
        this.fileName = fileName;
        file = new java.io.File(Objects.requireNonNull(Bukkit.getServer().getPluginManager().getPlugin(pluginName)).getDataFolder(), fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                Bukkit.getServer().getConsoleSender().sendMessage(ConsoleUtils.CONFIGURATION_ISSUE.print());
            }
        }
        config = YamlConfiguration.loadConfiguration(file);
    }

    public FileConfiguration get() {
        if (config == null) {
            reload();
        }
        return config;
    }

    public void save() {
        try {
            config.save(file);
        } catch (IOException e) {
            Bukkit.getServer().getConsoleSender().sendMessage(ConsoleUtils.CONFIGURATION_ISSUE.print());
        }
    }

    public void reload() {
        if (config == null) {
            this.initialize(pluginName, fileName);
        }
        config = YamlConfiguration.loadConfiguration(file);
    }

}
