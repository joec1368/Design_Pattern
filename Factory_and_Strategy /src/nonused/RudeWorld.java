package nonused;

import dp.Display;
import nonused.Accessory;

public class RudeWorld extends Accessory {

    @Override
    public void interact_with_Tree(Display display) {
        display.display("Don't talk to me! Fuck off!");
    }

    @Override
    public void interact_with_Stone(Display display) {
        display.display("I couldn't believe there's such an idiot who talks to a stone.");
    }
}
