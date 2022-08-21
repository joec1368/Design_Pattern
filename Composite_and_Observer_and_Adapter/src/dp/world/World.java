package dp.world;

import dp.interactable.Stone;
import dp.interactable.Tree;

public abstract class World {
    private final Tree tree;
    private final Stone stone;

    protected abstract Tree createTree();
    protected abstract Stone createStone();

    public World() {
        tree = createTree();
        stone = createStone();
    }

    public Tree getTree() {
        return tree;
    }

    public Stone getStone() {
        return stone;
    }
}
