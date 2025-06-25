/**
 * A class that represents a Snake, which is a type of Animal
 * with a fixed dominance level of 2.
 **/
public class Snake extends Animal {
    private static final int DEFAULT_DOMINANCE_LEVEL = 2;

    public Snake() {
        super(Snake.DEFAULT_DOMINANCE_LEVEL);
    }
}
