package signin.user.core.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(){
        super("Usuario nao encontrado");
    }
    public UserNotFoundException(String message){
        super(message);
    }

}
