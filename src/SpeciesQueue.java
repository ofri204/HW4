import java.util.Iterator;

public class SpeciesQueue <T extends Comparable<T> & Cloneable> implements Iterable<T> {
    private T[] queue;
    private int count;

    public SpeciesQueue() {
        this.queue = (T[]) new Comparable[10];
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
            return queue[index++];
        }
    }

    private void validateInput(T type) {
        if (type == null) {
            throw new InvalidInputException();
        }
    }

    private void arraySizeCheck() {
        if (count == queue.length) {
            expandArraySizeBy2();
        }
    }

    private int findInsertionIndex(T type) {
        int insertIdx = 0;
        int sameTypeStartIdx = -1;

        while (insertIdx < count) {
            T temp = queue[insertIdx];
            if (temp == null) {
                break;
            }
            int resultComparison = type.compareTo(temp);

            if (resultComparison > 0) {
                break;
            } else if (resultComparison == 0 && type.getClass()==(temp.getClass())) {
                sameTypeStartIdx = insertIdx;
                break;
            }

            insertIdx++;
        }

        if (sameTypeStartIdx != -1) {
            return sameTypeStartIdx;
        }

        return insertIdx;
    }

    private void insertAtSpecifiedIndex(int index, T type) {
        for (int i = count; i > index; i--) {
            queue[i] = queue[i - 1];
        }
        queue[index] = type;
        count++;
    }

    public void add(T type) {
        validateInput(type);
        arraySizeCheck();
        int insertIdx = findInsertionIndex(type);
        insertAtSpecifiedIndex(insertIdx, type);
    }


    private T[] createDoubleSizedArray() {
        return (T[]) new Comparable[queue.length * 2];
    }

    private void copyToTheNewArray(T[] newArray) {
        for (int i = 0; i < count; i++) {
            newArray[i] = queue[i];
        }
    }

    private void expandArraySizeBy2() {
        T[] newQueue = createDoubleSizedArray();
        copyToTheNewArray(newQueue);
        queue = newQueue;


    }
}
