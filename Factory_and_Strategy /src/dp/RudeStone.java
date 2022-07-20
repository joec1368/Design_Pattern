package dp;

class RudeStone extends Stone {
    @Override
    public void interact(Display display) {
        display.display("I couldn't believe there's such an idiot who talks to a stone.");
    }
}
