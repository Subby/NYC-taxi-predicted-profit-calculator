package uk.ac.aston.taxianalysis.model;

public abstract class AbstractModel {

    private String id;

    public AbstractModel(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
