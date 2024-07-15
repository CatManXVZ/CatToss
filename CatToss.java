package cattoss.catmanxvz.cattoss;

import cattoss.catmanxvz.cattoss.Commands.CatStick;
import cattoss.catmanxvz.cattoss.handlers.PlayerHandler;
import cattoss.catmanxvz.cattoss.handlers.StickHandler;
import cattoss.catmanxvz.cattoss.handlers.WoolHandler;
import org.bukkit.Bukkit;

import org.bukkit.plugin.java.JavaPlugin;



public final class CatToss extends JavaPlugin {
    public static boolean Plugin_Activated = false;

    private static CatToss instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getLogger().info("Start Off");

        instance = this;

        new WoolHandler(this);
        new PlayerHandler(this);
        new StickHandler(this);

        getCommand("CatStick").setExecutor(new CatStick());
    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info("Shutting off");
    }
    public static CatToss getInstance() {
        return instance;
    }
}

