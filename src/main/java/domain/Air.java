package domain;

import java.util.stream.Stream;

/**
 * Created by root on 3/16/17.
 */
public class Air {
    {
        System.out.println("воздух был полон раздражавших его легкие прелых запахов, " +
                           "которые никак не идентифицировались; ");
    }
    Stream<AbstractSmell> smells = Stream.generate(() -> null);

    public Stream<AbstractSmell> getSmells() {
        return smells;
    }
}
