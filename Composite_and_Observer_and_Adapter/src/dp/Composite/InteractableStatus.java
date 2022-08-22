package dp.Composite;

import dp.Player;

public class InteractableStatus implements WorldObjectStatus{
    ObjectComposite objectComposite;

    public InteractableStatus(ObjectComposite objectComposite){
        this.objectComposite = objectComposite;
    }
    public void  interact(){
        objectComposite.talk();
    }

    @Override
    public void useStatus(Player player) {
        interact();
    }
}
