package dp.Composite;

import dp.Player;

public class ObstacleStatus extends InteractableStatus{

    public ObstacleStatus(ObjectComposite objectComposite) {
        super(objectComposite);
    }

    @Override
    public void useStatus(Player player) {
        player.backToPrePosition();
    }
}
