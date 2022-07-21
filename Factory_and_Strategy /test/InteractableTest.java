import dp.*;
import nonused.Accessory;
import nonused.PoliteWorld;
import nonused.RudeWorld;
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
}
