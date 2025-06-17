/**
 * An abstract class representing an animal with a dominance level.
 * All animals that extend this class are comparable according to their dominance level
 * and cloneable.
 **/
public abstract class Animal implements Comparable<Animal> ,Cloneable {
    private final int dominanceLevel;

    /**
     * Constructs an animal with the specified dominance level.
     *
     * @param dominanceLevel the dominance level of the animal
     **/
    public Animal(int dominanceLevel) {
        this.dominanceLevel = dominanceLevel;
    }

    /**
     * Returns the dominance level of the animal.
     *
     * @return the dominance level
     **/
    public int getDominanceLevel() {
        return dominanceLevel;
    }

    /**
     * Compares this animal with another animal based on dominance level.
     *
     * @param other the other animal to compare with
     * @return a negative number if this animal is less dominant,
     *         zero if they have the same dominance level,
     *         or a positive number if this animal is more dominant
     **/
    @Override
    public int compareTo(Animal other) {
        return this.getDominanceLevel()-other.getDominanceLevel();
    }

}
