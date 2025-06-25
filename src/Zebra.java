/**
 * A class that represents a Zebra, which is a type of Animal
 * with a fixed dominance level of 1.
 **/
public class Zebra extends Animal {
    private static final int DEFAULT_DOMINANCE_LEVEL =1;

    public Zebra(){
        super(Zebra.DEFAULT_DOMINANCE_LEVEL);
    }
}
