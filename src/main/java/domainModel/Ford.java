package domainModel;

/**
 * Created by root on 3/16/17.
 */
public class Ford {
    private TerrifyingShadows terrifyingShadows;

    public void seekTheSwitch() {
        lightUpTheMatch();
    }

    public void lightUpTheMatch() {
        System.out.println("Форд зажег еще одну спичку, чтобы найти выключатель.");
        terrifyingShadows = new TerrifyingShadows();
        terrifyingShadows.setLight(true);
        terrifyingShadows.swayAndRunArround();
    }

    public TerrifyingShadows getTerrifyingShadows() {
        return terrifyingShadows;
    }
}
