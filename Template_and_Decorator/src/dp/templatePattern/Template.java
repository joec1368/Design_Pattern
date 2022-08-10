package dp.templatePattern;

public abstract class Template {
    String talker;
    String message;
    public Template(String talker, String message){
        this.talker = talker;
        this.message = message;
    }
    abstract public void displayTalker();
    abstract public void displayMessage();
    public void addSign(Sign sign){
        this.message = sign.preSign() + message + sign.posSign();
    }

}
