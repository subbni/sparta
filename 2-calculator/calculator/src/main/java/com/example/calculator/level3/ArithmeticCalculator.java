package com.example.calculator.level3;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ArithmeticCalculator<T extends Number> {
    private final LinkedList<Double> result = new LinkedList<>();

    public Double calculate(T firstNum, T secondNum, String operator) {
        double result = OperatorType.fromSymbol(operator).operate(firstNum,secondNum);
        setResult(result);
        return result;
    }

    public Double getResult() {
        return this.result.get(this.result.size()-1);
    }

    public int getSizeOfResult() {
        return this.result.size();
    }

    // private 처리
    private void setResult(Double result) {
        this.result.add(result);
    }

    public void removeResult() {
        // 가장 먼저 저장된 데이터를 삭제
        if(!result.isEmpty()) {
            this.result.removeFirst();
        }
    }

    public void printResultGreaterThan(Number value) {
        System.out.println("[ "+value+"보다 큰 값"+" ]");
        System.out.println(joinToString(NumberListFilter.findAllGreaterThan(result, value)));
    }

    public void printResultLessThan(Number value) {
        System.out.println("[ "+value+"보다 작은 값"+" ]");
        System.out.println(joinToString(NumberListFilter.findAllLessThan(result, value)));
    }

    public void printResultEqualTo(Number value) {
        System.out.println("[ "+value+"와 같은 값"+" ]");
        System.out.println(joinToString(NumberListFilter.findAllEqualTo(result, value)));
    }

    private String joinToString(List<Double> list) {
        return list.isEmpty() ? "없습니다." :list.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}
