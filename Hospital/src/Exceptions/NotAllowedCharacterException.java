/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author Noé
 */
public class NotAllowedCharacterException extends Exception{

    public NotAllowedCharacterException(String message) {
        super("Solo se aceptan números en el campo: " + message);
    }
    
}
