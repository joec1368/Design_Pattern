package dp.world;

import dp.interactable.Stone;
import dp.interactable.Tree;

public class PoliteWorld extends World {
    @Override
    protected Tree createTree() {
        return new PoliteTree();
    }

    @Override
    protected Stone createStone() {
        return new PoliteStone();
    }
}
