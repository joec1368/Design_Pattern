package dp;

public class WorldType {
    World.Type type;
    private Tree tree;
    private Stone stone;

    WorldType(World.Type type){
        this.type = type;
        setWorld();
    }

    private void setWorld(){
        if(type == World.Type.Polite){
            this.tree = new PoliteTree();
            this.stone = new PoliteStone();
        }else {
            this.tree = new RudeTree();
            this.stone = new RudeStone();
        }
    }

    public Tree showTree(){
        return this.tree;
    }

    public Stone showStone(){
        return this.stone;
    }
}
