package stringCalculator.parsers;

import java.util.List;

import static stringCalculator.utils.TypoCheck.isAValidNumber;

public class NumberParser {
    public static int parseNumber(String text, int index, List<String> result){
        StringBuilder numberStr = new StringBuilder();

        do {
            numberStr.append(text.charAt(index));
            index++;
        } while (index < text.length() && Character.isDigit(text.charAt(index)));

        if (!isAValidNumber(numberStr.toString()))
            throw new IllegalArgumentException("Invalid number entered");

        result.add(numberStr.toString());
        return index-1;
    }
}
