package financialbalance.appsyouneed.idinu.financialbalance.database;

import java.util.List;

import financialbalance.appsyouneed.idinu.financialbalance.model.IncomeOutcome;
import financialbalance.appsyouneed.idinu.financialbalance.model.MonthSavings;

public class DatabaseDataHolder {
    private static List<IncomeOutcome> incomesOutcomes;
    private static List<MonthSavings> monthSavings;

    public static List<IncomeOutcome> getIncomesOutcomes() {
        return incomesOutcomes;
    }

    public static void setIncomesOutcomes(List<IncomeOutcome> incomesOutcomes) {
        DatabaseDataHolder.incomesOutcomes = incomesOutcomes;
    }

    public static List<MonthSavings> getMonthSavings() {
        return monthSavings;
    }

    public static void setMonthSavings(List<MonthSavings> monthSavings) {
        DatabaseDataHolder.monthSavings = monthSavings;
    }
}
