package stringCalculator.delimiters;

import static stringCalculator.delimiters.CustomDelimiters.CUSTOM_DELIMITER_STARTS;

public class DelimitersFactory {
    public static Delimiters generateDelimiters(String text) {
        if (usesCustomDelimiters(text)) {
            return new CustomDelimiters(text);
        }
        return new DefaultDelimiters();
    }

    private static boolean usesCustomDelimiters(String text) {
        return text.startsWith(CUSTOM_DELIMITER_STARTS);
    }
}
