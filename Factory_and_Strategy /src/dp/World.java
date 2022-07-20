package dp;

public class World {
    WorldType worldType;
    public enum Type {
        Polite, Rude
    }

    public World(Type type) {
       this.worldType = new WorldType(type);
    }

    public Tree getTree() {
        return this.worldType.showTree();
    }

    public Stone getStone() {
        return this.worldType.showStone();
    }
}
