package cattoss.catmanxvz.cattoss.handlers;

import cattoss.catmanxvz.cattoss.CatToss;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.Bukkit;
import org.bukkit.boss.BossBar;
import org.bukkit.event.Listener;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerItemHeldEvent;


public class PlayerHandler implements Listener{

    public static BossBar bossBar = Bukkit.createBossBar("Get White Wool and Place it", BarColor.BLUE, BarStyle.SOLID);

    public PlayerHandler(CatToss plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin );
    }
    @EventHandler
    public void onPlayerItemHeldEvent(PlayerItemHeldEvent e){
        Player p = e.getPlayer();

        if(p.getItemInHand().getType() == Material.WHITE_WOOL)
            if(CatToss.Plugin_Activated == false){
                Bukkit.broadcastMessage(p.getName() + " has gained white wool, place it down!");
                PlayerHandler.bossBar.setTitle("Start Tossing?");
                PlayerHandler.bossBar.setColor(BarColor.PINK);
                Bukkit.getLogger().info("Wool has been held");
            }
        }
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Bukkit.getLogger().info("player joined");
        Player p = e.getPlayer();
        bossBar.addPlayer(p);
        Bukkit.broadcastMessage("Hello " + p.getName() + "!");

    }
    }




