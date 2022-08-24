package dp.punctuationMarks;

public class SignHeader extends Sign{

    private int number;

    public SignHeader(int number){
        this.number = number;
    }

    @Override
    public String headerSign() {
        return "#".repeat(number) + " ";
    }
}