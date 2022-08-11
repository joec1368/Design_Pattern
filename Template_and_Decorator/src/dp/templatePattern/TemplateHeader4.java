package dp.templatePattern;

public class TemplateHeader4 implements Sign{

    @Override
    public String preSign() {
        return "#### ";
    }

    @Override
    public String posSign() {
        return "";
    }
}