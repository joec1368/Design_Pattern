package dp.templatePattern;

public class SignHeader3 implements Sign{

    @Override
    public String preSign() {
        return "";
    }

    @Override
    public String posSign() {
        return "";
    }

    @Override
    public String headerSign() {
        return "### ";
    }
}