public class Main {
    public static void main(String[] args) {
        SpeciesQueue<Animal> animalQueue = new SpeciesQueue<>();

        animalQueue.add(new Tiger());
        animalQueue.add(new Lion());
        animalQueue.add(new Lion());
        animalQueue.add(new Tiger());
        animalQueue.add(new Snake());

        for (Animal animal : animalQueue) {
            System.out.println(animal.getClass().getSimpleName() + ": " + animal.getDominanceLevel());
        }
    }
}