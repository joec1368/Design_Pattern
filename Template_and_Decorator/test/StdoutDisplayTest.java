import dp.display.*;
import dp.templatePattern.*;
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
        Template gui = new StdoutTemplate("talkerA", "random content");
        gui.addSign(new TemplateBold());
        gui.displayTalker();
        gui.displayMessage();
        assertEquals("talker: talkerA\n**random content**\n", newOut.toString());
    }

    @Test
    public void TestItalicContent() {
        Template gui = new StdoutTemplate("talkerA", "random content");
        gui.addSign(new TemplateItalic());
        gui.displayTalker();
        gui.displayMessage();
         assertEquals("talker: talkerA\n*random content*\n", newOut.toString());
    }

    @Test
    public void TestBoldAndItalicContent() {
        Template gui = new StdoutTemplate("talkerA", "random content");
        gui.addSign(new TemplateItalic());
        gui.addSign(new TemplateBold());
        gui.displayTalker();
        gui.displayMessage();
        assertEquals("talker: talkerA\n***random content***\n", newOut.toString());
    }

    @Test
    public void TestHeader1Content() {
        Template gui = new StdoutTemplate("talkerA", "random content");
        gui.addSign(new TemplateHeader1());
        gui.displayTalker();
        gui.displayMessage();
        assertEquals("talker: talkerA\n# random content\n", newOut.toString());
    }

    @Test
    public void TestHeader2Content() {
        Template gui = new StdoutTemplate("talkerA", "random content");
        gui.addSign(new TemplateHeader2());
        gui.displayTalker();
        gui.displayMessage();
        assertEquals("talker: talkerA\n## random content\n", newOut.toString());
    }

    @Test
    public void TestHeader3Content() {
        Template gui = new StdoutTemplate("talkerA", "random content");
        gui.addSign(new TemplateHeader3());
        gui.displayTalker();
        gui.displayMessage();
        assertEquals("talker: talkerA\n### random content\n", newOut.toString());
    }

    @Test
    public void TestHeader4Content() {
        Template gui = new StdoutTemplate("talkerA", "random content");
        gui.addSign(new TemplateHeader4());
        gui.displayTalker();
        gui.displayMessage();
        assertEquals("talker: talkerA\n#### random content\n", newOut.toString());
    }

    @Test
    public void TestHeader5Content() {
        Template gui = new StdoutTemplate("talkerA", "random content");
        gui.addSign(new TemplateHeader5());
        gui.displayTalker();
        gui.displayMessage();
        assertEquals("talker: talkerA\n##### random content\n", newOut.toString());
    }

    @Test
    public void TestHeader6Content() {
        Template gui = new StdoutTemplate("talkerA", "random content");
        gui.addSign(new TemplateHeader6());
        gui.displayTalker();
        gui.displayMessage();
        assertEquals("talker: talkerA\n###### random content\n", newOut.toString());
    }

    @Test
    public void TestStrikeOutContent() {
        Template gui = new StdoutTemplate("talkerA", "random content");
        gui.addSign(new TemplateStrikeOut());
        gui.displayTalker();
        gui.displayMessage();
        assertEquals("talker: talkerA\n~~random content~~\n", newOut.toString());
    }

    @Test
    public void TestMIXContent() {
        Template gui = new StdoutTemplate("talkerA", "random content");
        gui.addSign(new TemplateStrikeOut());
        gui.addSign(new TemplateBold());
        gui.addSign(new TemplateItalic());
        gui.addSign(new TemplateHeader1());
        gui.displayTalker();
        gui.displayMessage();
        assertEquals("talker: talkerA\n# ***~~random content~~***\n", newOut.toString());
    }

    @AfterEach
    public void teardown() {
        System.setOut(oldOut);
    }
}
