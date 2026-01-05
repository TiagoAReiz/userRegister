package signin.user.core.exceptions;


public class UserAlreadyExistsException extends RuntimeException{
    public UserAlreadyExistsException(){
        super("Usuario com esse email ja existente");
    }
    public UserAlreadyExistsException(String message){
        super(message);
    }

}
