package ht2ml.com.br.ht2money.models;

import java.util.UUID;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

// Model de despesas
public class Expense extends RealmObject {

    @PrimaryKey
    @Required
    private String id = UUID.randomUUID().toString();

    @Required
    private String description;

    @Required
    private String category;

    @Required
    private Double value;

    @Required
    private Integer day, month, year;

    private Boolean consolidated;

    public Expense() {
    }

    public Expense(String id, String description, String category, double value, Integer day, Integer month, Integer year, boolean consolidated) {
        this.id = id;
        this.description = description;
        this.category = category;
        this.value = value;
        this.day = day;
        this.month = month;
        this.year = year;
        this.consolidated = consolidated;
    }

    public Expense(String description, String category, double value, Integer day, Integer month, Integer year, boolean consolidated) {
        this.description = description;
        this.category = category;
        this.value = value;
        this.day = day;
        this.month = month;
        this.year = year;
        this.consolidated = consolidated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public boolean isConsolidated() {
        return consolidated;
    }

    public void setConsolidated(boolean consolidated) {
        this.consolidated = consolidated;
    }

    public String getId() {
        return id;
    }
}
