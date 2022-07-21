package observer;

import dp.Display;

public abstract class Replacement implements Listen{

    int height = 10;
    int hard = 5;
    @Override
    public void harder() {
        hard++;
    }

    @Override
    public void higher() {
        height++;
    }

    @Override
    public int showHeight(){
        return height;
    }

    @Override
    public int showHard(){
        return hard;
    }
    @Override
    public void talkTree(Display display){

    }

    @Override
    public void talkRock(Display display){

    }

}
