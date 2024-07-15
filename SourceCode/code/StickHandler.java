package cattoss.catmanxvz.cattoss.handlers;

import cattoss.catmanxvz.cattoss.CatToss;
import org.bukkit.*;

import org.bukkit.entity.*;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;

import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import org.bukkit.inventory.ItemFlag;

import org.bukkit.plugin.Plugin;
import org.bukkit.projectiles.ProjectileSource;

import org.bukkit.util.Vector;




public class StickHandler implements Listener{
    public StickHandler(CatToss plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin );
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerUse(PlayerInteractEvent event){
        Player p = event.getPlayer(); if(p.getItemInHand().getItemMeta().isUnbreakable() == true && p.getItemInHand().getItemMeta().hasItemFlag(ItemFlag.HIDE_UNBREAKABLE) == true){
            if(event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR){
                Vector playerDirection = p.getLocation().getDirection();
                p.launchProjectile(Arrow.class, playerDirection);
            }
        }

    }
    @EventHandler
    public void onThrow(ProjectileLaunchEvent e) {

        Projectile prj = e.getEntity();
        if (prj instanceof Arrow) {

            Arrow pearl = (Arrow) prj;
            ProjectileSource shooter = pearl.getShooter();
            if (shooter instanceof Player) {

                Location spawnLocation = pearl.getLocation();
                Entity cat = spawnLocation.getWorld().spawnEntity(spawnLocation, EntityType.CAT);

                pearl.setPassenger(cat);



                pearl.setKnockbackStrength(2);
                pearl.setVisibleByDefault(false);
                if(pearl.isOnGround() == true){
                    pearl.remove();
                    cat.remove();
                }
                if(cat.isFrozen() == true){
                    cat.remove();
                }



                Bukkit.getScheduler().runTaskLater (CatToss.getInstance(), () -> cat.remove(), 100);
                Bukkit.getScheduler().runTaskLater (CatToss.getInstance(), () -> pearl.remove(), 100);
            }
        }
    }
    @EventHandler
    public void onCatDamage(EntityDamageEvent event) {
        if(event.getEntity() instanceof  Cat) {
            event.setCancelled(true);
        }
    }

}


