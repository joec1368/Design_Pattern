package dp.punctuationMarks.XML;

import dp.punctuationMarks.Sign;

public class XMLUnderLine extends Sign {
    @Override
    public String preSign() {
        return "<ins>";
    }

    @Override
    public String posSign() {
        return "</ins>";
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

