package com.abril.miercoles26.patronRepository.domain;

import java.util.ArrayList;
import java.util.Arrays;

public class Calculadora {
    private double num1;
    private double num2;
    private double result;
    private double result2;
    private String op;

    public Calculadora(double num1, double num2, String op) {
        this.num1 = num1;
        this.num2 = num2;
        this.op = op;
        calcular();
    }

    public Calculadora() {
    }

    public ArrayList<Double> calcular() {
        switch (this.op) {
            case ("+") -> result = num1 + num2;
            case ("-") -> result = num1 - num2;
            case ("*") -> result = num1 * num2;
            case ("/") -> {
                result = num1 / num2;
                result2 = num1 % num2;
            }
            default -> throw new RuntimeException("Operacion no reconocida.");
        }
        return new ArrayList<>(Arrays.asList(result, result2));
    }

    public ArrayList<Double> calcular(double num1, double num2, String op) {
        this.num1 = num1;
        this.num2 = num2;
        this.op = op;
        return calcular();
    }

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public double getResult2() {
        return result2;
    }

    public void setResult2(double result2) {
        this.result2 = result2;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }
}
