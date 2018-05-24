package financialbalance.appsyouneed.idinu.financialbalance.model;

import java.util.Date;

public class MonthSavings {
    private int id;
    private String month;
    private Long savings;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Long getSavings() {
        return savings;
    }

    public void setSavings(Long savings) {
        this.savings = savings;
    }
}
