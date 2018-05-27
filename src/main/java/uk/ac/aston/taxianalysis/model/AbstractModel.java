package uk.ac.aston.taxianalysis.model;

public abstract class AbstractModel {

    private int id;

    public AbstractModel(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
