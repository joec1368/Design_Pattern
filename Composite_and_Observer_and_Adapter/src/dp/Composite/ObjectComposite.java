package dp.Composite;

import dp.Player;
import dp.Position;

import java.util.ArrayList;
import java.util.List;

public class ObjectComposite extends Component{

    private List<WorldObjectStatus> list = new ArrayList<>();;

    Position position = new Position(0, 0);
    String talker = null;
    String message = null;
    String objectName;

    public ObjectComposite(int x , int y, String objectName){
        position = new Position(x,y);
        this.objectName = objectName;
    }

    public void setTalker(String talker) {
        this.talker = talker;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public void setSentence(String talker, String message){
        setMessage(message);
        setTalker(talker);
    }

    public String showTalker(){
        return message;
    }

    public void talk(){
        System.out.println(talker + ":" + message);
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
