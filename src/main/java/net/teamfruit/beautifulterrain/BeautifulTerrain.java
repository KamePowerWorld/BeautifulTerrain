package net.teamfruit.beautifulterrain;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public final class BeautifulTerrain extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onBreak(BlockBreakEvent ev){
        Block block = ev.getBlock();
        Player player = ev.getPlayer();
        Location location = block.getLocation();
        int y = location.getBlockY();
        for(;y < 10 ; y++){
            if(block.getWorld().getBlockAt(location.getBlockX(),y,location.getBlockZ()).getType() == Material.AIR) ev.setCancelled(true);
        }
        String msg = "明るさ:"+block.getLightLevel();
        player.sendMessage(msg);
    }
}
