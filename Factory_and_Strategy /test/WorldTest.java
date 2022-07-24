import dp.Display;
import dp.PoliteWorld;
import dp.RudeWorld;
import dp.World;
import observer.Observe;
import observer.Observer;
import observer.Polite;
import observer.Rude;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.inOrder;

@ExtendWith(MockitoExtension.class)
public class WorldTest {
    @Mock
    Display display;

    @Test
    public void TestPoliteWorld() {
        World world = new PoliteWorld();
        world.getTree().interact(display);
        world.getStone().interact(display);
        InOrder order = inOrder(display);
        order.verify(display).display("Hi, nice you meet you!");
        order.verify(display).display("Good morning...");
    }

    @Test
    public void TestRudeWorld() {
        World world = new RudeWorld();
        world.getTree().interact(display);
        world.getStone().interact(display);
        InOrder order = inOrder(display);
        order.verify(display).display("Don't talk to me! Fuck off!");
        order.verify(display).display("I couldn't believe there's such an idiot who talks to a stone.");
    }

    @Test
    public void testWorld(){
        Observe observer = new Observer();
        observer.add("Polite",new Polite());
        observer.add("Rude",new Rude());
        observer.decideTreeToTalk("Polite",display);
        observer.decideRockToTalk("Polite",display);
        InOrder order = inOrder(display);

        order.verify(display).display("Hi, nice you meet you!");
        order.verify(display).display("Good morning...");
        observer.decideTreeToTalk("Rude",display);
        observer.decideRockToTalk("Rude",display);

        order = inOrder(display);
        order.verify(display).display("Don't talk to me! Fuck off!");
        order.verify(display).display("I couldn't believe there's such an idiot who talks to a stone.");
    }
}
