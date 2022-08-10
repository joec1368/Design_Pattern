package dp.templatePattern;

import dp.gui.GUI;

public class GUITemplate extends Template{
    public GUITemplate(String talker, String message) {
        super(talker, message);
    }

    @Override
    public void displayTalker() {
        GUI.screen.showTalker(talker);
    }

    @Override
    public void displayMessage() {
        GUI.screen.show(message);
    }
}
