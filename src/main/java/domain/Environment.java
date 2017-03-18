package domain;

/**
 * Created by root on 3/19/17.
 */
public class Environment {
    private Air air;
    private DeepNoise deepNoise;

    public Environment() {
        air = new Air();
        deepNoise = new DeepNoise();
    }

    public Air getAir() {
        return air;
    }

    public DeepNoise getDeepNoise() {
        return deepNoise;
    }
}
