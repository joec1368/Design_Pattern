package dp.composite.status;

import dp.Player;

public class InteractableStatus implements WorldObjectStatus {

    protected void  interact(){}

    @Override
    public void useStatus(Player player) {
        interact();
    }
}
