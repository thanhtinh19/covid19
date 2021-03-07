package com.example.covid19;

public class Country {
    String name;
    double totalConfirmed;
    double totalDeaths;
    double totalRecovered;

    public Country(String name, double totalConfirmed, double totalDeaths, double totalRecovered) {
        this.name = name;
        this.totalConfirmed = totalConfirmed;
        this.totalDeaths = totalDeaths;
        this.totalRecovered = totalRecovered;
    }

    public Country() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotalConfirmed() {
        return totalConfirmed;
    }

    public void setTotalConfirmed(double totalConfirmed) {
        this.totalConfirmed = totalConfirmed;
    }

    public double getTotalDeaths() {
        return totalDeaths;
    }

    public void setTotalDeaths(double totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    public double getTotalRecovered() {
        return totalRecovered;
    }

    public void setTotalRecovered(double totalRecovered) {
        this.totalRecovered = totalRecovered;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", totalConfirmed=" + totalConfirmed +
                ", totalDeaths=" + totalDeaths +
                ", totalRecovered=" + totalRecovered +
                '}';
    }
}
