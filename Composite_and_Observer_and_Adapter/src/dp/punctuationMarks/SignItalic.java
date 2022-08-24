package dp.punctuationMarks;

public class SignItalic extends Sign{

    @Override
    public String preSign() {
        return "*";
    }

    @Override
    public String posSign() {
        return "*";
    }

    @Override
    public int numberPreSign(){
        return 1;
    }

    @Override
    public int numberPosSign(){
        return 1;
    }
}
