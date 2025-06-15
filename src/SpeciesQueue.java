import java.util.Iterator;

public class SpeciesQueue <T extends Comparable<T>> implements Iterable<T> {
    private T[] animals;
    private int count;

    public SpeciesQueue() {
        this.animals = (T[]) new Comparable[10];
        this.count = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new SpeciesQueueIterator();
    }

    private class SpeciesQueueIterator implements Iterator<T> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < count;
        }

        @Override
        public T next() {
            return animals[index++];
        }
    }
}
