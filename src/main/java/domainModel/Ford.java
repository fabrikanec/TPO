package domainModel;

/**
 * Created by root on 3/16/17.
 */
public class Ford {
    private TerrifyingShadows terrifyingShadows;
    private boolean hasSwitch = false;
    public void seekTheSwitch() throws IllegalStateException {
        if (!hasSwitch) {
            lightUpTheMatch();
        } else {
            throw new IllegalStateException();
        }
    }

    public void lightUpTheMatch() {
        System.out.println("Форд зажег еще одну спичку, чтобы найти выключатель.");
        hasSwitch = true; // TODO: 3/20/17 3333333
        terrifyingShadows = new TerrifyingShadows();
        terrifyingShadows.setLight(true);
        terrifyingShadows.swayAndRunArround();
    }

    public TerrifyingShadows getTerrifyingShadows() {
        return terrifyingShadows;
    }

    public boolean hasSwith() {
        return hasSwitch;
    }
}
