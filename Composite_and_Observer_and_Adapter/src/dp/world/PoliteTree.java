package dp.world;

import dp.display.Display;
import dp.interactable.Tree;

class PoliteTree extends Tree {
    @Override
    public void interact(Display display) {
        display.display("Tree", "Hi, nice you meet you!");
    }
}
