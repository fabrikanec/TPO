import domain.*;
/**
 * Created by root on 3/19/17.
 */
public class Main {
    public static void main(String[] args) {
        Ford ford = new Ford();
        ford.lightUpTheMatch();
        Arthur arthur = new Arthur();
        arthur.standUp();
        arthur.palp();
        TerrifyingShadows terrifyingShadows = ford.getTerrifyingShadows();
        arthur.setTerrifyingShadows(terrifyingShadows);
        arthur.putTogether();
    }
}