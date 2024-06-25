package stringCalculator;

import java.util.ArrayList;
import java.util.List;

import static stringCalculator.delimiters.CustomDelimiters.indexOfEndCustomDelimiters;

public class StringHandler {

    public static String getNumbersSubString(String text){
        int beginningIndexOfNumbers = indexOfEndCustomDelimiters(text) + 1; // next to \n
        StringBuilder substring = new StringBuilder();
        for (int i = beginningIndexOfNumbers; i < text.length(); i++) {
            char currentCharacter = text.charAt(i);
            substring.append(currentCharacter);
        }
        return substring.toString();
    }

    public static List<Integer> convertToIntList(List<String> splitNumbers) {
        List<Integer> convertedList = new ArrayList<>();
        for (String elem : splitNumbers) {
            int number = Integer.parseInt(elem);
            convertedList.add(number);
        }
        return convertedList;
    }

}
