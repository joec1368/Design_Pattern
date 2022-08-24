package dp.punctuationMarks;

public abstract class Sign {
    public String preSign(){return "";}

    public String posSign(){return "";}

    public String headerSign(){return "";}

    public int numberPreSign(){
        return 0;
    }

    public int numberPosSign(){
        return 0;
    }

}
