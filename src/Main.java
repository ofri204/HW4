public class Main {
    public static void main(String[] args) {
        SpeciesQueue<Animal> animalQueue = new SpeciesQueue<>();

        animalQueue.add(new Tiger());
        animalQueue.add(new Lion());
        animalQueue.add(new Lion());
        animalQueue.add(new Tiger());
        animalQueue.add(new Snake());
        animalQueue.add(new Tiger());
        animalQueue.add(new Tiger());
        animalQueue.add(new Tiger());
        animalQueue.add(new Tiger());
        animalQueue.add(new Tiger());
        animalQueue.add(new Tiger());
        animalQueue.add(new Tiger());
        animalQueue.add(new Tiger());
        animalQueue.add(new Tiger());
        animalQueue.add(new Snake());
        animalQueue.add(new Tiger());
        animalQueue.add(new Tiger());

        for (Animal animal : animalQueue) {
            if (animal == null) {
                System.out.println("Warning: null animal in queue");
            } else {
                System.out.println(animal.getClass().getSimpleName() + ": " + animal.getDominanceLevel());
            }
        }
    }
}