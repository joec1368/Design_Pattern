package dp.world;

import dp.display.Display;
import dp.interactable.Stone;

class RudeStone extends Stone {
    @Override
    public void interact(Display display) {
        display.display("Stone", "I couldn't believe there's such an idiot who talks to a stone.");
    }
}
