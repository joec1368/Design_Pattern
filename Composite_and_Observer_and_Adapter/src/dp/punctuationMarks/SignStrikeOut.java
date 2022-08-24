package dp.punctuationMarks;

public class SignStrikeOut extends Sign{

    @Override
    public String preSign() {
        return "~~";
    }

    @Override
    public String posSign() {
        return "~~";
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