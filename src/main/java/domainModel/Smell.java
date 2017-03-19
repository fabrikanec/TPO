package domainModel;

import com.sun.istack.internal.Nullable;

/**
 * Created by root on 3/16/17.
 */
public class Smell extends AbstractSmell {

    public Smell(boolean light, boolean rotten) {
        super(light, rotten);
    }

    @Override
    public void setLight(boolean light) {
        super.setLight(light);
    }

    @Override
    public void setRotten(boolean rotten) {
        super.setRotten(rotten);
    }

    @Override
    public boolean isLight() {
        return super.isLight();
    }

    @Override
    public boolean isRotten() {
        return super.isRotten();
    }

    @Nullable
    public Smell getID() {
        return null;
    }
}
