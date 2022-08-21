import dp.*;
import dp.Composite.*;
import dp.Composite.Object;
import dp.display.Display;
import dp.interactable.Stone;
import dp.interactable.Tree;
import dp.sensitivity.ControlSensitivity;
import dp.sensitivity.ControlSensitivityHigh;
import dp.sensitivity.ControlSensitivityLow;
import dp.world.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT) //we have to use this to stub in @BeforeEach
public class PlayerTest {
    @Mock
    World world;
    @Mock
    Display display;
    @Mock
    Tree tree;
    @Mock
    Stone stone;


    private PrintStream oldOut;
    private ByteArrayOutputStream newOut;



    @BeforeEach
    public void setup() {
        when(world.getTree()).thenReturn(tree);
        when(world.getStone()).thenReturn(stone);
            oldOut = System.out;
            newOut = new ByteArrayOutputStream();
            System.setOut(new PrintStream(newOut));
        }


    @ParameterizedTest
    @MethodSource("sensitivities")
    public void TestInteractWithTree(ControlSensitivity sensitivity) {
        Player player = new Player(world, sensitivity);
        player.interactWithTree(display);
        verify(world).getTree();
        verify(tree).interact(display);
    }

    @ParameterizedTest
    @MethodSource("sensitivities")
    public void TestInteractWithStone(ControlSensitivity sensitivity) {
        Player player = new Player(world, sensitivity);
        player.interactWithStone(display);
        verify(world).getStone();
        verify(stone).interact(display);
    }

    private static Stream<Arguments> sensitivities() {
        return Stream.of(
                arguments(new ControlSensitivityHigh()),
                arguments(new ControlSensitivityLow())
        );
    }

    @ParameterizedTest
    @MethodSource("worldsAndSensitivities")
    public void TestPlayerStartAtOrigin(World world, ControlSensitivity sensitivity) {
        Player player = new Player(world, sensitivity);
        assertEquals(player.getCurrentPosition(), new Position(0, 0));
    }

    @Test
    public void TestPlayerSensitivityLOW() {
        Player player = new Player(world, new ControlSensitivityLow());
        player.moveForward();
        assertEquals(player.getCurrentPosition(), new Position(0, 5));
        player.moveRight();
        assertEquals(player.getCurrentPosition(), new Position(5, 5));
    }

    @Test
    public void TestPlayerSensitivityHIGH() {
        Player player = new Player(world, new ControlSensitivityHigh());
        player.moveForward();
        assertEquals(player.getCurrentPosition(), new Position(0, 20));
        player.moveRight();
        assertEquals(player.getCurrentPosition(), new Position(20, 20));
    }

    @Test
    public void SensitivityHIGH() {
        Player player = new Player(world, new ControlSensitivityHigh());
        Component wholeWorld = new WorldComposite("wholeWorld");
        wholeWorld.addObject(new WorldComposite("strange"));
        Component strangeWorld = wholeWorld.getWorld("strange");
        strangeWorld.addObject(new Object(0,20,"a","smile"));
        Component object = strangeWorld.getObject(new Position(0,20));
        object.addStatue(new InteractableStatus((Object) object));
       // object.addStatue(new ObstacleStatus((Object) object));
        player.moveForward();
        strangeWorld.checkComponent(player);
        assertEquals("a:smile\n", newOut.toString());
        assertEquals(player.getCurrentPosition(), new Position(0, 20));

    }

    @ParameterizedTest
    @MethodSource("worldsAndSensitivities")
    public void TestPlayerChangeWorld(World oldWorld, ControlSensitivity sensitivity) {
        Player player = new Player(oldWorld, sensitivity);
        player.moveRight();
        player.enter(world);
        assertEquals(player.getCurrentPosition(), new Position(0, 0));
        player.interactWithStone(display);
        verify(world).getStone();
    }

    private static Stream<Arguments> worldsAndSensitivities() {
        return Stream.of(
                arguments(new RudeWorld(), new ControlSensitivityLow()),
                arguments(new RudeWorld(), new ControlSensitivityHigh()),
                arguments(new PoliteWorld(), new ControlSensitivityLow()),
                arguments(new PoliteWorld(), new ControlSensitivityHigh())
        );
    }

    @ParameterizedTest
    @MethodSource("worlds")
    public void TestPlayerChangeSensitivity(World world) {
        Player player = new Player(world, new ControlSensitivityLow());
        player.moveForward();
        assertEquals(player.getCurrentPosition(), new Position(0, 5));
        player.changeSensitivity(new ControlSensitivityHigh());
        player.moveRight();
        assertEquals(player.getCurrentPosition(), new Position(20, 5));
    }

    private static Stream<Arguments> worlds() {
        return Stream.of(
                arguments(new PoliteWorld()),
                arguments(new RudeWorld())
        );
    }
}
