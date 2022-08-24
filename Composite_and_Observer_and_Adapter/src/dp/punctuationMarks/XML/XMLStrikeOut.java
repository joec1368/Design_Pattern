package dp.punctuationMarks.XML;

import dp.punctuationMarks.Sign;

public class XMLStrikeOut extends Sign {
    @Override
    public String preSign() {
        return "<del>";
    }

    @Override
    public String posSign() {
        return "</del>";
    }

    @Override
    public int numberPreSign(){
        return 5;
    }

    @Override
    public int numberPosSign(){
        return 6;
    }


}
