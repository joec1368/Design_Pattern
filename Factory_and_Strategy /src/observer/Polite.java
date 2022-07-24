package observer;

import dp.Display;

public class Polite extends Replacement implements Listen {
    @Override
    public void talkRock(Display display){
        display.display("Good morning...");
    }

    @Override
    public void talkTree(Display display){
        display.display("Hi, nice you meet you!");
    }


}
