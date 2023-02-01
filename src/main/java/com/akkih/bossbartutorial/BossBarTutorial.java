package com.akkih.bossbartutorial;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class BossBarTutorial extends JavaPlugin implements CommandExecutor {

    @Override
    public void onEnable() {
        getCommand("bossbar").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;

        Player player = (Player) sender;
        new BossBarRunnable(player, 10).runTaskTimer(this, 0, 2);
        // Run this code above with 0 delay between 2 ticks

        return true;
    }

}
