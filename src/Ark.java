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
        this.animalQueue= new SpeciesQueue<Animal>();
    }

    /**
     * Adds an animal to the ark's queue
     *
     * @param animal the animal to be added to the ark
     */
    public void add(Animal animal) {
        if( animal != null ){
            animalQueue.add(animal);
        }
    }

    /** Removes all animals from ark's queue */
    public void enterToArk() {
        if(this.isAnimalQueueNotEmpty()){
            Animal firstAnimalInQueue= animalQueue.remove();
            System.out.println("A " + firstAnimalInQueue.getClass().getName() + " entered the ark");
        }
    }

    /**
     * Checks if ark's queue isn't empty
     * @return true if it isn't empty, false otherwise
     * */
    private boolean isAnimalQueueNotEmpty(){ return !this.animalQueue.isEmpty(); }

    /**Removes the first animal in the ark's queue*/
    public void enterAllToArk() {
        while(this.isAnimalQueueNotEmpty()){
            this.enterToArk();
        }
    }

    /**Displays all animals which are in the ark's queue*/
    public void showQueue() {
        if( this.isAnimalQueueNotEmpty() ){
            StringBuilder queueStr = new StringBuilder();
            for( Animal a : this.animalQueue ) {
                queueStr.append(a.getClass().getName()).append(", ");
            }
            System.out.println( queueStr.substring( 0, queueStr.length() - 2) );
        }
    }

}
