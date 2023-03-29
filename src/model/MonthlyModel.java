package model;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class MonthlyModel {
    public String itemName;
    public Boolean isExpense;
    public Integer quantity;
    public Double sumOfOne;

    public MonthlyModel(String itemName, Boolean isExpense, Integer quantity, Double sumOfOne) {
        this.itemName = itemName;
        this.isExpense = isExpense;
        this.quantity = quantity;
        this.sumOfOne = sumOfOne;
    }

    @Contract(pure = true)
    private @NotNull String setIsExpense() {
        if (this.isExpense) {
            return "Трата";
        } else {
            return "Доход";
        }
    }

    @Override
    public String toString() {
        return " {" +
                "Название товара='" + itemName + '\'' +
                ", Трата/Доход=" + setIsExpense() +
                ", Количество закупленного или проданного товара=" + quantity +
                ", Стоимость одной единицы товара=" + sumOfOne +
                '}';
    }

}

