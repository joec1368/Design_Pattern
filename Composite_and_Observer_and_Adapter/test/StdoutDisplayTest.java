import dp.display.*;
import dp.punctuationMarks.SignBold;
import dp.punctuationMarks.SignItalic;
import dp.punctuationMarks.SignStrikeOut;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

public class StdoutDisplayTest {

    private PrintStream oldOut;
    private ByteArrayOutputStream newOut;
    @BeforeEach
    public void setup() {
        oldOut = System.out;
        newOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(newOut));
    }

    @Test
    public void TestNormalContent() {
        Template gui = new StdoutTemplate("talkerA", "random content");
        gui.displayTalker();
        gui.displayMessage();
        assertEquals("talker: talkerA\nrandom content\n", newOut.toString());
    }

    @Test
    public void TestBoldContent() {
        Template gui = new StdoutTemplate("talkerA", "random");
        gui.addSign(new SignBold(),"nd");
        gui.addSign(new SignItalic(),"an");
        gui.addSign(new SignStrikeOut(),"do");
        gui.displayStatement();
        assertEquals("talker: talkerA\nr*a**n*~~d**o~~m\n", newOut.toString());
    }

    @AfterEach
    public void teardown() {
        System.setOut(oldOut);
    }
}
