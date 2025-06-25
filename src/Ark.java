/**
 * The Ark class represents a container that holds a queue of animals
 * It uses a SpeciesQueue to manage the animals in a priority order
 * based on their dominance level and type.
 **/
public class Ark {
    private final SpeciesQueue<Animal> animalQueue;
    /**
     * Constructs a new empty Ark.
     **/
    public Ark() {
        this.animalQueue= new SpeciesQueue<>();
    }

    /**
     * Adds an animal to the ark's queue
     *
     * @param animal the animal to be added to the ark
     * @throws InvalidInputException if the animal is null
     */
    public void add(Animal animal) throws InvalidInputException {
        animalQueue.add(animal);
    }

    public void enterToArk() {
        if(this.isAnimalQueueNotEmpty()){
            Animal firstAnimalInQueue= animalQueue.remove();
            System.out.println( firstAnimalInQueue.getClass().getName() + " entered the ark");
        }
    }

    private boolean isAnimalQueueNotEmpty(){ return !this.animalQueue.isEmpty(); }

    public void enterAllToArk() {
        while(this.isAnimalQueueNotEmpty()){
            this.enterToArk();
        }
    }

    public void showQueue() {
        if( this.isAnimalQueueNotEmpty() ){
            StringBuilder queueStr = new StringBuilder();
            for( Animal a : this.animalQueue){
                queueStr.append(a.getClass().getName()).append(", ");
            }
            queueStr.delete( queueStr.length()-2, queueStr.length() - 1);
            System.out.println( queueStr );
        }
    }

}
