import java.util.Iterator;

/**
 * A priority queue for elements that are both Comparable and Cloneable.
 * Maintains a specific order: higher dominance first, and elements from the same type stick together,
 * as the last element from the same type is located first
 *
 * @param <T> the type of elements held in this queue
 **/
public class SpeciesQueue <T extends Comparable<T> > implements Iterable<T>, Cloneable{

    private T[] queue;
    private int count;

    private static final int DEFAULT_QUEUE_SIZE = 10;
    private static final int EXTEND_DEFAULT_SIZE = 2 ;

    /**
     * Constructs an empty SpeciesQueue with an initial size of 10.
     **/
    public SpeciesQueue() {
        this.queue = (T[]) new Comparable[ SpeciesQueue.DEFAULT_QUEUE_SIZE ];
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
        if (this.count == this.queue.length) {
            this.expandArraySizeBy2();
        }
    }

    /**
     * A helper method for the {@link #add} method
     * Finds the correct index that the element will be inserted into
     * Elements are inserted in descending dominance order,
     * and elements from the same type are grouped together - in this case, the newest element is located first
     * among them
     *
     * @param type the element to insert
     * @return the index insertion of the element
     **/
    private int findInsertionIndex(T type) {
        int insertIdx = 0;
        int sameTypeStartIdx = -1;

        while (insertIdx < this.count) {
            T temp = this.queue[insertIdx];

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
     * @throws InvalidInputException if the input is null
     **/
    public void add(T type) throws InvalidInputException {
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
        return (T[]) new Comparable[queue.length * SpeciesQueue.EXTEND_DEFAULT_SIZE];
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
    private void changeMostRightElementNull() {
        queue[count - 1] = null;
    }

    /**
     * Removes and returns the first element in the queue
     *
     * @return the first element in the queue
     * @throws EmptyQueueException if the queue is empty
     **/
    public T remove() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        T firstElement = queue[0];
        shiftElementsLeft();
        changeMostRightElementNull();
        count--;
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

    /**
     * Returns the first element in the queue if exists
     * @return the first element of {@code queue}
     * @throws EmptyQueueException if the queue is empty
     */
    public T peek() throws EmptyQueueException{
        if( this.isEmpty()){
            throw new EmptyQueueException();
        }
        return this.queue[ 0 ];
    }

    /**Returns the size of the queue
     * @return size of queue*/
    public int size(){
        return this.count;
    }

    /**
     * Cloning a SpeciesQueue to new instance
     * @return null if {@code queue} has an object which is not cloneable, otherwise the copy of
     * queue*/
    @Override
    public SpeciesQueue<T> clone() {
        try{
            SpeciesQueue<T> copy = (SpeciesQueue<T>)super.clone();
            copy.replaceQueue( this.queueCopy() );
            return copy;
        } catch (Exception e){
            return null;
        }
    }

    /**Replace the queue of the current Species queue to new one
     * <br><b>Warning: this function is only for inner use of the {@link #clone()} function</b>
     * @param newQueue a new queue*/
    private void replaceQueue(T[] newQueue){
        this.queue = newQueue;
    }

    /**
     * Copies the queue of the current SpeciesQueue
     * @return a new queue  */
    private T[] queueCopy() throws CloneNotSupportedException, NoSuchMethodException {

        //creating new queue
        int queueLen = this.queue.length;
        Object[] copy = new Comparable[queueLen];

        if( !this.isEmpty()){
            for(int i = 0; i < queueLen; i++){
                T element = this.queue[i];

                //checks if the current none null element can be cloned
                if(element != null){
                    try{
                        T clonedElement = (T)(element.getClass().getMethod("clone").invoke(element));
                        copy[i] = clonedElement;
                    } catch (Exception e) {
                        //the element cannot be copied, so it will be null
                        copy[i] = null;
                    }
                }
            }
        }

        return (T[])copy;
    }
}
