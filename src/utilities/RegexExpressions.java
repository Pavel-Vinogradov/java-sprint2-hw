package utilities;

import org.jetbrains.annotations.Contract;

public class RegexExpressions {

    private static final String PARAMS_NAME_YEARS_NAME = "^y\\.\\d{4}\\.csv$";
    private static final String PARAMS_NAME_MONTH_NAME = "^m\\.\\d{6}\\.csv$";

    @Contract(pure = true)
    public static boolean isYearReport(String fileName) {
        return fileName.matches(PARAMS_NAME_YEARS_NAME);
    }

    @Contract(pure = true)
    public static boolean isMonthReport(String fileName) {
        return fileName.matches(PARAMS_NAME_MONTH_NAME);
    }

}
