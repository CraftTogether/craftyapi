package xyz.crafttogether.craftyapi;

import com.google.gson.Gson;
import org.bukkit.plugin.java.JavaPlugin;

public class CraftyAPI extends JavaPlugin {
    private static JavaPlugin plugin;
    private static final Gson gson = new Gson();

    @Override
    public void onEnable() {
        plugin = this;
    }

    @Override
    public void onDisable() {
    }

    public static Gson getGson() {
        return gson;
    }

    public static JavaPlugin getPlugin() {
        return plugin;
    }
}
