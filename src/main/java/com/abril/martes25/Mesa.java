package com.abril.martes25;

public class Mesa {
    private final double price;
    private final double weight;
    private final String typeWood;

    public Mesa(double price, double weight, String typeWood) {
        this.price = price;
        this.weight = weight;
        this.typeWood = typeWood;
    }

    public double getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }

    public String getTypeWood() {
        return typeWood;
    }
}
