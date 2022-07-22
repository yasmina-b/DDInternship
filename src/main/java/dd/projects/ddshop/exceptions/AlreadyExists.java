package dd.projects.ddshop.exceptions;

public class AlreadyExists extends RuntimeException {
    public AlreadyExists(String message){
        super(message);
    }
}
