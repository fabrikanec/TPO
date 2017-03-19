package domainModel;

/**
 * Created by root on 3/16/17.
 */
public class TerrifyingShadows {
    private boolean light;
    private Arthur arthur;

    public void setLight(boolean light) {
        this.light = light;
    }

    public boolean isLight() {
        return light;
    }

    public void swayAndRunArround() {
        if (isLight()) {
            System.out.print("Снова закачались и заметались чудовищные тени. ");
            arthurAction();
        }
    }

    public void arthurAction() {
     this.arthur = new Arthur();
     arthur.standUp();
     arthur.palp();
     arthur.setTerrifyingShadows(this);
     arthur.putTogether();
    }

    public Arthur getArthur() {
        return arthur;
    }
}
