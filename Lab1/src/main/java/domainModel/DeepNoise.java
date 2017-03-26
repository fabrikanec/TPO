package domainModel;

/**
 * Created by root on 3/16/17.
 */
public class DeepNoise {
    private Arthur arthur;

    public DeepNoise(Arthur arthur) {
        this.arthur = arthur;

        if (arthur != null && !arthur.isSitting()) {
            System.out.println("какой-то низкий гул не давал ему собраться с мыслями.");
        }
    }

    public Arthur getArthur() {
        return arthur;
    }

    public void setArthur(Arthur arthur) {
        this.arthur = arthur;
    }
}
