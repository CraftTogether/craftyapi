package xyz.crafttogether.craftyapi.objects;

public class BlocksBroken {
    private final String user;
    private final long blocksBroken;

    public BlocksBroken(String user, long blocks_broken) {
        this.user = user;
        this.blocksBroken = blocks_broken;
    }

    public String getUser() {
        return user;
    }

    public long getBlocksBroken() {
        return blocksBroken;
    }
}
