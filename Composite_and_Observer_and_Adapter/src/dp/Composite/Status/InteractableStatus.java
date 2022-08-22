package dp.Composite.Status;

import dp.Player;

public class InteractableStatus implements WorldObjectStatus {
    public void  interact(){}

    @Override
    public void useStatus(Player player) {
        interact();
    }
}
