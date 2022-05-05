/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Activities;

/**
 *
 * @author Shannon
 */
public class OperationsLogic {
    public boolean isValidLenght(String number){
        return number.length() < 9 || number.length() > 10;
    } 
}
