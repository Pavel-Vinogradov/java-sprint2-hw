package data_handler;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public record YearlyReport(Integer Mouth, Integer Amount, Boolean IsExpense) {

    public YearlyReport(Integer Mouth, Integer Amount, Boolean IsExpense) {
        this.Mouth = Mouth;
        this.Amount = Amount;
        this.IsExpense = IsExpense;
    }

    public Integer getMouth() {
        return Mouth;
    }

    public Integer getAmount() {
        return Amount;
    }

    public Boolean getIsExpense() {
        return IsExpense;
    }

    @Contract(pure = true)
    private @NotNull String setIsExpense() {
        if (IsExpense) {
            return "Трата";
        } else {
            return "Доход";
        }
    }

    @Override
    public String toString() {
        return "Годовой отчёт {" +
                "Месяц =" + Mouth +
                ", Сумма =" + Amount +
                ", Трата/Доход =" + setIsExpense() +
                '}';
    }
}



