package dp;

public abstract class World {
    Tree tree;
    Stone stone;

    protected abstract Tree createTree();
    protected abstract Stone createStone();

    public World() {
        this.tree = createTree();
        this.stone = createStone();
    }

    public Tree getTree() {
        return tree;
    }

    public Stone getStone() {
        return stone;
    }
}
