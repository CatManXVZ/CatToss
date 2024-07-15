package cattoss.catmanxvz.cattoss.handlers;

import cattoss.catmanxvz.cattoss.CatToss;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import cattoss.catmanxvz.cattoss.handlers.PlayerHandler;

public class WoolHandler implements Listener {
    public WoolHandler(CatToss plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin );
    }

    @EventHandler
    public void onWoolPlace(BlockPlaceEvent event){
        Block block = event.getBlock();
        if(CatToss.Plugin_Activated == false) {
            if (block.getType() != Material.WHITE_WOOL) {
                return;
            }

            Bukkit.getLogger().info("The plugin has been activated");
            CatToss.Plugin_Activated = true;
            PlayerHandler.bossBar.hide();
            Bukkit.getServer().broadcastMessage("May the cats be tossed. Use /Cstick to get the Cat Stick");
            for(Player p : Bukkit.getOnlinePlayers()){
                p.playSound(p.getLocation(), Sound.ENTITY_CAT_PURREOW, 1, 0);
            }
        }

    }

}
