import java.util.Iterator;

/**
 * A priority queue for elements that are both Comparable and Cloneable.
 * Maintains a specific order: higher dominance first, and elements from the same type stick together,
 * as the last element from the same type is located first
 *
 * @param <T> the type of elements held in this queue
 **/
public class SpeciesQueue <T extends Comparable<T> & Cloneable> implements Iterable<T> {
    private T[] queue;
    private int count;

    /**
     * Constructs an empty SpeciesQueue with an initial size of 10.
     **/
    public SpeciesQueue() {
        this.queue = (T[]) new Comparable[10];
        this.count = 0;
    }

    /**
     * Returns an iterator that can run over the elements in the queue.
     *
     * @return a SpeciesQueueIterator
     **/
    @Override
    public Iterator<T> iterator() {
        return new SpeciesQueueIterator();
    }

    /**
     * A private class for iterator implementation for SpeciesQueue
     **/
    private class SpeciesQueueIterator implements Iterator<T> {
        private int index = 0;

        /**
         * Checks if there are more elements in the queue
         *
         * @return true if there are more elements, false otherwise
         **/
        @Override
        public boolean hasNext() {
            return index < count;
        }

        /**
         * Returns the next element in the queue
         *
         * @return the next element
         **/
        @Override
        public T next() {
            return queue[index++];
        }
    }

    /**
     * A helper method for the {@link #add} method
     * Validates that the input is not null
     *
     * @param type the element to validate
     * @throws InvalidInputException if the element is null
     **/
    private void validateInput(T type) {
        if (type == null) {
            throw new InvalidInputException();
        }
    }

    /**
     * A helper method for the {@link #add} method
     * Checks if the array needs to be expanded by 2 and does so if necessary
     **/
    private void arraySizeCheck() {
        if (count == queue.length) {
            expandArraySizeBy2();
        }
    }

    /**
     * A helper method for the {@link #add} method
     * Finds the correct index that the element will be inserted into
     * Elements are inserted in descending dominance order,
     * and elements from the same type are grouped together- in this case, the newest element is located first
     * among them
     *
     * @param type the element to insert
     * @return the index insertion of the element
     **/
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

    /**
     * A helper method for the {@link #add} method
     * Inserts the given element at the specified index in the queue
     *
     * @param index the index in the queue to insert the element
     * @param type  the element to insert
     **/
    private void insertAtSpecifiedIndex(int index, T type) {
        for (int i = count; i > index; i--) {
            queue[i] = queue[i - 1];
        }
        queue[index] = type;
        count++;
    }

    /**
     * Adds a new element to the queue in the correct position
     *
     * @param type the element to add
     **/
    public void add(T type) {
        validateInput(type);
        arraySizeCheck();
        int insertIdx = findInsertionIndex(type);
        insertAtSpecifiedIndex(insertIdx, type);
    }


    /**
     * A helper method for the {@link #expandArraySizeBy2} method
     * Creates a new doubled size array
     *
     * @return the new array
     */
    private T[] createDoubleSizedArray() {
        return (T[]) new Comparable[queue.length * 2];
    }

    /**
     * A helper method for the {@link #expandArraySizeBy2} method
     * Copies elements from the current queue to the new one.
     *
     * @param newArray the new array to copy into
     */
    private void copyToTheNewArray(T[] newArray) {
        for (int i = 0; i < count; i++) {
            newArray[i] = queue[i];
        }
    }

    /**
     * Expands the size of the current array by 2.
     **/
    private void expandArraySizeBy2() {
        T[] newQueue = createDoubleSizedArray();
        copyToTheNewArray(newQueue);
        queue = newQueue;


    }

    /**
     * A helper method for method {@link #remove()}
     * Shifts all elements in the queue one location to the left.
     **/
    private void shiftElementsLeft() {
        for (int i = 1; i < count; i++) {
            queue[i - 1] = queue[i];
        }
    }

    /**
     * A helper method for method {@link #remove()}
     * changes the last element in the queue to null after removing an element
     * This method is called after shifting the elements to the left, in order to remove duplicate elements
     */
    private void changeMostRightElementtoNull() {
        queue[count - 1] = null;
    }

    /**
     * Removes and returns the first element in the queue
     *
     * @return the first element in the queue
     * @throws EmptyQueueException if the queue is empty
     **/
    public T remove() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        T firstElement = queue[0];
        shiftElementsLeft();
        changeMostRightElementtoNull();
        return firstElement;
    }

    /**
     * Checks if the queue is empty
     *
     * @return true if the queue does not have any elements, and false otherwise
     **/
    public boolean isEmpty() {
        return count == 0;
    }

    public T peek() throws EmptyQueueException{
        return this.queue[ queue.length - 1] ;
    }

    public int size(){
        return this.count;
    }

    @Override
    public SpeciesQueue<T> clone(){
        SpeciesQueue<T> copy = null;
        try{
            copy = (SpeciesQueue<T>)super.clone();
        } catch ( CloneNotSupportedException | ClassCastException e  ){
            return null;
        }
        return null;
    }

    private Cloneable[] animalsQueueCopy(){
        int queueLen = this.queue.length;
        Cloneable[] copy = new Cloneable[queueLen];
        for(int i = 0; i < queueLen - count; i++){
            copy[i] = this.queue[i].clone();
       }
        return copy;
    }

}
