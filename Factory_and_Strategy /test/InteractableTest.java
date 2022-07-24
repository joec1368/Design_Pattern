import Sense.ControlSensibilityHigh;
import Sense.ControlSensibilityLow;
import dp.*;
import observer.Observe;
import observer.Observer;
import observer.Polite;
import observer.Rude;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@ExtendWith(MockitoExtension.class)
public class InteractableTest {

    @ParameterizedTest
    @MethodSource("worldType")
    public void TestStoneHarden() {
        World world = new PoliteWorld();
        assertEquals(world.getStone().getSolidity(), 5);
        world.getStone().harden();
        assertEquals(world.getStone().getSolidity(), 6);
        world.getStone().harden();
        assertEquals(world.getStone().getSolidity(), 7);
    }

    @ParameterizedTest
    @MethodSource("worldType")
    public void TestTreeGrow(World world) {
        assertEquals(world.getTree().getHeight(), 10);
        world.getTree().waterIt();
        assertEquals(world.getTree().getHeight(), 11);
        world.getTree().waterIt();
        assertEquals(world.getTree().getHeight(), 12);
    }

    @ParameterizedTest
    @MethodSource("worldType")
    public void TestHarder() {
        Observe observer = new Observer();
        observer.add("Polite",new Polite());
        observer.add("Rude",new Rude());
        assertEquals(observer.decideHardToShow("Polite"), 5);
        observer.decideHarder("Polite");
        assertEquals(observer.decideHardToShow("Polite"), 6);
        observer.decideHarder("Polite");
        assertEquals(observer.decideHardToShow("Polite"), 7);
        observer.decideHarder("Polite");
        assertEquals(observer.decideHardToShow("Polite"), 8);
        assertEquals(observer.decideHardToShow("Rude"), 5);
        observer.decideHarder("Rude");
        assertEquals(observer.decideHardToShow("Rude"), 6);
        observer.decideHarder("Rude");
        assertEquals(observer.decideHardToShow("Rude"), 7);
        observer.decideHarder("Rude");
        assertEquals(observer.decideHardToShow("Rude"), 8);
    }

    @ParameterizedTest
    @MethodSource("worldType")
    public void TestHigher() {
        Observe observer = new Observer();
        observer.add("Polite",new Polite());
        observer.add("Rude",new Rude());
        assertEquals(observer.decideHeightToShow("Polite"), 10);
        observer.decideHigher("Polite");
        assertEquals(observer.decideHeightToShow("Polite"), 11);
        observer.decideHigher("Polite");
        assertEquals(observer.decideHeightToShow("Polite"), 12);
        observer.decideHigher("Polite");
        assertEquals(observer.decideHeightToShow("Polite"), 13);

        assertEquals(observer.decideHeightToShow("Rude"), 10);
        observer.decideHigher("Rude");
        assertEquals(observer.decideHeightToShow("Rude"), 11);
        observer.decideHigher("Rude");
        assertEquals(observer.decideHeightToShow("Rude"), 12);
        observer.decideHigher("Rude");
        assertEquals(observer.decideHeightToShow("Rude"), 13);
    }

    private static Stream<Arguments> worldType() {
        return Stream.of(
                arguments( new dp.PoliteWorld()),
                arguments( new dp.RudeWorld())
        );
    }

}
