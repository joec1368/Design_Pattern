package dp.world;

import dp.interactable.Stone;
import dp.interactable.Tree;

public class RudeWorld extends World {
    @Override
    protected Tree createTree() {
        return new RudeTree();
    }

    @Override
    protected Stone createStone() {
        return new RudeStone();
    }
}
