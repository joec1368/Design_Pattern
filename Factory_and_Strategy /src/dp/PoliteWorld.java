package dp;

public class PoliteWorld extends World{
    @Override
    public Tree createTree(){
        return new PoliteTree();
    }

    @Override
    public Stone createStone(){
        return new PoliteStone();
    }
}
