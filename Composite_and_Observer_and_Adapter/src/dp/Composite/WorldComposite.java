package dp.Composite;

import dp.Player;
import dp.Position;

import java.util.ArrayList;
import java.util.List;

public class WorldComposite extends Component{

    private List<Component> list = new ArrayList<>();

    public WorldComposite(String worldName){
        this.worldName = worldName;
    }

    @Override
    public void addObject(Component leaf) {
        list.add(leaf);
    }

    @Override
    public void checkComponent(Player player) {
        for(Component world : list){
           world.notifyComponent(player);
        }
    }

    @Override
    public Component getWorld(String worldName) {
        for(Component world : list){
            if(world.worldName.equals(worldName)){
                return world;
            }else{
                Component hopingWorld = world.getWorld(worldName);
                if(hopingWorld != null) return hopingWorld;
            }
        }
        return null;
    }

    @Override
    public Component getObject(Position position){
        for(Component object : list){
            if(object.getObject(position) != null){
                return object;
            }
        }
        return null;
    }
}
