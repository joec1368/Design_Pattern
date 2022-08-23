package dp.composite;

import dp.composite.status.WorldObjectStatus;
import dp.Player;

public abstract class Component {

    public String worldName = "null";

    public Component addObject(Component leaf){
        return null;
    }

    public WorldObjectStatus addStatus(WorldObjectStatus worldObjectStatus){
        return null;
    }

    public void notifyComponent(Player player){}

    public void useStatus(Player player){}

    public void checkComponent(Player player){};

    public WorldComposite getWorld(String worldName){
        return null;
    }

    public ObjectComposite getObject(String objectName){
        return null;
    }


}
