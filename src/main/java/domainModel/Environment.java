package domainModel;

/**
 * Created by root on 3/19/17.
 */
public class Environment {
    private Air air;
    private DeepNoise deepNoise;

    public Environment() {
    }

    public Air getAir() {
        return air;
    }

    public DeepNoise getDeepNoise() {
        return deepNoise;
    }

    public void setAir(Air air) {
        this.air = air;
    }

    public void setDeepNoise(DeepNoise deepNoise) {
        this.deepNoise = deepNoise;
    }
}
