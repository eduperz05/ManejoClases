package com.abril.jueves20.muro;

import java.util.ArrayList;

public class Pared {
    public ArrayList<Azulejo> azulejos;

    public Pared(ArrayList<Azulejo> azulejos) {
        this.azulejos = azulejos;
    }

    public double area() {
        double area = 0;
        for (Azulejo az: azulejos) {
            area += az.area();
        }
        return area;
    }

}
