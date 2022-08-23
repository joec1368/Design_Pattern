package dp.composite;

import dp.Player;

import java.util.ArrayList;
import java.util.List;

public class WorldComposite extends Component{

    private List<Component> list = new ArrayList<>();

    public WorldComposite(String worldName){
        this.worldName = worldName;
    }

    @Override
    public Component addObject(Component leaf) {
        list.add(leaf);
        return leaf;
    }

    @Override
    public void checkComponent(Player player) {
        for(Component world : list){
           world.notifyComponent(player);
        }
    }

    @Override
    public WorldComposite getWorld(String worldName) {
        for(Component world : list){
            if(world.worldName.equals(worldName)){
                return (WorldComposite)world;
            }else{
                Component hopingWorld = world.getWorld(worldName);
                if(hopingWorld != null) return (WorldComposite)hopingWorld;
            }
        }
        return null;
    }

    @Override
    public ObjectComposite getObject(String objectName){
        for(Component object : list){
            if(object.getObject(objectName) != null){
                return (ObjectComposite)object;
            }
        }
        return null;
    }
}
