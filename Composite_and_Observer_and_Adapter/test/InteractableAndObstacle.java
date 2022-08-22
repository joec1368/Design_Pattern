import dp.*;
import dp.Composite.*;
import dp.Composite.ObjectComposite;
import dp.sensitivity.ControlSensitivityHigh;
import dp.world.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT) //we have to use this to stub in @BeforeEach
public class InteractableAndObstacle {
    @Mock
    World world;

    private PrintStream oldOut;
    private ByteArrayOutputStream newOut;
    private Component wholeWorld;
    private WorldComposite strangeWorld;
    private WorldComposite normalWorld;

    @BeforeEach
    public void setupWorld() {
        oldOut = System.out;
        newOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(newOut));
        //setting world
        wholeWorld = new WorldComposite("wholeWorld");
        wholeWorld.addObject(new WorldComposite("strange"));
        wholeWorld.addObject(new WorldComposite("normal"));
        strangeWorld = wholeWorld.getWorld("strange");
        normalWorld = wholeWorld.getWorld("normal");

        //setting strange world objects
        strangeWorld.addObject(new ObjectComposite(0,20,"stone"));
        ObjectComposite strangeWorldObject = strangeWorld.getObject("stone");
        strangeWorldObject.setSentence("stone","stoneeeee");

        //setting normal world objects
        normalWorld.addObject(new ObjectComposite(0,-20,"tree"));
        ObjectComposite normalWorldObject = normalWorld.getObject("tree");
        normalWorldObject.setSentence("tree","treeeee");
    }


    @Test
    public void InteractalbeObject() {
        Player player = new Player(strangeWorld, new ControlSensitivityHigh());
        ObjectComposite strangeWorldObject = strangeWorld.getObject("stone");
        strangeWorldObject.addStatus(new InteractableStatus(strangeWorldObject));
        player.moveForward();
        assertEquals("stone:stoneeeee\n", newOut.toString());
        assertEquals(player.getCurrentPosition(), new Position(0, 20));

        newOut.reset();

        player.enter(normalWorld);
        assertEquals(player.getCurrentPosition(), new Position(0, 0));
        ObjectComposite normalWorldObject = normalWorld.getObject("tree");
        normalWorldObject.addStatus(new InteractableStatus(normalWorldObject));
        player.moveForward();
        player.moveBackward();
        player.moveBackward();
        assertEquals("tree:treeeee\n", newOut.toString());
        assertEquals(player.getCurrentPosition(), new Position(0, -20));

    }

    @Test
    public void ObstacleAndInteractableObject() {
        Player player = new Player(strangeWorld, new ControlSensitivityHigh());
        ObjectComposite strangeWorldObject = strangeWorld.getObject("stone");
        strangeWorldObject.addStatus(new InteractableStatus(strangeWorldObject));
        strangeWorldObject.addStatus(new ObstacleStatus(strangeWorldObject));
        player.moveForward();
        assertEquals("stone:stoneeeee\n", newOut.toString());
        assertEquals(player.getCurrentPosition(), new Position(0, 0));

        newOut.reset();

        player.enter(normalWorld);
        assertEquals(player.getCurrentPosition(), new Position(0, 0));
        ObjectComposite normalWorldObject = normalWorld.getObject("tree");
        normalWorldObject.addStatus(new InteractableStatus(normalWorldObject));
        normalWorldObject.addStatus(new ObstacleStatus(normalWorldObject));
        player.moveForward();
        player.moveBackward();
        player.moveBackward();
        assertEquals("tree:treeeee\n", newOut.toString());
        assertEquals(player.getCurrentPosition(), new Position(0, 0));

    }

    @Test
    public void ObstacleObject() {
        Player player = new Player(strangeWorld, new ControlSensitivityHigh());
        ObjectComposite strangeWorldObject = strangeWorld.getObject("stone");
        strangeWorldObject.addStatus(new ObstacleStatus(strangeWorldObject));
        player.moveForward();
        assertEquals("", newOut.toString());
        assertEquals(player.getCurrentPosition(), new Position(0, 0));

        newOut.reset();

        player.enter(normalWorld);
        assertEquals(player.getCurrentPosition(), new Position(0, 0));
        ObjectComposite normalWorldObject = normalWorld.getObject("tree");
        normalWorldObject.addStatus(new ObstacleStatus(normalWorldObject));
        player.moveForward();
        player.moveBackward();
        player.moveBackward();
        assertEquals("", newOut.toString());
        assertEquals(player.getCurrentPosition(), new Position(0, 0));

    }

    @Test
    public void DontWalkHereObject() {
        Player player = new Player(strangeWorld, new ControlSensitivityHigh());
        ObjectComposite strangeWorldObject = strangeWorld.getObject("stone");
        strangeWorldObject.addStatus(new InteractableStatus(strangeWorldObject));
        strangeWorldObject.addStatus(new ObstacleStatus(strangeWorldObject));
        player.moveRight();
        assertEquals("", newOut.toString());
        assertEquals(player.getCurrentPosition(), new Position(20, 0));

        newOut.reset();

        player.enter(normalWorld);
        assertEquals(player.getCurrentPosition(), new Position(0, 0));
        ObjectComposite normalWorldObject = normalWorld.getObject("tree");
        normalWorldObject.addStatus(new InteractableStatus(normalWorldObject));
        normalWorldObject.addStatus(new ObstacleStatus(normalWorldObject));
        player.moveForward();
        assertEquals("", newOut.toString());
        assertEquals(player.getCurrentPosition(), new Position(0, 20));

    }
}
