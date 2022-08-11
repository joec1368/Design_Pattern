package dp.templatePattern;

public abstract class Template {
    String talker;
    String message;
    String header;
    public Template(String talker, String message){
        this.talker = talker;
        this.message = message;
        this.header = "";
    }
    abstract public void displayTalker();
    abstract public void displayMessage();
    public void addSign(Sign sign){
        this.message = sign.preSign() + this.message + sign.posSign();
        if(sign.headerSign().equals(""));
        else
            this.header = sign.headerSign();
    }

}
