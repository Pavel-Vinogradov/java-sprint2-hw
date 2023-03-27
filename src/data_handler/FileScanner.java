package data_handler;


import utilities.RegexExpressions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class FileScanner {

    private final String path = "resources";

    public List<MonthlyReport> readMonthlyReports() {
        List<MonthlyReport> reports = new ArrayList<>();
        File[] files = new File(path).listFiles((dir, name) -> RegexExpressions.isMonthReport(name));
        if (files == null) {
            return reports;
        }
        for (File file : files) {
            try {
                List<String> lines = Files.readAllLines(file.toPath());
                lines.remove(0); // Удаление заголовка
                for (String line : lines) {
                    String[] fields = line.split(",", -1);
                    MonthlyReport report = new MonthlyReport(
                            fields[0],
                            Boolean.parseBoolean(fields[1]),
                            Integer.parseInt(fields[2]),
                            Integer.parseInt(fields[3])
                    );
                    reports.add(report);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return reports;
    }

    public List<YearlyReport> readYearlyReport() {
        List<YearlyReport> reports = new ArrayList<>();
        File[] files = new File(path).listFiles((dir, name) -> RegexExpressions.isYearReport(name));
        if (files == null) {
            return reports;
        }
        for (File file : files) {
            try {
                List<String> lines = Files.readAllLines(file.toPath());
                lines.remove(0); // Удаление заголовка
                for (String line : lines) {
                    String[] fields = line.split(",", -1);
                    YearlyReport report = new YearlyReport(
                            Integer.parseInt(fields[0]),
                            Integer.parseInt(fields[1]),
                            Boolean.parseBoolean(fields[2]));
                    reports.add(report);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return reports;
    }
}


