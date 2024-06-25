package stringCalculator.delimiters;

import java.util.ArrayList;
import java.util.List;

public class DefaultDelimiters implements Delimiters {
    protected static List<Delimiter> delimiters;
    private static final String[] DEFAULT_DELIMITERS = {",",";","\n"};

    public DefaultDelimiters() {
        delimiters = new ArrayList<>();
        for (String value: DEFAULT_DELIMITERS) {
            Delimiter delimiter = new Delimiter(value);
            delimiters.add(delimiter);
        }
    }

    public boolean isValidDelimiter(String text) {
        Delimiter delimiter = new Delimiter(text);
        return delimiters.contains(delimiter);
    }

}
