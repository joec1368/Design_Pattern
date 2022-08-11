package dp.templatePattern;

public abstract class Template {
    String talker;
    String message;
    String header;
    String preSign;
    String posSign;
    public Template(String talker, String message){
        this.talker = talker;
        this.message = message;
        this.header = "";
        this.preSign = "";
        this.posSign = "";
    }
    abstract public void displayTalker();
    abstract public void displayMessage();
    public void addSign(Sign sign){
        this.preSign = this.preSign + sign.preSign() ;
        this.posSign = sign.posSign() + this.posSign;
        if(sign.headerSign().equals(""));
        else
            this.header = sign.headerSign();
    }

}
