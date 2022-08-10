package dp.display;

public class StdoutDisplay implements Display {
    private boolean bold;
    private boolean italic;
    public StdoutDisplay(boolean bold, boolean italic) {
        this.bold = bold;
        this.italic = italic;
    }
    @Override
    public void display(String talker, String message) {
        System.out.println("talker: " + talker);
        if (bold && italic) {
            System.out.println("***" + message + "***");
        } else if (bold) {
            System.out.println("**" + message + "**");
        } else if (italic) {
            System.out.println("*" + message + "*");
        } else {
            System.out.println(message);
        }
    }
}
