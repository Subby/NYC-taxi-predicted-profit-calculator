package uk.ac.aston.taxianalysis.model;

public class Profit extends AbstractModel {

    private double profit;

    public Profit(int id, double profit) {
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
