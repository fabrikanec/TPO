package domainModel;

/**
 * Created by root on 3/16/17.
 */
public class Arthur {

    private TerrifyingShadows terrifyingShadows;
    private Environment env;
    private boolean isSitting = true;

    public Arthur() {
        System.out.print("Aртур ");
    }

    public void standUp() {
        isSitting = false;
        System.out.print("с трудом встал на ноги");
    }

    public void palp() {
        System.out.println(" и ощупал себя.");
    }

    public void putTogether() {
        env = new Environment();
        env.setSmellingAir(new SmellingAir(this));
        env.setDeepNoise(new DeepNoise(this));
        for (;;) {
            if (env.getDeepNoise() != null) { // TODO: 3/20/17 22222
                break;
            }
        }

    }

    public void setTerrifyingShadows(TerrifyingShadows terrifyingShadows) {
        if (this.terrifyingShadows == null) {
            System.out.println("Ему казалось, что все вокруг него кишит зловещими нечеловеческими фигурами;");
        }
        this.terrifyingShadows = terrifyingShadows;
    }

    public Environment getEnv() {
        return env;
    }

    public TerrifyingShadows getTerrifyingShadows() {
        return terrifyingShadows;
    }

    public boolean isSitting() {
        return isSitting; // TODO: 3/20/17 111111
    }
}
