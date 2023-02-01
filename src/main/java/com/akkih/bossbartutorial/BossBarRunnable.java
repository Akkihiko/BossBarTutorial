package com.akkih.bossbartutorial;

import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class BossBarRunnable extends BukkitRunnable {

    private final BossBar bossBar;
    private int milliseconds;
    private int seconds;

    public BossBarRunnable(Player player, int seconds) {
        this.seconds = seconds - 1;
        this.milliseconds = 9;
        this.bossBar = Bukkit.createBossBar(
                this.seconds + "." + this.milliseconds,
                BarColor.BLUE,
                BarStyle.SEGMENTED_20
        );

        bossBar.addPlayer(player);
    }

    @Override
    public void run() {
        // Everytime the code is run, it'll decrease 1 from the milliseconds
        milliseconds--;

        // Check if it needs to decrease second (4.0 -> 3.9)
        if (this.milliseconds <= -1) {
            this.milliseconds = 9;
            this.seconds--;
        }

        // Updating bar progress and title (bar progress not smooth)
        if (!(this.seconds <= -1)) {
            bossBar.setProgress(seconds / 10D);
            bossBar.setTitle(this.seconds + "." + this.milliseconds);
        }

        // Checks if the countdown is over and cancels
        if (this.seconds == 0 && this.milliseconds == 0) {
            bossBar.setTitle(" ");
            bossBar.removeAll();
            cancel();
        }
    }

}
