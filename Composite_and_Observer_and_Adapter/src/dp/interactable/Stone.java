package dp.interactable;

import dp.Composite.WorldObjectStatus;

public abstract class Stone implements Intractable{
    private int solidity = 5;
    public void harden() {
        solidity++;
    }

    public int getSolidity() {
        return solidity;
    }
}
