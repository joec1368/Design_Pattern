package dp.templatePattern;

public class TemplateStrikeOut implements Sign{

    @Override
    public String preSign() {
        return "~~";
    }

    @Override
    public String posSign() {
        return "~~";
    }
}