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

    public boolean isNumericTelephone(String number) {
        return number.matches("[0-9]{9,10}");
    }

    public boolean isNumericAge(String number) {
        boolean result = false;

        if (number.matches(number) == true) {
            String ageArray[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17"};

            for (int i = 0; i < ageArray.length; i++) {
                if (number.equals(ageArray[i])) {
                    result = true;
                }
            }
        }
        return result;
    }

    public boolean isLetter(String words) {
        for (int x = 0; x < words.length(); x++) {
            char c = words.charAt(x);
            if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == ' ')) {
                return false;
            }
        }
        return true;
    }

    public boolean isOnlyWhiteSpace(String text) {
        text = text.replaceAll("\\s", "");
        return text.length() > 0 ? false : true;
    }

}
