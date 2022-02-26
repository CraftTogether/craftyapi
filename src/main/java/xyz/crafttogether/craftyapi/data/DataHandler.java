package xyz.crafttogether.craftyapi.data;

import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.crafttogether.craftyapi.CraftyAPI;
import xyz.crafttogether.craftyapi.objects.GlobalBlockBrokenObject;
import xyz.crafttogether.craftyapi.objects.UserBlockBrokenObject;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class DataHandler {
    private static final Logger logger = LoggerFactory.getLogger(CraftyAPI.class);
    private static File file;
    private static FileConfiguration data;
    private static final String PATH = "plugins/CraftCore/api-data.yml";

    public static void load() throws IOException {
        System.out.println(PATH);
        file = new File(PATH);
        if (!file.exists()) {
            file.createNewFile();
        }
        reload();
    }

    public static void reload() {
        data = YamlConfiguration.loadConfiguration(file);
    }

    public static synchronized void save() {
        try {
            data.save(file);
        } catch (IOException e) {
            logger.error("Failed to save data to disk");
            e.printStackTrace();
        }
    }

    public static GlobalBlockBrokenObject getGlobalBlocksBroken() {
        return new GlobalBlockBrokenObject(data.getLong("global.blocks_broken"));
    }

    public static void addGlobalBlockBroken() {
        data.set("global.blocks_broken", getGlobalBlocksBroken().getBlocksBroken() + 1);
        save();
    }

    public static UserBlockBrokenObject getUserBlocksBroken(OfflinePlayer player) {
        return new UserBlockBrokenObject(player.getName(), player.getUniqueId().toString(),
                data.getLong(player.getUniqueId() + ".blocks_broken"));
    }

    public static void addPlayerBlockBroken(OfflinePlayer player) {
        data.set(player + ".blocks_broken", getUserBlocksBroken(player).getBlocksBroken() + 1);
        save();
    }
}
