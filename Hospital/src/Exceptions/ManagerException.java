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
public class ManagerException {

    public static void EmptyField(String value, String field) throws EmptyFieldException {
        if (value.trim().isEmpty()) {
            throw new EmptyFieldException(field);
        }
    }

    public static void OnlyNumberField(String value, String field) throws NotAllowedCharacterException {
        if (value.trim().chars().allMatch(Character::isDigit)) {
            throw new NotAllowedCharacterException(field);
        }
    }
    
    public static void TelephoneNumberValidation(String value) throws NotAllowedCharacterException, InvalidLengthTelephoneException{
        OnlyNumberField(value, "Telephone");
        String number = value.replaceAll("\\s","");
        if (number.length() > 8 && number.length() < 11) {
            throw new InvalidLengthTelephoneException();
        }
    }

    public static void DateValidation(Object value, String field) throws InvalidDateException {
        if (value == null) {
            throw new InvalidDateException(field);
        }
    }
}
