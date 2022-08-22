package dp.Composite;

import dp.Player;

public abstract class Component {

    public String worldName = "null";

    public void addObject(Component leaf){}

    public void addStatus(WorldObjectStatus worldObjectStatus){}

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
