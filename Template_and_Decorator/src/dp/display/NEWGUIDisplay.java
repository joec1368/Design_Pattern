package dp.display;

import dp.gui.GUI;

public class NEWGUIDisplay implements NewDisplay{

    String talker;
    String message;
    public NEWGUIDisplay(String talker, String message){
        this.talker = talker;
        this.message = message;
    }
    @Override
    public void displayTalker() {
        GUI.screen.showTalker(talker);
    }

    @Override
    public void displayMessage() {
        GUI.screen.show(message);
    }

    @Override
    public String showMessage() {
        return message;
    }
}
