package dp.display;

import dp.gui.GUI;

public class GUIDisplay implements Display {
    private boolean bold;
    private boolean italic;
    public GUIDisplay(boolean bold, boolean italic) {
        this.bold = bold;
        this.italic = italic;
    }

    @Override
    public void display(String talker, String message) {
        GUI.screen.showTalker(talker);
        if (bold && italic) {
            GUI.screen.show("***" + message + "***");
        } else if (bold) {
            GUI.screen.show("**" + message + "**");
        } else if (italic) {
            GUI.screen.show("*" + message + "*");
        } else {
            GUI.screen.show(message);
        }
    }
}
