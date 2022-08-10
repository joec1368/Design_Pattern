package dp;

import dp.display.Display;
import dp.interactable.Interactable;
import dp.sensitivity.ControlSensitivity;
import dp.world.World;

public class Player {
    private World currentWorld;
    private ControlSensitivity sensitivity;
    private Position currentPosition = new Position(0, 0);

    public Player(World initialWorld, ControlSensitivity sensitivity) {
        currentWorld = initialWorld;
        this.sensitivity = sensitivity;
    }

    public void enter(World world) {
        currentWorld = world;
        currentPosition = new Position(0, 0);
    }

    public void changeSensitivity(ControlSensitivity sensitivity) {
        this.sensitivity = sensitivity;
    }

    public void moveForward() {
        currentPosition = currentPosition.forward(sensitivity.unitValue());
    }

    public void moveRight() {
        currentPosition = currentPosition.right(sensitivity.unitValue());
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public void interactWithTree(Display display) {
        interact(currentWorld.getTree(), display);
    }

    public void interactWithStone(Display display) {
        interact(currentWorld.getStone(), display);
    }

    private void interact(Interactable interactable, Display display) {
        interactable.interact(display);
    }
}
