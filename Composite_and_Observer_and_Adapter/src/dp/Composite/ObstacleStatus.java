package dp.Composite;

import dp.Player;

public class ObstacleStatus extends InteractableStatus{

    public ObstacleStatus(Object object) {
        super(object);
    }

    @Override
    public void useStatus(Player player) {
        player.backToPrePosition();
    }
}
