/**
 * The Ark class represents a container that holds a queue of animals
 * It uses a SpeciesQueue to manage the animals in a priority order
 * based on their dominance level and type.
 **/
public class Ark {
    private SpeciesQueue<Animal> animalQueue;

    /**
     * Constructs a new empty Ark.
     **/
    public Ark() {
        animalQueue= new SpeciesQueue<>();
    }

    /**
     * Adds an animal to the ark's queue
     *
     * @param animal the animal to be added to the ark
     * @throws InvalidInputException if the animal is null
     */
    public void add(Animal animal) {
        animalQueue.add(animal);
    }
}
