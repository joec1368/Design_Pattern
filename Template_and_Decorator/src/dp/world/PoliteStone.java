package dp.world;

import dp.display.Display;
import dp.interactable.Stone;

class PoliteStone extends Stone {
    @Override
    public void interact(Display display) {
        display.display("Stone", "Good morning...");
    }
}
