/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.exceptions;

/**
 *
 * @author gustavo
 */
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
