package observer;

import dp.Display;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Observer implements Observe{
    //public List<Listen> container = new ArrayList();
    Map<String, Listen> container = new HashMap<String, Listen>();
    public Observer(){
        container = new HashMap<String, Listen>();
    }
    @Override
    public void add(String string, Listen listen) {
        container.put(string,listen);
    }

    @Override
    public void decideHigher(String string){
        container.get(string).higher();
    }

    @Override
    public void decideHarder(String string){
        container.get(string).harder();
    }

    @Override
    public void decideRockToTalk(String string , Display display){
        container.get(string).talkRock(display);
    }

    @Override
    public void decideTreeToTalk(String string , Display display){
        container.get(string).talkTree(display);
    }

    @Override
    public int decideHardToShow(String string){
       return container.get(string).showHard();
    }

    @Override
    public int decideHeightToShow(String string){
        return container.get(string).showHeight();
    }

}
