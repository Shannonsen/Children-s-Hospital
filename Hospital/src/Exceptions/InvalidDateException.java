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
public class InvalidDateException extends Exception{

    public InvalidDateException(String message) {
        super("Fecha no válida en el campo: " + message);
    }
}
