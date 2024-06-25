package stringCalculator.delimiters;

import static stringCalculator.utils.TypoCheck.containsNumbers;

public class Delimiter {
    private final String value;

    public Delimiter(String value){
        if (containsNumbers(value))
            throw new IllegalArgumentException("numbers are not allowed as delimiters");
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Delimiter delimiter = (Delimiter) obj;
        return value.equals(delimiter.getValue());
    }

}
