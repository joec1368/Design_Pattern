package dp;

import Sense.ControlSensibility;

public class Player {
    private World currentWorld;
    //private ControlSensitivity sensitivity;
    private ControlSensibility sensitivity;
    private Position currentPosition = new Position(0, 0);

    public Player(World initialWorld, ControlSensibility sensitivity) {
        currentWorld = initialWorld;
        this.sensitivity = sensitivity;
    }

    public void enter(World world) {
        currentWorld = world;
        currentPosition = new Position(0, 0);
    }

    public void changeSensitivity(ControlSensibility sensitivity) {
        this.sensitivity = sensitivity;
    }

    public void moveForward() {
        currentPosition = currentPosition.forward(this.sensitivity.unitValue());
    }

    public void moveRight() {
        currentPosition = currentPosition.right(this.sensitivity.unitValue());
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public void interactWithTree(Display display) {
        currentWorld.getTree().interact(display);
    }

    public void interactWithStone(Display display) {
        currentWorld.getStone().interact(display);
    }
}
