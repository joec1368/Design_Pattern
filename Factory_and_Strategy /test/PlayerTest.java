import Sense.ControlSensibility;
import Sense.ControlSensibilityHigh;
import Sense.ControlSensibilityLow;
import dp.*;
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

    @BeforeEach
    public void setup() {
        when(world.getTree()).thenReturn(tree);
        when(world.getStone()).thenReturn(stone);
    }

    @ParameterizedTest
    @MethodSource("wordSensitivity")
    public void TestInteractWithTree(ControlSensibility sensibility) {
        Player player = new Player(world, sensibility);
        player.interactWithTree(display);
        verify(world).getTree();
        verify(tree).interact(display);
    }

    @ParameterizedTest
    @MethodSource("wordSensitivity")
    public void TestInteractWithStone(ControlSensibility sensibility) {
        Player player = new Player(world, sensibility);
        player.interactWithStone(display);
        verify(world).getStone();
        verify(stone).interact(display);
    }

    @ParameterizedTest
    @MethodSource("wordTypeAndSensitivity")
    public void TestPlayerStartAtOrigin(World world, ControlSensibility sensitivity) {
        Player player = new Player(world, new ControlSensibilityLow());
        assertEquals(player.getCurrentPosition(), new Position(0, 0));
    }

    @ParameterizedTest
    @MethodSource("worldType")
    public void TestPlayerSensitivityLOW(World world) {
        Player player = new Player(world, new ControlSensibilityLow());
        player.moveForward();
        assertEquals(player.getCurrentPosition(), new Position(0, 5));
        player.moveRight();
        assertEquals(player.getCurrentPosition(), new Position(5, 5));
    }

    @Test
    public void TestPlayerSensitivityHIGH() {
        Player player = new Player(world, new ControlSensibilityHigh());
        player.moveForward();
        assertEquals(player.getCurrentPosition(), new Position(0, 50));
        player.moveRight();
        assertEquals(player.getCurrentPosition(), new Position(50, 50));
    }

    @ParameterizedTest
    @MethodSource("worldType")
    public void TestPlayerChangeWorld(World world) {
        Player player = new Player(world,new ControlSensibilityLow());
        player.moveRight();
        player.enter(this.world);
        assertEquals(player.getCurrentPosition(), new Position(0, 0));
        player.interactWithStone(display);
        verify(this.world).getStone();
    }

    private static Stream<Arguments> wordTypeAndSensitivity() {
        return Stream.of(
                arguments(new RudeWorld(), new ControlSensibilityLow()),
                arguments(new RudeWorld(), new ControlSensibilityHigh()),
                arguments(new PoliteWorld(), new ControlSensibilityLow()),
                arguments(new PoliteWorld(), new ControlSensibilityHigh())
        );
    }
    private static Stream<Arguments> wordSensitivity() {
        return Stream.of(
                arguments( new ControlSensibilityLow()),
                arguments( new ControlSensibilityHigh()),
                arguments( new ControlSensibilityLow()),
                arguments( new ControlSensibilityHigh())
        );
    }

    @ParameterizedTest
    @MethodSource("worldType")
    public void TestPlayerChangeSensitivity(World world) {
        Player player = new Player(world, new ControlSensibilityLow());
        player.moveForward();
        assertEquals(player.getCurrentPosition(), new Position(0, 5));
        player.changeSensitivity(new ControlSensibilityHigh());
        player.moveRight();
        assertEquals(player.getCurrentPosition(), new Position(50, 5));
    }

    private static Stream<Arguments> worldType() {
        return Stream.of(
                arguments( new PoliteWorld()),
                arguments( new RudeWorld())
        );
    }
}
