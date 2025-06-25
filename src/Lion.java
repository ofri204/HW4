/**
 * A class that represents a Lion, which is a type of Animal
 * with a fixed dominance level of 4.
 **/
public class Lion extends Animal {
    private static final int DEFAULT_DOMINANCE_LEVEL = 4;
    
    public Lion() {
        super(Lion.DEFAULT_DOMINANCE_LEVEL);
    }
}
