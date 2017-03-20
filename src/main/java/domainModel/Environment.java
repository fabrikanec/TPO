package domainModel;

/**
 * Created by root on 3/19/17.
 */
public class Environment {
    private SmellingAir air;
    private DeepNoise deepNoise;

    public Environment() {
    }

    public SmellingAir getSmellingAir() {
        return air;
    }

    public DeepNoise getDeepNoise() {
        return deepNoise;
    }

    public void setSmellingAir(SmellingAir air) {
        this.air = air;
    }

    public void setDeepNoise(DeepNoise deepNoise) {
        this.deepNoise = deepNoise;
    }
}
