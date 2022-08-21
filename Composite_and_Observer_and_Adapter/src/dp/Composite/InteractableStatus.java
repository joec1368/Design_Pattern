package dp.Composite;

import dp.Player;

public class InteractableStatus implements WorldObjectStatus{
    Object object;

    public InteractableStatus(Object object){
        this.object = object;
    }
    public void  interact(){
        object.talk();
    }

    @Override
    public void useStatus(Player player) {
        interact();
    }
}
