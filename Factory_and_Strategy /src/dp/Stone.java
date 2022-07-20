package dp;

public abstract class Stone implements Interactable {
    private int solidity = 5;
    public void harden() {
        solidity++;
    }

    public int getSolidity() {
        return solidity;
    }
}
