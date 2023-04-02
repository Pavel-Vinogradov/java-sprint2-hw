import core.data_handler.MonthlyReport;
import core.data_handler.VerificationReports;
import core.data_handler.YearlyReport;
import enums.ConsoleCommand;

import java.util.Arrays;
import java.util.Scanner;

public class Console {

    Scanner scanner = new Scanner(System.in);
    MonthlyReport monthlyReport = new MonthlyReport();
    YearlyReport yearlyReport = new YearlyReport();

    public void start() {
        System.out.println("Добро пожаловать в программу для работы с отчётами!");
        while (true) {
            System.out.println("Введите номер команды, которую хотите выполнить:");
            Arrays.stream(ConsoleCommand.values()).forEach(consoleCommand -> System.out.println(consoleCommand.getCommand() + ": " + consoleCommand.getDescription()));
            int command = scanner.nextInt();
            if (command == ConsoleCommand.COUNT_ALL_MOUTHS_REPORT.getCommand()) {
                System.out.println(ConsoleCommand.COUNT_ALL_MOUTHS_REPORT.getDescription());
                monthlyReport.getReport();
                System.out.println("Все имеющиеся месячные отчеты считаны");
            }
            if (command == ConsoleCommand.COUNT_YEAR_REPORT.getCommand()) {
                System.out.println(ConsoleCommand.COUNT_YEAR_REPORT.getDescription());
                yearlyReport.getReport();
                System.out.println("Все имеющиеся годовые отчеты считаны");
            }
            if (command == ConsoleCommand.VERIFY_REPORT.getCommand()) {
                System.out.println(ConsoleCommand.VERIFY_REPORT.getDescription());
                if (monthlyReport.isReport && yearlyReport.isReport) {
                    VerificationReports verificationReports = new VerificationReports(monthlyReport.monthsStat, yearlyReport.yearStat);
                    verificationReports.getGeneralReport();
                } else {
                    System.out.println("Сначала необходимо считать месячные и годовой отчёты\n");
                }

                System.out.println("Все имеющиеся месячные отчеты считаны");
            }
            if (command == ConsoleCommand.DISPLAY_ALL_MOUTHS_REPORT.getCommand()) {
                if (monthlyReport.isReport) {
                    monthlyReport.genMonthsInfo();
                } else {
                    System.out.println("Сначала необходимо считать месячные отчёты\n");
                }
            }
            if (command == ConsoleCommand.DISPLAY_YEAR_REPORT.getCommand()) {
                if (yearlyReport.isReport) {
                    yearlyReport.getYearInfo();
                } else {
                    System.out.println("Сначала необходимо считать годовой отчёт\n");
                }

            } else if (command == ConsoleCommand.EXIT.getCommand()) {
                System.out.println("Выход");
                System.exit(0);
                break;
            }
        }
    }

}
