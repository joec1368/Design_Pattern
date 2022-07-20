package nonused;

public abstract class Accessory implements InteractableAccessory {
    private int stone_Solidity = 5;
    public void stone_Harden() {
        stone_Solidity++;
    }

    public int stone_GetSolidity() {
        return stone_Solidity;
    }

    private int tree_Height = 10;

    public void tree_WaterIt() {
        tree_Height++;
    }

    public int tree_GetHeight() {
        return tree_Height;
    }
}
