package dp.Composite;

import dp.Player;
import dp.Position;

import java.util.List;

public abstract class Component {

    public String worldName = "null";

    public void addObject(Component leaf){}

    public void addStatue(WorldObjectStatus worldObjectStatus){}

    public void notifyComponent(Player player){}

    public void useStatus(Player player){}

    public void checkComponent(Player player){};

    public Component getWorld(String worldName){
        return null;
    }

    public Component getObject(Position position){
        return null;
    }


}
