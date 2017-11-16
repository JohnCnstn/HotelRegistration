package classes.data.validation.exception;

public class UserNameExistsException extends Throwable{
    public UserNameExistsException(final String message) {
        super(message);
    }
}
