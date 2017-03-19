package domainModel;

/**
 * Created by root on 3/16/17.
 */
public abstract class AbstractSmell {
    private boolean light;
    private boolean rotten;

    public AbstractSmell(boolean light, boolean rotten) {
        this.light = light;
        this.rotten = rotten;
    }

    public void setLight(boolean light) {
        this.light = light;
    }

    public void setRotten(boolean rotten) {
        this.rotten = rotten;
    }

    public boolean isLight() {
        return light;
    }

    public boolean isRotten() {
        return rotten;
    }

    public abstract AbstractSmell getID();
}
