package com.example.calculator.level3;

import java.util.LinkedList;
import java.util.stream.Collectors;

public class ArithmeticCalculator<T extends Number> {
    private LinkedList<Double> result = new LinkedList<>();

    public Double calculate(T firstNum, T secondNum, String operator) {
        OperatorType operatorType = OperatorType.fromSymbol(operator);
        double result = operatorType.operate(firstNum,secondNum);
        setResult(result);
        return result;
    }

    public Double getResult() {
        return this.result.get(this.result.size()-1);
    }

    public int getSizeOfResult() {
        return this.result.size();
    }

    public void setResult(Double result) {
        this.result.add(result);
    }

    public void removeResult() {
        // 가장 먼저 저장된 데이터를 삭제
        if(!result.isEmpty()) {
            this.result.removeFirst();
        }
    }

    public void printResultGreaterThan(Number value) {
        String str = result.stream()
                .filter(v -> v > value.doubleValue())
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println(str);
    }
}
