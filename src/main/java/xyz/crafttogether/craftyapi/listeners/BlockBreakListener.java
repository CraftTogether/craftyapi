package xyz.crafttogether.craftyapi.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import xyz.crafttogether.craftyapi.data.DataHandler;

public class BlockBreakListener implements Listener {
    @EventHandler(priority = EventPriority.LOWEST)
    public void onBlockBreak(BlockBreakEvent event) {
        DataHandler.addGlobalBlockBroken();
    }
}
