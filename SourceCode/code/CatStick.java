package cattoss.catmanxvz.cattoss.Commands;

import cattoss.catmanxvz.cattoss.CatToss;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;


public class CatStick implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can run such command");
            return false;
        }
        Player p = (Player) sender;
        Bukkit.getLogger().info("Player has run command");
        ItemStack item = new ItemStack(Material.STONE_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setLore(Arrays.asList("SHOOTS CATS (click)", "V cool item", "Signed by CATMANXVZ"));
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.setDisplayName("CAT STICK");
        Bukkit.getLogger().info("MetaData Added");
        item.setItemMeta(meta);

        if(p.getInventory().contains(item)){
            p.sendMessage("You already have this item");
            return false;

        }
        if(CatToss.Plugin_Activated == false){
            p.sendMessage("You didn't activated tossing cats yet");
            return false;
        }
        p.getInventory().addItem(item);
        Bukkit.getLogger().info("Item has been successfully added");
        return true;
    }
}
