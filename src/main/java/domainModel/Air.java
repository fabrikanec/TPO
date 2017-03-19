package domainModel;

import java.util.stream.Stream;

/**
 * Created by root on 3/16/17.
 */
public class Air {
    Stream<AbstractSmell> smells;

    private Arthur arthur;

    public Air(Arthur arthur) {
        this.arthur = arthur;

        if (arthur != null && !arthur.isSitting()) {
            smells = Stream.generate(() -> null);
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
