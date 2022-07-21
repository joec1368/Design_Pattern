package observer;

import dp.Display;

public interface Observe {
    void add(String string,Listen listen);
    void decideHigher(String string);
    void decideHarder(String string);
    void decideRockToTalk(String string , Display display);
    void decideTreeToTalk(String string, Display display);
    int decideHardToShow(String string);
    int decideHeightToShow(String string);
}
