package dp.punctuationMarks;

public class SignUnderline extends Sign {
    @Override
    public String preSign() {
        return "__";
    }

    @Override
    public String posSign() {
        return "__";
    }

    @Override
    public int numberPreSign(){
        return 2;
    }

    @Override
    public int numberPosSign(){
        return 2;
    }

}
