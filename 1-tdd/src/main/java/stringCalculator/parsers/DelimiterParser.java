package stringCalculator.parsers;

import stringCalculator.delimiters.Delimiters;

public class DelimiterParser {

    public static int parseDelimiter(String text, int index, Delimiters delimiters) {
        StringBuilder delimiter = new StringBuilder();
        char currentCharacter = text.charAt(index);

        while(!Character.isDigit(currentCharacter)) {
            delimiter.append(currentCharacter);
            index++;
            if (index == text.length())
                throw new IllegalArgumentException("String cant ends with a delimiter");
            currentCharacter = text.charAt(index);
        }

        if (!delimiters.isValidDelimiter(delimiter.toString()))
            throw new IllegalArgumentException("Invalid delimiter entered");

        return index-1;
    }
}
