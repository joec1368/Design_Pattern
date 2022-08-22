package dp;

import dp.Composite.WorldComposite;
import dp.display.Display;
import dp.interactable.Intractable;
import dp.sensitivity.ControlSensitivity;
import dp.world.World;

public class Player {
    private WorldComposite currentWorld;
    private ControlSensitivity sensitivity;
    private Position currentPosition = new Position(0, 0);
    private Position prePosition = new Position(0, 0);

    public Player(WorldComposite initialWorld, ControlSensitivity sensitivity) {
        currentWorld = initialWorld;
        this.sensitivity = sensitivity;
    }

    public void enter(WorldComposite world) {
        currentWorld = world;
        currentPosition = new Position(0, 0);
        prePosition = new Position(0,0);
    }

    public void changeSensitivity(ControlSensitivity sensitivity) {
        this.sensitivity = sensitivity;
    }

    public void moveForward() {
        setPrePosition();
        currentPosition = currentPosition.forward(sensitivity.unitValue());
        currentWorld.checkComponent(this);
    }

    public void moveBackward() {
        setPrePosition();
        currentPosition = currentPosition.backward(sensitivity.unitValue());
        currentWorld.checkComponent(this);
    }

    public void moveRight() {
        setPrePosition();
        currentPosition = currentPosition.right(sensitivity.unitValue());
        currentWorld.checkComponent(this);
    }

    public void moveLeft() {
        setPrePosition();
        currentPosition = currentPosition.left(sensitivity.unitValue());
        currentWorld.checkComponent(this);
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public void backToPrePosition(){
        currentPosition = prePosition;
    }

    private void setPrePosition(){
        prePosition = currentPosition;
    }
}
