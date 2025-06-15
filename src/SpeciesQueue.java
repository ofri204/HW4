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

    private void validateInput(T animal) {
        if (animal == null) {
            throw new InvalidInputException();
        }
    }

    private void arraySizeCheck() {
        if (count == animals.length) {
            expandArraySizeBy2();
        }
    }

    private int findInsertionIndex(T animal) {
        int insertIdx = 0;
        int sameAnimalStartIdx = -1;

        while (insertIdx < count) {
            T current = animals[insertIdx];
            int cmp = animal.compareTo(current);

            if (cmp > 0) {
                break;
            } else if (cmp == 0 && animal.getClass()==(current.getClass())) {
                sameAnimalStartIdx = insertIdx;
                break;
            }

            insertIdx++;
        }

        if (sameAnimalStartIdx != -1) {
            return sameAnimalStartIdx;
        }

        return insertIdx;
    }

    private void insertAtSpecifiedIndex(int index, T animal) {
        for (int i = count; i > index; i--) {
            animals[i] = animals[i - 1];
        }
        animals[index] = animal;
        count++;
    }

    public void add(T animal) {
        validateInput(animal);
        arraySizeCheck();
        int insertIdx = findInsertionIndex(animal);
        insertAtSpecifiedIndex(insertIdx, animal);
    }


    private T[] createDoubleSizedArray() {
        return (T[]) new Animal[animals.length * 2];
    }

    private int findStartIndexToCopyFrom(T[] newArray) {
        return newArray.length / 2;
    }

    private void copyToTheNewArray(T[] newArray, int startIdx) {
        for (int i = 0; i < count; i++) {
            newArray[startIdx + i] = (T) animals[i];
        }
    }

    private void expandArraySizeBy2() {
        T[] newAnimals = createDoubleSizedArray();
        int startIdx = findStartIndexToCopyFrom(newAnimals);
        copyToTheNewArray(newAnimals, startIdx);
        animals = newAnimals;
    }

}
