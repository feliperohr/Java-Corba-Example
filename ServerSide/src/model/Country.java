package model;

public class Country {

    private String name;
    private Double temp;

    public Country() {
    }

    public Country(String name, Double temp) {
        this.name = name;
        this.temp = temp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }
}
