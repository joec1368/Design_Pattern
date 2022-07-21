package observer;

import dp.Display;

public class Rude extends Replacement implements Listen{
    @Override
    public void talkRock(Display display){
        display.display("I couldn't believe there's such an idiot who talks to a stone.");
    }

    @Override
    public void talkTree(Display display){
        display.display("Don't talk to me! Fuck off!");
    }

}
