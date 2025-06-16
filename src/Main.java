public class Main {
    public static void main(String[] args) {
        SpeciesQueue<Animal> animalQueue = new SpeciesQueue<>();

        for (int i=0;  i<20 ; i++){
            animalQueue.add(new Tiger());
            animalQueue.add(new Lion());
        }


        for (Animal animal : animalQueue) {
            if (animal == null) {
                System.out.println("Warning: null animal in queue");
            } else {
                System.out.println(animal.getClass().getSimpleName() + ": " + animal.getDominanceLevel());
            }
        }
    }
}