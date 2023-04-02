package core.data_handler;

import model.YearlyModel;
import utilities.FileReader;

import java.util.ArrayList;
import java.util.List;

public class YearlyReader {
    FileReader fileReader = new FileReader();   // Читатель csv
    ArrayList<YearlyModel> yearStat = new ArrayList<>();

    /*
    * Тут не понял твой коментайри
    * "конструктор не должен в себе иметь работу с файлами, конструкторы обычно достаточно легковесные, работа с файлами и заполнение данными должно быть в отдельном методе"
    * тут у меня и есть метод, который должен возвращать список объектов YearlyModel принимает путь в качестве параметра
    * */
    public YearlyReader(String path) {
        List<String> lines = fileReader.readFileContents(path); // Читаем csv, разделяет на строки
        for (int i = 1; i < lines.size(); i++) {   // Перебираем каждую строку
            String line = lines.get(i);
            String[] parts = line.split(",");   // Каждую строку csv добавляет в объект
            String monthNum = parts[0];
            Double amount = Double.parseDouble(parts[1]);
            Boolean isExpense = Boolean.parseBoolean(parts[2]);
            YearlyModel stat = new YearlyModel(monthNum, amount, isExpense);
            yearStat.add(stat);
        }
    }
}
