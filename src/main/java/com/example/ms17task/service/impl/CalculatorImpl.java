package com.example.ms17task.service.impl;

import com.example.ms17task.service.Calculator;

public class CalculatorImpl implements Calculator {

    @Override
    public double sum(double a, double b) {
        return a + b;
    }

    @Override
    public double sub(double a, double b) {
        return a - b;
    }

    @Override
    public double divide(double a, double b) {
        if (b != 0) {
            return a / b;
        } else {
            throw new ArithmeticException("B can not be 0!");
        }
    }

    @Override
    public double multiple(double a, double b) {
        return a * b;
    }

    @Override
    public boolean isOdd(int number) {
        return number % 2 != 0;
    }

    @Override
    public boolean isBlank(String input) {
        return input == null || input.trim().isEmpty();
    }
}
