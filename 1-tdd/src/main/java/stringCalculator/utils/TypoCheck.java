package stringCalculator.utils;

public class TypoCheck {

    public static boolean isAValidNumber(String numberStr) {
        if (numberStr.isEmpty()) return false;
        char firstDigit = numberStr.charAt(0);
        if (!isANumberOrMinusSign(firstDigit))
            return false;
        for (int i = 1; i < numberStr.length(); i++) {
            char currentChar = numberStr.charAt(i);
            if (!Character.isDigit(currentChar))
                return false;
        }
        return true;
    }

    public static boolean containsNumbers(String value) {
        for (int i = 0; i < value.length(); i++) {
            if (isANumberOrMinusSign(value.charAt(i)))
                return true;
        }
        return false;
    }

    private static boolean isANumberOrMinusSign(char character) {
        return (Character.isDigit(character) || character == '-');
    }
}
