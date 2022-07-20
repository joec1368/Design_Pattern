package nonused;

import dp.Display;
import nonused.Accessory;

public class PoliteWorld extends Accessory {

    @Override
    public void interact_with_Tree(Display display) {
        display.display("Hi, nice you meet you!");
    }

    @Override
    public void interact_with_Stone(Display display) {
        display.display("Good morning...");
    }
}
