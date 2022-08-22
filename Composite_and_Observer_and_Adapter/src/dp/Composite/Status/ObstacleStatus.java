package dp.Composite.Status;

import dp.Composite.Status.InteractableStatus;
import dp.Player;

public class ObstacleStatus extends InteractableStatus {

    @Override
    public void useStatus(Player player) {
        player.backToPrePosition();
    }
}
