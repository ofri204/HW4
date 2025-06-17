/**
 * A general exception class for errors that occur in the {@link SpeciesQueue}.
 * This class is a super class for more specified exceptions,
 * such as {@link InvalidInputException} and {@link EmptyQueueException}.
 **/
public class SpeciesQueueException extends RuntimeException{

    /**
     * Constructs a new SpeciesQueueException with no detail message.
     **/
    public SpeciesQueueException() {}

    /**
     * Constructs a new SpeciesQueueException with the specified detail message.
     *
     * @param message the detail message
     **/
    public SpeciesQueueException(String message) {
        super(message);
    }

    /**
     * Constructs a new SpeciesQueueException with the specified detail message and cause.
     *
     * @param message the detail message
     * @param cause the cause of the exception
     **/
    public SpeciesQueueException(String message, Throwable cause) {
        super(message, cause);
    }
}

