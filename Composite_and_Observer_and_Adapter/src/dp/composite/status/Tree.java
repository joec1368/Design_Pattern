package dp.composite.status;

public class Tree extends InteractableStatus {

    private int height = 5;
    private String talker = "tree";
    private String message = "treeeee";

    @Override
    protected void  interact(){
        System.out.println(talker + ":" + message);
    }

    public int getHeight(){
        return height;
    }

    public void higher(){
        height++;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public void setTalker(String talker){
        this.talker = talker;
    }

    public void setStatement(String talker, String message){
        this.talker = talker;
        this.message = message;
    }


}
