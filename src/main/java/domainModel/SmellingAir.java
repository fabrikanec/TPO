package domainModel;

import java.util.stream.Stream;

/**
 * Created by root on 3/16/17.
 */
public class SmellingAir {
    Stream<AbstractSmell> smells;

    private Arthur arthur;

    public SmellingAir(Arthur arthur) {
        this.arthur = arthur;

        if (arthur != null && !arthur.isSitting()) {
            smells = Stream.generate(() -> new Smell(true, true));
            System.out.println("воздух был полон раздражавших его легкие прелых запахов, " +
                    "которые никак не идентифицировались; ");
        }
    }

    public Stream<AbstractSmell> getSmells() {
        return smells;
    }

    public void setArthur(Arthur arthur) {
        this.arthur = arthur;
    }

    public Arthur getArthur() {
        return arthur;
    }
}
