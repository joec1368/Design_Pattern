package dp.interactable;

public abstract class Tree implements Intractable {
    private int height = 10;

    public void waterIt() {
        height++;
    }

    public int getHeight() {
        return height;
    }
}
