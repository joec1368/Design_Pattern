package dp.templatePattern;

public class SignHeader2 implements Sign{

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
        return "## ";
    }
}