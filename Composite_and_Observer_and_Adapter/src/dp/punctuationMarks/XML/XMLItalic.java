package dp.punctuationMarks.XML;

import dp.punctuationMarks.Sign;

public class XMLItalic extends Sign {
    @Override
    public String preSign() {
        return "<i>";
    }

    @Override
    public String posSign() {
        return "</i>";
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

