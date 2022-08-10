package dp.display;

import dp.gui.GUI;

public class NewItalic implements Symbol{
    NewDisplay newDisplay;
    String message;
    public NewItalic(NewDisplay newDisplay){
        this.newDisplay = newDisplay;
        this.message = newDisplay.showMessage();
        this.message = "*" + this.message + "*";
    }
    @Override
    public void displayTalker() {
        this.newDisplay.displayTalker();
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
