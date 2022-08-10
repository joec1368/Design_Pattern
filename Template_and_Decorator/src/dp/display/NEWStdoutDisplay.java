package dp.display;

import dp.gui.GUI;

public class NEWStdoutDisplay implements NewDisplay{
    String talker;
    String message;
    public NEWStdoutDisplay(String talker, String message){
        this.talker = talker;
        this.message = message;
    }
    @Override
    public void displayTalker() {
        System.out.println("talker: " + talker);
    }

    @Override
    public void displayMessage() {
        System.out.println(message);
    }

    @Override
    public String showMessage() {
        return message;
    }
}
