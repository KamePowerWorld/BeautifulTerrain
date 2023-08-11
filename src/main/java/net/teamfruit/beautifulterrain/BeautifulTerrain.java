package net.teamfruit.beautifulterrain;

import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class BeautifulTerrain extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onBreak(BlockBreakEvent ev) {
        Block block = ev.getBlock();
        ev.setCancelled(!block.equals(block.getWorld().getHighestBlockAt(block.getLocation())));
    }
}
