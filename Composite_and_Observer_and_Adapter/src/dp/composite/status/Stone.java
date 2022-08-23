package dp.composite.status;

public class Stone extends InteractableStatus {

    private int harden = 5;
    private String talker = "stone";
    private String message = "stoneeeee";

    @Override
    protected void  interact(){
        System.out.println(talker + ":" + message);
    }

    public int getHarden(){
        return harden;
    }

    public void harder(){
        harden++;
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
