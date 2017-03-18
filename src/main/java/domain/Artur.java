package domain;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * Created by root on 3/16/17.
 */
public class Artur {
    private TerrifyingShadows terrifyingShadows;
    public Artur() {
        System.out.print("Aртур");
    }

    public void standUp() {
        System.out.print("с трудом встал на ноги");
    }

    public void palp() {
        System.out.print(" и ощупал себя");
    }

    public void putTogether() {

    }

    public void setTerrifyingShadows(TerrifyingShadows terrifyingShadows) {
        if (terrifyingShadows == null) {
            System.out.println("Ему казалось, что все вокруг него кишит зловещими нечеловеческими фигурами;");
        }
        this.terrifyingShadows = terrifyingShadows;
    }
}