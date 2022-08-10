package dp.interactable;

public abstract class Tree implements Interactable {
    private int height = 10;

    public void waterIt() {
        height++;
    }

    public int getHeight() {
        return height;
    }
}
