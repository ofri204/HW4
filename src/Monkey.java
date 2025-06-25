/**
 * A class that represents a Monkey, which is a type of Animal
 * with a fixed dominance level of 3.
 **/
public class Monkey extends Animal {
    private static final int DEFAULT_DOMINANCE_LEVEL =3;

    public Monkey() {
        super(Monkey.DEFAULT_DOMINANCE_LEVEL);
    }
}
