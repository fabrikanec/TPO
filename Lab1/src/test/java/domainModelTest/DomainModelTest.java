package domainModelTest;

import org.junit.Before;
import org.junit.Test;
import domainModel.*;
import sun.util.locale.StringTokenIterator;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.*;


/**
 * Created by root on 3/16/17.
 */
public class DomainModelTest {
    private Ford ford;
    private TerrifyingShadows shadows;
    private Arthur arthur;

    @Before
    public void beforeClass() {
        ford = new Ford();
        ford.seekTheSwitch();
        shadows = ford.getTerrifyingShadows();
        arthur = shadows.getArthur();
        try {
            File testLog = new File("testLog");
            System.setOut(new PrintStream(testLog));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test(expected = IllegalStateException.class)
    public void testHasSwitchAndTryFindMore() throws IllegalStateException {
        ford.seekTheSwitch();
    }

    @Test
    public void testAppearanceShadowsBeforeLight() {
        Ford ford = new Ford();
        TerrifyingShadows shadows = ford.getTerrifyingShadows();
        assertNull(shadows);

    }

    @Test
    public void testAppearanceShadowsAfterLight() {
        Ford ford = new Ford();
        ford.lightUpTheMatch();
        TerrifyingShadows shadows = ford.getTerrifyingShadows();
        assertEquals(shadows.isLight(), true);

    }

    @Test
    public void testArturSittingBeforeShadowAppearance() {
        Arthur arthur = new Arthur();
        assertEquals(arthur.isSitting(), true);
    }

    @Test
    public void testArturStandingAfterShadowAppearance() {
        Ford ford = new Ford();
        ford.seekTheSwitch();
        TerrifyingShadows shadows = ford.getTerrifyingShadows();
        Arthur arthur = shadows.getArthur();
        assertEquals(arthur.isSitting(), false);
    }

    @Test
    public void testEvilShadowsBeforeShadowAppearance() {
        Arthur arthur = new Arthur();
        TerrifyingShadows shadows = arthur.getTerrifyingShadows();
        assertNull(shadows);
    }

    @Test
    public void testEvilShadowsAfterShadowAppearance() {
        ford = new Ford();
        ford.seekTheSwitch();
        shadows = ford.getTerrifyingShadows();
        arthur = shadows.getArthur();
        assertNotNull(arthur.getTerrifyingShadows());
    }

    @Test
    public void testEnvironmentBeforeEvilShadows() {
        ford = new Ford();
        arthur = new Arthur();
        assertNull(arthur.getEnv());
    }

    @Test
    public void testSmellingAirAfterEvilShadows() {
        ford = new Ford();
        ford.seekTheSwitch();
        shadows = ford.getTerrifyingShadows();
        arthur = shadows.getArthur();
        assertNotNull(arthur.getEnv().getSmellingAir());
    }

    @Test
    public void testIdentSmell() {
        final int limit = 43;
        ford = new Ford();
        ford.seekTheSwitch();
        shadows = ford.getTerrifyingShadows();
        arthur = shadows.getArthur();
        arthur.getEnv().getSmellingAir().getSmells().limit(limit).forEach(x -> assertNull(x.getID()));
    }

    @Test
    public void testDeepNoizeAfterEvilShadows() {
        ford = new Ford();
        ford.seekTheSwitch();
        shadows = ford.getTerrifyingShadows();
        arthur = shadows.getArthur();
        assertNotNull(arthur.getEnv().getDeepNoise());

    }
}
