package dp.world;

import dp.display.Display;
import dp.interactable.Tree;

class RudeTree extends Tree {
    @Override
    public void interact(Display display) {
        display.display("Tree", "Don't talk to me! Fuck off!");
    }
}
