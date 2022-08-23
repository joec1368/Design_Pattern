import dp.*;
import dp.composite.*;
import dp.composite.ObjectComposite;
import dp.composite.status.ObstacleStatus;
import dp.composite.status.Stone;
import dp.composite.status.Tree;
import dp.sensitivity.ControlSensitivityHigh;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT) //we have to use this to stub in @BeforeEach

public class InteractableAndObstacle {
    private PrintStream oldOut;
    private ByteArrayOutputStream newOut;
    private Component wholeWorld;
    private WorldComposite strangeWorld;
    private WorldComposite normalWorld;
    private ObjectComposite strangeWorldObject;
    private ObjectComposite normalWorldObject;

    @BeforeEach
    public void setupWorld() {
        oldOut = System.out;
        newOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(newOut));

        //setting world
        wholeWorld = new WorldComposite("wholeWorld");
        strangeWorld = (WorldComposite) wholeWorld.addObject(new WorldComposite("strange"));
        normalWorld = (WorldComposite) wholeWorld.addObject(new WorldComposite("normal"));

        //setting strange world objects
        strangeWorldObject = (ObjectComposite) strangeWorld.addObject(new ObjectComposite(0,20,"stone"));

        //setting normal world objects
        normalWorldObject =(ObjectComposite) normalWorld.addObject(new ObjectComposite(0,-20,"tree"));
    }


    @Test
    public void interactalbeObject() {
        Player player = new Player(strangeWorld, new ControlSensitivityHigh());
        ObjectComposite strangeWorldObject = strangeWorld.getObject("stone");
        strangeWorldObject.addStatus(new Stone());
        player.moveForward();
        assertEquals("stone:stoneeeee\n", newOut.toString());
        assertEquals(player.getCurrentPosition(), new Position(0, 20));

        newOut.reset();

        player.enter(normalWorld);
        assertEquals(player.getCurrentPosition(), new Position(0, 0));
        ObjectComposite normalWorldObject = normalWorld.getObject("tree");
        normalWorldObject.addStatus(new Tree());
        player.moveForward();
        player.moveBackward();
        player.moveBackward();
        assertEquals("tree:treeeee\n", newOut.toString());
        assertEquals(player.getCurrentPosition(), new Position(0, -20));

    }

    @Test
    public void obstacleAndInteractableObject() {
        Player player = new Player(strangeWorld, new ControlSensitivityHigh());
        ObjectComposite strangeWorldObject = strangeWorld.getObject("stone");
        strangeWorldObject.addStatus(new Stone());
        strangeWorldObject.addStatus(new ObstacleStatus());
        player.moveForward();
        assertEquals("stone:stoneeeee\n", newOut.toString());
        assertEquals(player.getCurrentPosition(), new Position(0, 0));

        newOut.reset();

        player.enter(normalWorld);
        assertEquals(player.getCurrentPosition(), new Position(0, 0));
        ObjectComposite normalWorldObject = normalWorld.getObject("tree");
        normalWorldObject.addStatus(new Tree());
        normalWorldObject.addStatus(new ObstacleStatus());
        player.moveForward();
        player.moveBackward();
        player.moveBackward();
        assertEquals("tree:treeeee\n", newOut.toString());
        assertEquals(player.getCurrentPosition(), new Position(0, 0));

    }

    @Test
    public void obstacleObject() {
        Player player = new Player(strangeWorld, new ControlSensitivityHigh());
        ObjectComposite strangeWorldObject = strangeWorld.getObject("stone");
        strangeWorldObject.addStatus(new ObstacleStatus());
        player.moveForward();
        assertEquals("", newOut.toString());
        assertEquals(player.getCurrentPosition(), new Position(0, 0));

        newOut.reset();

        player.enter(normalWorld);
        assertEquals(player.getCurrentPosition(), new Position(0, 0));
        ObjectComposite normalWorldObject = normalWorld.getObject("tree");
        normalWorldObject.addStatus(new ObstacleStatus());
        player.moveForward();
        player.moveBackward();
        player.moveBackward();
        assertEquals("", newOut.toString());
        assertEquals(player.getCurrentPosition(), new Position(0, 0));

    }

    @Test
    public void dontWalkHereObject() {
        Player player = new Player(strangeWorld, new ControlSensitivityHigh());
        ObjectComposite strangeWorldObject = strangeWorld.getObject("stone");
        strangeWorldObject.addStatus(new Stone());
        strangeWorldObject.addStatus(new ObstacleStatus());
        player.moveRight();
        assertEquals("", newOut.toString());
        assertEquals(player.getCurrentPosition(), new Position(20, 0));

        newOut.reset();

        player.enter(normalWorld);
        assertEquals(player.getCurrentPosition(), new Position(0, 0));
        ObjectComposite normalWorldObject = normalWorld.getObject("tree");
        normalWorldObject.addStatus(new Stone());
        normalWorldObject.addStatus(new ObstacleStatus());
        player.moveForward();
        assertEquals("", newOut.toString());
        assertEquals(player.getCurrentPosition(), new Position(0, 20));
    }

    @Test
    public void stoneAndTree(){
        Stone Stone = (dp.composite.status.Stone) strangeWorldObject.addStatus(new Stone());
        Stone.harder();
        Stone.harder();
        assertEquals(Stone.getHarden(), 7);

        Tree Tree = (dp.composite.status.Tree) normalWorldObject.addStatus(new Tree());
        Tree.higher();
        assertEquals(Tree.getHeight(),6);
    }
}
