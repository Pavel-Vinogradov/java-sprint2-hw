package core.data_handler;

import model.MonthlyModel;
import model.YearlyModel;

import java.util.ArrayList;
import java.util.HashMap;

public class VerificationReports {
    HashMap<String, ArrayList<MonthlyModel>> monthsStat;
    ArrayList<YearlyModel> yearStat;
    public VerificationReports (HashMap<String,ArrayList<MonthlyModel>> monthsStat, ArrayList<YearlyModel> yearStat) {
        this.monthsStat = monthsStat;
        this.yearStat = yearStat;
    }
    public void getGeneralReport() {
        ArrayList<String> errors = new ArrayList<>();   // Для ошибочных месяцев
        for (String monthName : monthsStat.keySet()) {
            int expenseSumMonth = 0;
            int profitSumMonth = 0;
            for (MonthlyModel line : monthsStat.get(monthName)) {
                if (line.isExpense) {      // Если трата
                    expenseSumMonth += (line.quantity * line.sumOfOne);
                } else {                    // Если доход
                    profitSumMonth += (line.quantity * line.sumOfOne);
                }
            }
            String StrIndexMonth = getStrIndexMonth(monthName);     // Получаем имя месяца, как в годовом отчёте

            for (YearlyModel yearlyModel : yearStat) {
                // Найти расходы в году по нужному месяцу
                if (yearlyModel.month.equals(StrIndexMonth) && yearlyModel.isExpense) {
                    if (yearlyModel.amount != expenseSumMonth) {
                        errors.add(monthName);
                    }
                }
                // Найти доходы в году по нужному месяцу
                if (yearlyModel.month.equals(StrIndexMonth) && !(yearlyModel.isExpense)) {
                    if (yearlyModel.amount != profitSumMonth) {
                        errors.add(monthName);
                    }
                }
            }
        }
        if (errors.isEmpty()) {
            System.out.println("Отчёты прошли проверку\n");
        } else {
            for (String month : errors) {
                System.out.println("Обнаружено несоответствие в отчёте месяца " + month + "\n");
            }
        }
    }


    String getStrIndexMonth (String monthName) {      // Получить по имени месяца его номер в формате ук. в годовом отчёте
        String[] months = {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь",
                "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};
        for (int i = 0; i <= 11; i ++) {
            if (monthName.equals(months[i])) {
                if (i < 9) {        // Индекс месяца в отчёте года всегда двузначное число
                    return "0" + (i + 1);
                } else {
                    return Integer.toString(i + 1);
                }
            }
        }
        return "";
    }
}
