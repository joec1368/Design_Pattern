import dp.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
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
    @EnumSource(Player.ControlSensitivity.class)
    public void TestInteractWithTree(Player.ControlSensitivity sensitivity) {
        Player player = new Player(world, sensitivity);
        player.interactWithTree(display);
        verify(world).getTree();
        verify(tree).interact(display);
    }

    @ParameterizedTest
    @EnumSource(Player.ControlSensitivity.class)
    public void TestInteractWithStone(Player.ControlSensitivity sensitivity) {
        Player player = new Player(world, sensitivity);
        player.interactWithStone(display);
        verify(world).getStone();
        verify(stone).interact(display);
    }

    @ParameterizedTest
    @MethodSource("wordTypeAndSensitivity")
    public void TestPlayerStartAtOrigin(World.Type worldType, Player.ControlSensitivity sensitivity) {
        Player player = new Player(new World(worldType), sensitivity);
        assertEquals(player.getCurrentPosition(), new Position(0, 0));
    }

    @Test
    public void TestPlayerSensitivityLOW() {
        Player player = new Player(world, Player.ControlSensitivity.LOW);
        player.moveForward();
        assertEquals(player.getCurrentPosition(), new Position(0, 5));
        player.moveRight();
        assertEquals(player.getCurrentPosition(), new Position(5, 5));
    }

    @Test
    public void TestPlayerSensitivityHIGH() {
        Player player = new Player(world, Player.ControlSensitivity.HIGH);
        player.moveForward();
        assertEquals(player.getCurrentPosition(), new Position(0, 50));
        player.moveRight();
        assertEquals(player.getCurrentPosition(), new Position(50, 50));
    }

    @ParameterizedTest
    @MethodSource("wordTypeAndSensitivity")
    public void TestPlayerChangeWorld(World.Type worldType, Player.ControlSensitivity sensitivity) {
        Player player = new Player(new World(worldType), sensitivity);
        player.moveRight();
        player.enter(world);
        assertEquals(player.getCurrentPosition(), new Position(0, 0));
        player.interactWithStone(display);
        verify(world).getStone();
    }

    private static Stream<Arguments> wordTypeAndSensitivity() {
        return Stream.of(
                arguments(World.Type.Rude, Player.ControlSensitivity.LOW),
                arguments(World.Type.Rude, Player.ControlSensitivity.HIGH),
                arguments(World.Type.Polite, Player.ControlSensitivity.LOW),
                arguments(World.Type.Polite, Player.ControlSensitivity.HIGH)
        );
    }

    @ParameterizedTest
    @EnumSource(World.Type.class)
    public void TestPlayerChangeSensitivity(World.Type type) {
        Player player = new Player(new World(type), Player.ControlSensitivity.LOW);
        player.moveForward();
        assertEquals(player.getCurrentPosition(), new Position(0, 5));
        player.changeSensitivity(Player.ControlSensitivity.HIGH);
        player.moveRight();
        assertEquals(player.getCurrentPosition(), new Position(50, 5));
    }
}
