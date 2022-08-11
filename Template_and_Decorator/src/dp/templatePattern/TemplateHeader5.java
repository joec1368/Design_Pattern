package dp.templatePattern;

public class TemplateHeader5 implements Sign{

    @Override
    public String preSign() {
        return "##### ";
    }

    @Override
    public String posSign() {
        return "";
    }
}