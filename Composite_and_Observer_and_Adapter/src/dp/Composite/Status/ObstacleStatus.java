package dp.composite.status;

import dp.Player;

public class ObstacleStatus extends InteractableStatus {

    @Override
    public void useStatus(Player player) {
        player.backToPrePosition();
    }
}
