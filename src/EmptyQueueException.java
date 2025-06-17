/**
 * Thrown to indicate that an operation was attempted on an empty SpeciesQueue.
 * A specific type of {@link SpeciesQueueException}.
 **/
public class EmptyQueueException extends SpeciesQueueException{

    /**
     * Constructs a new EmptyQueueException with no detail message.
     **/
    public EmptyQueueException() {}

    /**
     * Constructs a new EmptyQueueException with the specified detail message.
     *
     * @param message the detail message
     **/
    public EmptyQueueException(String message) {
        super(message);
    }

    /**
     * Constructs a new EmptyQueueException with the specified detail message and cause.
     *
     * @param message the detail message
     * @param cause the cause of the exception
     **/
    public EmptyQueueException(String message, Throwable cause) {
        super(message, cause);
    }
}
