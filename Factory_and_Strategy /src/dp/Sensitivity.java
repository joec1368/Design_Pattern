package dp;

public class Sensitivity {
    Player.ControlSensitivity sensitivity;
    private int weight;

    public Sensitivity(Player.ControlSensitivity sensitivity){
        this.sensitivity = sensitivity;
        setWeight();
    }
    public int showWeight(){
        return weight;
    }

    private void setWeight(){
        if(this.sensitivity == Player.ControlSensitivity.HIGH){
            weight = 50;
        }else if(this.sensitivity == Player.ControlSensitivity.LOW){
            weight = 5;
        }else if(this.sensitivity == Player.ControlSensitivity.MEDIUM){
            weight = 20;
        }else{
            weight = 100;
        }
    }
}
