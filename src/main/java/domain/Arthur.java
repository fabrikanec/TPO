package domain;

/**
 * Created by root on 3/16/17.
 */
public class Arthur {
    private TerrifyingShadows terrifyingShadows;
    Environment env;

    public Arthur() {
        System.out.print("Aртур ");
    }

    public void standUp() {
        System.out.print("с трудом встал на ноги");
    }

    public void palp() {
        System.out.println(" и ощупал себя.");
    }

    public void putTogether() {
        env = new Environment();
        for (;;) {
            if (env.getDeepNoise() != null) {
                continue;
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
}