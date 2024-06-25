package stringCalculator.delimiters;

public class CustomDelimiters extends DefaultDelimiters {
    static final String CUSTOM_DELIMITER_STARTS = "//";
    static final String CUSTOM_DELIMITER_ENDS = "\n";

    public CustomDelimiters(String text) {
        this.generatesDelimiters(text);
    }

    private void generatesDelimiters(String text) {
        int beginIndex = CUSTOM_DELIMITER_STARTS.length();
        int delimitersEnds = indexOfEndCustomDelimiters(text);
        StringBuilder delimiterValue = new StringBuilder();

        for (int i = beginIndex; i < delimitersEnds; i++) {
            char currentCharacter = text.charAt(i);
            generateDelimiterValue(currentCharacter, delimiterValue);
        }
    }

    private static void generateDelimiterValue(char currentCharacter, StringBuilder delimiterValue) {
        if (currentCharacter == ']') {
            addDelimiter(delimiterValue);
        }
        else if (!(currentCharacter == '[')){
            delimiterValue.append(currentCharacter);
        }
    }

    private static void addDelimiter(StringBuilder delimiterValue) {
        Delimiter delimiter = new Delimiter(delimiterValue.toString());
        delimiters.add(delimiter);
        delimiterValue.delete(0, delimiterValue.length());  // clean var
    }

    public static int indexOfEndCustomDelimiters(String text) {
        return text.indexOf(CUSTOM_DELIMITER_ENDS);
    }

}
