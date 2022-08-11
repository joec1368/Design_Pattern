import dp.gui.GUI;
import dp.gui.Screen;
import dp.templatePattern.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class GUIDisplayTest {

    @Mock
    Screen screen;

    @BeforeEach
    public void setup() {
        GUI.screen = screen;
    }


    @Test
    public void TestNormalContent() {
        Template gui = new GUITemplate("talkerA", "random content");
        gui.displayTalker();
        gui.displayMessage();
        verify(screen).showTalker("talkerA");
        verify(screen).show("random content");
    }

    @Test
    public void TestBoldContent() {
        Template gui = new GUITemplate("talkerA", "random content");
        gui.addSign(new SignBold());
        gui.displayTalker();
        gui.displayMessage();
        verify(screen).showTalker("talkerA");
        verify(screen).show("**random content**");
    }

    @Test
    public void TestItalicContent() {
        Template gui = new GUITemplate("talkerA", "random content");
        gui.addSign(new SignItalic());
        gui.displayTalker();
        gui.displayMessage();
        verify(screen).showTalker("talkerA");
        verify(screen).show("*random content*");
    }

    @Test
    public void TestBoldAndItalicContent() {
        Template gui = new GUITemplate("talkerA", "random content");
        gui.addSign(new SignItalic());
        gui.addSign(new SignBold());
        gui.displayTalker();
        gui.displayMessage();
        verify(screen).showTalker("talkerA");
        verify(screen).show("***random content***");
    }

    @Test
    public void TestHeader1Content() {
        Template gui = new GUITemplate("talkerA", "random content");
        gui.addSign(new SignHeader1());
        gui.displayTalker();
        gui.displayMessage();
        verify(screen).showTalker("talkerA");
        verify(screen).show("# random content");
    }

    @Test
    public void TestHeader2Content() {
        Template gui = new GUITemplate("talkerA", "random content");
        gui.addSign(new SignHeader2());
        gui.displayTalker();
        gui.displayMessage();
        verify(screen).showTalker("talkerA");
        verify(screen).show("## random content");
    }

    @Test
    public void TestHeader3Content() {
        Template gui = new GUITemplate("talkerA", "random content");
        gui.addSign(new SignHeader3());
        gui.displayTalker();
        gui.displayMessage();
        verify(screen).showTalker("talkerA");
        verify(screen).show("### random content");
    }

    @Test
    public void TestHeader4Content() {
        Template gui = new GUITemplate("talkerA", "random content");
        gui.addSign(new SignHeader4());
        gui.displayTalker();
        gui.displayMessage();
        verify(screen).showTalker("talkerA");
        verify(screen).show("#### random content");
    }

    @Test
    public void TestHeader5Content() {
        Template gui = new GUITemplate("talkerA", "random content");
        gui.addSign(new SignHeader5());
        gui.displayTalker();
        gui.displayMessage();
        verify(screen).showTalker("talkerA");
        verify(screen).show("##### random content");
    }

    @Test
    public void TestHeader6Content() {
        Template gui = new GUITemplate("talkerA", "random content");
        gui.addSign(new SignHeader6());
        gui.displayTalker();
        gui.displayMessage();
        verify(screen).showTalker("talkerA");
        verify(screen).show("###### random content");
    }

    @Test
    public void TestStrikeOutContent() {
        Template gui = new GUITemplate("talkerA", "random content");
        gui.addSign(new SignStrikeOut());
        gui.displayTalker();
        gui.displayMessage();
        verify(screen).showTalker("talkerA");
        verify(screen).show("~~random content~~");
    }

    @Test
    public void TestMixContent() {
        Template gui = new GUITemplate("talkerA", "random content");
        gui.addSign(new SignStrikeOut());
        gui.addSign(new SignBold());
        gui.addSign(new SignItalic());
        gui.addSign(new SignHeader1());
        gui.displayTalker();
        gui.displayMessage();
        verify(screen).showTalker("talkerA");
        verify(screen).show("# ***~~random content~~***");
    }

    @Test
    public void TestRemixContent() {
        Template gui = new GUITemplate("talkerA", "random content");
        gui.addSign(new SignHeader2());
        gui.addSign(new SignStrikeOut());
        gui.addSign(new SignBold());
        gui.addSign(new SignItalic());
        gui.addSign(new SignHeader3());
        gui.displayTalker();
        gui.displayMessage();
        verify(screen).showTalker("talkerA");
        verify(screen).show("### ~~***random content***~~");
    }

}
