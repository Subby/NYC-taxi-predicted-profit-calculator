package uk.ac.aston.taxianalysis.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Profit extends AbstractModel {

    public static final String ID = "_id";
    public static final String PREDICTED_PROFIT = "predictedProfit";

    private double profit;

    public Profit(@JsonProperty(ID) String id, @JsonProperty(PREDICTED_PROFIT) double profit) {
        super(id);
        this.profit = profit;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }
}
