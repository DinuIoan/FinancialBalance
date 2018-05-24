package financialbalance.appsyouneed.idinu.financialbalance.model;

import java.io.Serializable;
import java.util.Date;

public class IncomeOutcome implements Serializable{
    private int id;
    private String type;
    private String description;
    private Long value;
    private Long timestamp;
    private Long startDate;
    private Long endDate;
    private int isMonthly;
    private int isPrivate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Long getStartDate() {
        return startDate;
    }

    public void setStartDate(Long startDate) {
        this.startDate = startDate;
    }

    public Long getEndDate() {
        return endDate;
    }

    public void setEndDate(Long endDate) {
        this.endDate = endDate;
    }

    public int getIsMonthly() {
        return isMonthly;
    }

    public void setIsMonthly(int isMonthly) {
        this.isMonthly = isMonthly;
    }

    public int getIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(int isPrivate) {
        this.isPrivate = isPrivate;
    }
}
