package core.data_handler;

import model.MonthlyModel;
import utilities.FileReader;

import java.util.ArrayList;
import java.util.List;

public class MonthlyReader {

    String[] path;
    FileReader fileReader = new FileReader();   // Читатель csv
    ArrayList<MonthlyModel> month = new ArrayList<>();

    MonthlyReader(String[] path) {
        this.path = path;
    }

    public void getRecords() {
        for (String path : path) {
            List<String> lines = fileReader.readFileContents(path); // Читаем csv, разделяет на строки
            month = new ArrayList<>();
            for (int i = 1; i < lines.size(); i++) {   // Перебираем каждую строку
                String line = lines.get(i);
                String[] parts = line.split(",");   // Каждую строку csv добавляет в объект
                String itemName = parts[0];
                Boolean isExpense = Boolean.parseBoolean(parts[1]);
                Integer quantity = Integer.parseInt(parts[2]);
                Double SumOfOne = Double.parseDouble(parts[3]);
                MonthlyModel monthlyModel = new MonthlyModel(itemName, isExpense, quantity, SumOfOne);
                month.add(monthlyModel);
            }
        }

    }

}
