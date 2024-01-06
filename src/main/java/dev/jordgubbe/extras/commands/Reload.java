package dev.jordgubbe.extras.commands;

import dev.jordgubbe.extras.Main;
import dev.jordgubbe.extras.utils.ColorUtils;
import dev.jordgubbe.extras.utils.ConsoleUtils;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

public class Reload implements CommandExecutor {

    private final Main plugin;

    public Reload(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (((sender instanceof Player player && player.isOp()) || sender instanceof Server) && command.getName().equalsIgnoreCase("reload")) {
            if (args.length >= 0) {
                long time = Long.parseLong(args[0]);
                Bukkit.broadcastMessage(ColorUtils.format("&cServer will reload in " + args[0] + " seconds."));
                Bukkit.getScheduler().runTaskLater(plugin, new BukkitRunnable() {
                    @Override
                    public void run() {
                        Bukkit.getServer().reload();
                    }
                }, 20*time);
                Bukkit.broadcastMessage(ColorUtils.format("&aServer has been reloaded!"));
                return true;
            }
        }
        return true;
    }

}
