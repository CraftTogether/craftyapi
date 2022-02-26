package xyz.crafttogether.craftyapi.objects;

public class UserBlockBrokenObject {
    private final String username;
    private final String UUID;
    private final long blocksBroken;

    public UserBlockBrokenObject(String username, String UUID, long blocksBroken) {
        this.username = username;
        this.UUID = UUID;
        this.blocksBroken = blocksBroken;
    }

    public String getUsername() {
        return username;
    }

    public String getUUID() {
        return UUID;
    }

    public long getBlocksBroken() {
        return blocksBroken;
    }
}
