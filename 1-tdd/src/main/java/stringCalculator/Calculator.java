package stringCalculator;

import stringCalculator.delimiters.Delimiters;

import java.util.ArrayList;
import java.util.List;

import static stringCalculator.StringHandler.convertToIntList;
import static stringCalculator.parsers.DelimiterParser.parseDelimiter;
import static stringCalculator.parsers.NumberParser.parseNumber;

public class Calculator {
    private static final int DEFAULT_VALUE = 0;
    private Delimiters delimiters;
    public void setDelimiters(Delimiters delimiters){
        this.delimiters = delimiters;
    }

    public int calculate (String text) {
        if (text.isEmpty())
            return DEFAULT_VALUE;

        List<String> result = new ArrayList<>();
        boolean parseNumberTurn = true;
        for (int i = 0; i < text.length(); i++) {
            if (parseNumberTurn) {
                i = parseNumber(text, i, result);
            }
            else {
                i = parseDelimiter(text, i, delimiters);
            }
            parseNumberTurn = !parseNumberTurn;
        }

        return sumList(convertToIntList(result));
    }
    private static int sumList(List<Integer> numbers) {
        int result = 0;
        for (int number : numbers) {
            result += number;
        }
        return result;
    }
}
