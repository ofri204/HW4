/**
 * Thrown to indicate that an invalid input was provided to a SpeciesQueue operation.
 * This is a specific type of {@link SpeciesQueueException}.
 **/
public class InvalidInputException extends SpeciesQueueException{

    /**
     * Constructs a new InvalidInputException with no detail message.
     **/
    public InvalidInputException() {}

    /**
     * Constructs a new InvalidInputException with the specified detail message.
     *
     * @param message the detail message
     **/
    public InvalidInputException(String message) {
        super(message);
    }

    /**
     * Constructs a new InvalidInputException with the specified detail message and cause.
     *
     * @param message the detail message
     * @param cause the cause of the exception
     **/
    public InvalidInputException(String message, Throwable cause) {
        super(message, cause);
    }
}
