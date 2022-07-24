package dp;

public class RudeWorld extends World{

    @Override
    protected Tree createTree() {
        return new RudeTree();
    }

    @Override
    protected Stone createStone() {
        return new RudeStone();
    }
}
