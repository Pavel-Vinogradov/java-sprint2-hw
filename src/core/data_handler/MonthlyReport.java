package core.data_handler;

import model.MonthlyModel;
import utilities.MonthName;

import java.util.ArrayList;
import java.util.HashMap;

public class MonthlyReport implements MonthName {
    public boolean isReport = false;   // Флаг о проверке отчётов
    public HashMap<String, ArrayList<MonthlyModel>> monthsStat = new HashMap<>();

    public void getReport() {      // Прочитать все отчёты и занести в список months
        String[] links = {};
        String monthName = "";
        for (int i = 1; i <= 3; i++) {
            String link = "resources/m.20210" + i + ".csv";
            links = new String[]{link};
            monthName = getMonthName(i);
        }
        MonthlyReader monthlyReader = new MonthlyReader(links);
        monthlyReader.getRecords();
        monthsStat.put(monthName, monthlyReader.month);
        isReport = true;
    }

    public void genMonthsInfo() {
        for (String monthName : monthsStat.keySet()) {
            double maxProfit = 0.0;
            String bestGood = "";
            double bestGoodSum = 0.0;
            double maxExpense = 0.0;
            String maxExpenseGood = "";
            double maxExpenseSum = 0.0;
            System.out.println(monthName);          // Вывели имя месяца
            for (MonthlyModel monthlyModel : monthsStat.get(monthName)) {      // Перебор строк отчёта месяца
                if (!(monthlyModel.isExpense)) {           // Находим самый прибыльный товар
                    if (maxProfit < monthlyModel.quantity * monthlyModel.sumOfOne) {
                        maxProfit = monthlyModel.quantity * monthlyModel.sumOfOne;
                        bestGood = monthlyModel.itemName;
                        bestGoodSum = maxProfit;
                    }
                } else {                        // Находим самую большую трату
                    if (maxExpense < monthlyModel.quantity * monthlyModel.sumOfOne) {
                        maxExpense = monthlyModel.quantity * monthlyModel.sumOfOne;
                        maxExpenseGood = monthlyModel.itemName;
                        maxExpenseSum = maxExpense;
                    }
                }
            }
            System.out.println("Самый прибыльный товар месяца " + bestGood + " по " + bestGoodSum);
            System.out.println("Самая большая трата месяца " + maxExpenseGood + " по " + maxExpenseSum + "\n");
        }
    }
}
