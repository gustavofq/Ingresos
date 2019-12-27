package Persistencia.exceptions;

public class ViolacionClaveForaneaException extends Exception {

    public ViolacionClaveForaneaException() {
    }

    public ViolacionClaveForaneaException(String message) {
        super(message);
    }

    public ViolacionClaveForaneaException(Throwable cause) {
        super(cause);
    }
    
    private String imprimirMensaje(){
        return "Se ha violado la integridad referencial"; 
    }
}
