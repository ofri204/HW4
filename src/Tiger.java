/**
 * A class that represents a Tiger, which is a type of Animal
 * with a fixed dominance level of 4.
 **/
public class Tiger extends Animal{
    private static final int DEFAULT_DOMINANCE_LEVEL = 4;

    public Tiger() {
        super(Tiger.DEFAULT_DOMINANCE_LEVEL);
    }
}
