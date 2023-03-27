package data_handler;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public record MonthlyReport( String ItemName, Boolean IsExpense, Integer Quantity, Integer SumOfOne) {

    public MonthlyReport(String ItemName, Boolean IsExpense, Integer Quantity, Integer SumOfOne) {
        this.ItemName = ItemName;
        this.IsExpense = IsExpense;
        this.Quantity = Quantity;
        this.SumOfOne = SumOfOne;
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
        return "Месячные отчёт {" +
                "Название товара='" + ItemName + '\'' +
                ", Трата/Доход=" + setIsExpense() +
                ", Количество закупленного или проданного товара=" + Quantity +
                ", Стоимость одной единицы товара=" + SumOfOne +
                '}';
    }

}