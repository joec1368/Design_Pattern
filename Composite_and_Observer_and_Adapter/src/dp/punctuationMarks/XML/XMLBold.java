package dp.punctuationMarks.XML;

import dp.punctuationMarks.Sign;

public class XMLBold extends Sign {
    @Override
    public String preSign() {
        return "<b>";
    }

    @Override
    public String posSign() {
        return "</b>";
    }

    @Override
    public int numberPreSign(){
        return 3;
    }

    @Override
    public int numberPosSign(){
        return 4;
    }


}
