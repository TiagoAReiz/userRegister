package signin.user.core.exceptions;


public class UserAlreadyExistsException extends RuntimeException{
    public UserAlreadyExistsException(){
        super("Usuário com esse email já existente");
    }
    public UserAlreadyExistsException(String message){
        super(message);
    }

}
