package xyz.crafttogether.craftyapi;

import com.google.gson.Gson;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.crafttogether.craftyapi.data.DataHandler;
import xyz.crafttogether.craftyapi.listeners.BlockBreakListener;

import java.io.IOException;
import java.util.UUID;

import static spark.Spark.*;

public class CraftyAPI extends JavaPlugin {
    private static final Logger logger = LoggerFactory.getLogger(CraftyAPI.class);
    private static JavaPlugin plugin;
    private static final Gson gson = new Gson();

    @Override
    public void onEnable() {
        plugin = this;
        try {
            DataHandler.load();
        } catch (IOException e) {
            logger.error("Failed to create new data file");
            e.printStackTrace();
            return;
        }
        addEventListeners();
        path("/api", () -> {
            path("/global", () -> {
                get("/blocks-broken", ((request, response) -> {
                    response.status(200);
                    response.type("application/json");
                    return gson.toJson(DataHandler.getGlobalBlocksBroken());
                }));
            });
            path("/user", () -> {
                get("/:id/blocks-broken", (request, response) -> {
                    String uuid = request.params().get(":id");
                    System.out.println(uuid);
                    OfflinePlayer player = Bukkit.getOfflinePlayer(UUID.fromString(uuid));
                    response.status(200);
                    response.type("application/json");
                    return gson.toJson(DataHandler.getUserBlocksBroken(player));
                });
            });
        });
    }

    private void addEventListeners() {
        final PluginManager manager = plugin.getServer().getPluginManager();
        manager.registerEvents(new BlockBreakListener(), this);
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
