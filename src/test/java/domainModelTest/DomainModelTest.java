package domainModelTest;

import org.junit.Before;
import org.junit.Test;
import domainModel.*;
import static org.junit.Assert.*;


/**
 * Created by root on 3/16/17.
 */
public class DomainModelTest {

    private Ford ford;
    private Arthur arthur;
    private Environment environment;

    @Before
    public void beforeClass() {
        Ford ford = new Ford();
        ford.seekTheSwitch();
        Arthur arthur = new Arthur(true);
        arthur.standUp();
        arthur.palp();
        TerrifyingShadows terrifyingShadows = ford.getTerrifyingShadows();
        arthur.setTerrifyingShadows(terrifyingShadows);
        arthur.putTogether();
    }

    @Test
    public void testWhosArthurLookingAt() {
        assertEquals(arthur.getEyes().getLookingAt(), ford);
    }

    @Test
    public void testArthurIsNotYetConfident() {
        assertFalse(arthur.isConfident());
    }

    @Test
    public void testArthurBecomesConfident() {
        environment.addEnvironmentElement(new CerealPacket());
        assertTrue(arthur.isConfident());
    }

    @Test
    public void testCarealPacketSimpe() {
        assertTrue(new CerealPacket() instanceof Simple);
    }

    @Test
    public void testCarealPacketFamiliar() {
        assertTrue(new CerealPacket() instanceof Familiar);
    }

    @Test
    public void testArthursEyesBlink() {
        assertTrue(arthur.getEyes().isBlinking());
    }

    @Test
    public void testFishSwimming() {
        assertTrue(((Bottle) ford.getHand().getHoldable()).getFish().isSwimming());
    }

    @Test
    public void testFishShining() {
        assertTrue(((Bottle) ford.getHand().getHoldable()).getFish().isShining());
    }

    @Test
    public void testFordsFishIsLittle() {
        assertEquals(((Bottle) ford.getHand().getHoldable()).getFish().getSize(), FishSize.SMALL);

    }

    @Test
    public void testFordsFishIsYellow() {
        assertEquals(((Bottle) ford.getHand().getHoldable()).getFish().getColor(), FishColor.YELLOW);

    }

    @Test
    public void testBottleMaterial() {
        assertEquals(((Bottle) ford.getHand().getHoldable()).getBottleMaterial(), BottleMaterial.GLASS);
    }

    @Test
    public void testFordHandInit() {
        assertNotNull("Ford has no hand!", ford.getHand());
    }

    @Test
    public void testArthurEyesInit() {
        assertNotNull("Arthur has no eyes!", arthur.getEyes());
    }

    @Test
    public void testFordBottleInit() {
        assertNotNull("Ford has no bottle in hand!", ford.getHand().getHoldable());
    }
}
