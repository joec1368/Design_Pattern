package dp.templatePattern;

import dp.gui.GUI;

public class StdoutTemplate extends Template{
    public StdoutTemplate(String talker, String message) {
        super(talker, message);
    }

    @Override
    public void displayTalker() {
        System.out.println("talker: " + talker);
    }

    @Override
    public void displayMessage() {
        System.out.println(header + message);
    }
}