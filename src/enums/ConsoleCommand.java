package enums;

public enum ConsoleCommand {
    // Перечисление команд консоли
    COUNT_ALL_MOUTHS_REPORT(1, "Считать все месячные отчёты"),
    COUNT_YEAR_REPORT(2,"Считать годовой отчёт"),

    VERIFY_REPORT(3, "Сверить отчёты"),

    DISPLAY_ALL_MOUTHS_REPORT(4, "Вывести информацию о всех месячных отчётах"),
    DISPLAY_YEAR_REPORT(5, "Вывести информацию о годовом отчёте"),
    EXIT(0, "Выход");
    private final Integer command;
    private final String description;

    ConsoleCommand(Integer command, String description) {
        this.command = command;
        this.description = description;
    }

    public Integer getCommand() {
        return command;
    }

    public String getDescription() {
        return description;
    }
}
