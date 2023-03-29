package model;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class YearlyModel {
    public String month;
    public Double amount;
    public Boolean isExpense;

    public YearlyModel(String month, Double amount, Boolean isExpense) {
        this.month = month;
        this.amount = amount;
        this.isExpense = isExpense;
    }

    @Contract(pure = true)
    private @NotNull String setIsExpense() {
        if (isExpense) {
            return "Трата";
        } else {
            return "Доход";
        }
    }

    @Override
    public String toString() {
        return "Годовой отчёт {" +
                "Месяц =" + month +
                ", Сумма =" + amount +
                ", Трата/Доход =" + setIsExpense() +
                '}';
    }
}



