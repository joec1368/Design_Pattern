package dp.templatePattern;

public class TemplateBold implements Sign{

    @Override
    public String preSign() {
        return "**";
    }

    @Override
    public String posSign() {
        return "**";
    }
}
