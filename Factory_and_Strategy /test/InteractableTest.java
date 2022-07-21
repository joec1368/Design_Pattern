import dp.*;
import nonused.Accessory;
import nonused.PoliteWorld;
import nonused.RudeWorld;
import observer.Observe;
import observer.Observer;
import observer.Polite;
import observer.Rude;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class InteractableTest {

    @ParameterizedTest
    @EnumSource(World.Type.class)
    public void TestStoneHarden(World.Type type) {
        World world = new World(type);
        assertEquals(world.getStone().getSolidity(), 5);
        world.getStone().harden();
        assertEquals(world.getStone().getSolidity(), 6);
        world.getStone().harden();
        assertEquals(world.getStone().getSolidity(), 7);
    }

    @ParameterizedTest
    @EnumSource(World.Type.class)
    public void TestTreeGrow(World.Type type) {
        World world = new World(type);
        assertEquals(world.getTree().getHeight(), 10);
        world.getTree().waterIt();
        assertEquals(world.getTree().getHeight(), 11);
        world.getTree().waterIt();
        assertEquals(world.getTree().getHeight(), 12);
    }

    @ParameterizedTest
    @EnumSource(World.Type.class)
    public void TestTreeGrow_Accessory() {
        Accessory world = new PoliteWorld();
        assertEquals(world.tree_GetHeight(), 10);
        world.tree_WaterIt();
        assertEquals(world.tree_GetHeight(), 11);
        world.tree_WaterIt();
        assertEquals(world.tree_GetHeight(), 12);
        world = new RudeWorld();
        assertEquals(world.tree_GetHeight(), 10);
        world.tree_WaterIt();
        assertEquals(world.tree_GetHeight(), 11);
        world.tree_WaterIt();
        assertEquals(world.tree_GetHeight(), 12);
    }

    @ParameterizedTest
    @EnumSource(World.Type.class)
    public void TestStoneHarden_Accessory() {
        Accessory world = new PoliteWorld();
        assertEquals(world.stone_GetSolidity(), 5);
        world.stone_Harden();
        assertEquals(world.stone_GetSolidity(), 6);
        world.stone_Harden();
        assertEquals(world.stone_GetSolidity(), 7);
        world = new RudeWorld();
        assertEquals(world.stone_GetSolidity(), 5);
        world.stone_Harden();
        assertEquals(world.stone_GetSolidity(), 6);
        world.stone_Harden();
        assertEquals(world.stone_GetSolidity(), 7);
    }

    @ParameterizedTest
    @EnumSource(World.Type.class)
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
    @EnumSource(World.Type.class)
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


}
