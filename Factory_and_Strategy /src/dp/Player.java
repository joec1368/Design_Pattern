package dp;

public class Player {
    private World currentWorld;
    //private ControlSensitivity sensitivity;
    private Sensitivity sensitivity;
    private Position currentPosition = new Position(0, 0);
    public enum ControlSensitivity {
        LOW, MEDIUM, HIGH , VERYHIGH
    }

    public Player(World initialWorld, ControlSensitivity sensitivity) {
        currentWorld = initialWorld;
        this.sensitivity = new Sensitivity(sensitivity);
    }

    public void enter(World world) {
        currentWorld = world;
        currentPosition = new Position(0, 0);
    }

    public void changeSensitivity(ControlSensitivity sensitivity) {
        this.sensitivity = new Sensitivity(sensitivity);
    }

    public void moveForward() {
        currentPosition = currentPosition.forward(this.sensitivity.showWeight());
    }

    public void moveRight() {
        currentPosition = currentPosition.right(this.sensitivity.showWeight());
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
