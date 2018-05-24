package financialbalance.appsyouneed.idinu.financialbalance.model;

import java.util.Date;

public class MonthSavings {
    private int id;
    private Date month;
    private Long savings;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getMonth() {
        return month;
    }

    public void setMonth(Date month) {
        this.month = month;
    }

    public Long getSavings() {
        return savings;
    }

    public void setSavings(Long savings) {
        this.savings = savings;
    }
}
