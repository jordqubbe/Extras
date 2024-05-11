package dev.jordgubbe.extras.holograms;

import dev.jordgubbe.extras.storage.FileUtils;
import dev.jordgubbe.extras.utils.ColorUtils;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.ArmorStand;

import java.util.Objects;
import java.util.UUID;

public class HologramUtils extends FileUtils {

    private final String[] lines;
    public static ArmorStand hologram;
    public static UUID uuid;
    public static String name;
    public static String finalName;

    public HologramUtils(String... lines) {
        this.lines = lines;
    }

    public void spawn(Location location) {
        for (String line : lines) {
            hologram = Objects.requireNonNull(location.getWorld()).spawn(location, ArmorStand.class);
            uuid = UUID.fromString(String.valueOf(hologram.getUniqueId()));

            hologram.setVisible(false);
            hologram.setCustomNameVisible(true);
            hologram.setGravity(false);
            hologram.setInvulnerable(true);
            hologram.setCustomName(ColorUtils.format(line));

            name = line.replace(" ", "_");
            finalName = name;

            if (!get().contains(name)) {
                get().set(name, String.valueOf(uuid));
            }
            save();

            location.subtract(0, 0.26, 0);
        }
    }

    public static String getName() {
        return name;
    }

    public static String getFinalName() {
        return finalName;
    }

    public static UUID getUniqueId() {
        return uuid;
    }

    public static ArmorStand getHologram() {
        return hologram;
    }

    public void initialize() {
        super.setFileAndPluginName("Extras", "hologram.yml");
        super.initialize();
    }

    public FileConfiguration get() {
        return super.get();
    }

    public void save() {
        super.save();
    }

    public void reload() {
        super.reload();
    }

}
