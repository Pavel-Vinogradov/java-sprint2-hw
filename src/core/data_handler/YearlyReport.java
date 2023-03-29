package core.data_handler;

import model.YearlyModel;

import java.util.ArrayList;

public class YearlyReport {
    public boolean isReport = false;   // Флаг о проверке отчёта
    public ArrayList<YearlyModel> yearStat;
    void getReport() {      // Считывание годового отчёта

        YearlyReader yearlyReader = new YearlyReader("resources/y.2021.csv");
        yearStat = yearlyReader.yearStat;  // Передаём полученные значения файла.
        isReport = true;
    }

    public void getYearInfo() {    // Вывод информации о годовом отчёте
        System.out.println("Год 2021");

        double monthProfit;
        for (int i = 0; i < yearStat.size(); i+=2) {       // Вывод выручки за каждый месяц
            if (yearStat.get(i).isExpense) {       // Если первая запись о месяце о трате
                monthProfit = yearStat.get(i+1).amount - yearStat.get(i).amount;
            } else {        // Если первая запись о месяце о доходе
                monthProfit = yearStat.get(i).amount - yearStat.get(i+1).amount;
            }
            System.out.println("За " + yearStat.get(i).month + " месяц выручка " + monthProfit);
        }

        double expensesSum = 0.0;
        double profitSum = 0.0;
        for (YearlyModel yearlyModel : yearStat) {    // Поиск среднего дохода и расхода за год
            if (yearlyModel.isExpense) {           // Найдём все траты
                expensesSum += yearlyModel.amount;
            } else {                                    // Найдём все доходы
                profitSum += yearlyModel.amount;
            }
        }
        double averageExpense = expensesSum / (yearStat.size() / 2.0); // Сумма/кол-во месяцев
        double averageProfit = profitSum / (yearStat.size() / 2.0); // Сумма/кол-во месяцев
        System.out.println("Средний расход за все месяцы в году " + averageExpense);
        System.out.println("Средний доход за все месяцы в году " + averageProfit + "\n");
    }
}
