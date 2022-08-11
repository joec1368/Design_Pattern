package dp.templatePattern;

public class SignHeader6 implements Sign{

    @Override
    public String preSign() {
        return "###### ";
    }

    @Override
    public String posSign() {
        return "";
    }
}