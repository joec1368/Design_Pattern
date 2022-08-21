package dp.templatePattern;

public class SignBold implements Sign{

    @Override
    public String preSign() {
        return "**";
    }

    @Override
    public String posSign() {
        return "**";
    }

    @Override
    public String headerSign() {
        return "";
    }
}
