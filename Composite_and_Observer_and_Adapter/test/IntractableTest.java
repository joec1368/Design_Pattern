import dp.world.PoliteWorld;
import dp.world.RudeWorld;
import dp.world.World;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@ExtendWith(MockitoExtension.class)
public class IntractableTest {

    @ParameterizedTest
    @MethodSource("worlds")
    public void TestStoneHarden(World world) {
        assertEquals(world.getStone().getSolidity(), 5);
        world.getStone().harden();
        assertEquals(world.getStone().getSolidity(), 6);
        world.getStone().harden();
        assertEquals(world.getStone().getSolidity(), 7);
    }

    @ParameterizedTest
    @MethodSource("worlds")
    public void TestTreeGrow(World world) {
        assertEquals(world.getTree().getHeight(), 10);
        world.getTree().waterIt();
        assertEquals(world.getTree().getHeight(), 11);
        world.getTree().waterIt();
        assertEquals(world.getTree().getHeight(), 12);
    }

    private static Stream<Arguments> worlds() {
        return Stream.of(
                arguments(new RudeWorld()),
                arguments(new PoliteWorld())
        );
    }
}
