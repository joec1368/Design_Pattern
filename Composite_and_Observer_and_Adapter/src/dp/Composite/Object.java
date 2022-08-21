package dp.Composite;

import dp.Player;
import dp.Position;

import java.util.ArrayList;
import java.util.List;

public class Object extends Component{

    private List<WorldObjectStatus> list = new ArrayList<>();;

    Position position = new Position(0, 0);
    String talker;
    String message;

    public Object(int x , int y,String talker, String message){
        position = new Position(x,y);
        this.talker = talker;
        this.message = message;
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
    public Component getObject(Position position){
        if(this.position.equals(position)) return this;
        else return null;
    }

    @Override
    public void useStatus(Player player) {
        for (WorldObjectStatus status : list) {
            status.useStatus(player);
        }
    }

    @Override
    public void addStatue(WorldObjectStatus worldObjectStatus){
        list.add(worldObjectStatus);
    }
}
