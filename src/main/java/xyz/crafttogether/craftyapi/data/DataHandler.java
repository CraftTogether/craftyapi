package xyz.crafttogether.craftyapi.data;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.crafttogether.craftyapi.CraftyAPI;

import java.io.File;
import java.io.IOException;

public class DataHandler {
    private static final Logger logger = LoggerFactory.getLogger(CraftyAPI.class);
    private static File file;
    private static FileConfiguration data;
    private static final String PATH = CraftyAPI.getPlugin().getDataFolder() + "/CraftCore/api-data.yml";

    public static void load() throws IOException {
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
}
