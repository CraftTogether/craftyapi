import com.google.gson.Gson;
import org.bukkit.plugin.java.JavaPlugin;

public class CraftyAPI extends JavaPlugin {
    private static final Gson gson = new Gson();

    @Override
    public void onEnable() {
    }

    @Override
    public void onDisable() {
    }

    public Gson getGson() {
        return gson;
    }
}
