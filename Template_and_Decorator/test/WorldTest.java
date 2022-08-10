import dp.display.Display;
import dp.world.PoliteWorld;
import dp.world.RudeWorld;
import dp.world.World;
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
        order.verify(display).display("Tree", "Hi, nice you meet you!");
        order.verify(display).display("Stone", "Good morning...");
    }

    @Test
    public void TestRudeWorld() {
        World world = new RudeWorld();
        world.getTree().interact(display);
        world.getStone().interact(display);
        InOrder order = inOrder(display);
        order.verify(display).display("Tree", "Don't talk to me! Fuck off!");
        order.verify(display).display("Stone", "I couldn't believe there's such an idiot who talks to a stone.");
    }
}
