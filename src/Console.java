import data_handler.FileScanner;
import enums.ConsoleCommand;

import java.util.Arrays;
import java.util.Scanner;

public class Console {

    Scanner scanner = new Scanner(System.in);
    FileScanner fileScanner = new FileScanner();

    public void start() {
        System.out.println("Добро пожаловать в программу для работы с отчётами!");
         while (true) {
            System.out.println("Введите номер команды, которую хотите выполнить:");
            Arrays.stream(ConsoleCommand.values()).forEach(consoleCommand -> System.out.println(consoleCommand.getCommand() + ": " + consoleCommand.getDescription()));
            int command = scanner.nextInt();
            switch (command) {
                case 1 -> {
                    System.out.println(ConsoleCommand.COUNT_ALL_MOUTHS_REPORT.getDescription());
                    fileScanner.readMonthlyReports();
                    System.out.println("Все имеющиеся месячные отчеты считаны");
                }
                case 2 -> {
                    System.out.println(ConsoleCommand.COUNT_YEAR_REPORT.getDescription());
                    fileScanner.readYearlyReport();
                    System.out.println("Все имеющиеся годовые отчеты считаны");
                }
                case 3 -> System.out.println(ConsoleCommand.VERIFY_REPORT.getDescription());
                case 4 -> System.out.println(ConsoleCommand.DISPLAY_ALL_MOUTHS_REPORT.getDescription());
                case 5 -> System.out.println(ConsoleCommand.DISPLAY_YEAR_REPORT.getDescription());
                case 0 -> {
                    System.out.println("Выход");
                    System.exit(0);
                }
                default -> System.out.println("Неверная команда");
            }
        }
    }

}
