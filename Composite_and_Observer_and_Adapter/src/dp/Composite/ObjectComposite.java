package dp.Composite;

import dp.Composite.Status.WorldObjectStatus;
import dp.Player;
import dp.Position;

import java.util.ArrayList;
import java.util.List;

public class ObjectComposite extends Component{

    private List<WorldObjectStatus> list = new ArrayList<>();;

    Position position;
    String objectName;

    public ObjectComposite(int x , int y, String objectName){
        position = new Position(x,y);
        this.objectName = objectName;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public void notifyComponent(Player player) {
        if(this.position.equals(player.getCurrentPosition())) useStatus(player);
    }

    @Override
    public ObjectComposite getObject(String objectName){
        if(this.objectName.equals(objectName)) return this;
        else return null;
    }

    @Override
    public void useStatus(Player player) {
        for (WorldObjectStatus status : list) {
            status.useStatus(player);
        }
    }

    @Override
    public void addStatus(WorldObjectStatus worldObjectStatus){
        list.add(worldObjectStatus);
    }
}
