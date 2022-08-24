import dp.gui.GUI;
import dp.gui.Screen;
import dp.display.*;
import dp.punctuationMarks.SignBold;
import dp.punctuationMarks.SignItalic;
import dp.punctuationMarks.SignStrikeOut;
import dp.punctuationMarks.XML.XMLBold;
import dp.punctuationMarks.XML.XMLItalic;
import dp.punctuationMarks.XML.XMLStrikeOut;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
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
        Template gui = new GUITemplate("talkerA", "random");
        gui.addSign(new XMLBold(),"nd");
        gui.addSign(new XMLItalic(),"an");
        gui.addSign(new XMLStrikeOut(),"do");
        gui.displayStatement();
        verify(screen).showTalker("talkerA");
        verify(screen).show("r<i>a<b>n</i><del>d</b>o</del>m");
    }
}
