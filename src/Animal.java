public abstract class Animal implements Comparable<Animal> ,Cloneable {
    private final int dominanceLevel;

    public Animal(int dominanceLevel) {
        this.dominanceLevel = dominanceLevel;
    }
    public int getDominanceLevel() {
        return dominanceLevel;
    }

    @Override
    public int compareTo(Animal other) {
        return this.getDominanceLevel()-other.getDominanceLevel();
    }

}
