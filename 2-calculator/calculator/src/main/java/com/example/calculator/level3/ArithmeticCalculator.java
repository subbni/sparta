package com.example.calculator.level3;

import com.example.calculator.level3.constant.OperatorType;
import com.example.calculator.level3.util.NumberListFilter;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ArithmeticCalculator<T extends Number> {
    private final List<Double> results = new LinkedList<>();

    public Double calculate(T firstNum, T secondNum, String operator) {
        double result = OperatorType.fromSymbol(operator).operate(firstNum,secondNum);
        addResult(result);
        return result;
    }

    public Double getLastResult() {
        return this.results.get(this.results.size()-1);
    }

    public int getSizeOfResults() {
        return this.results.size();
    }

    private void addResult(Double result) {
        this.results.add(result);
    }

    public void removeOldestResult() {
        // 가장 먼저 저장된 데이터를 삭제
        if(!results.isEmpty()) {
            this.results.remove(0);
        }
    }

    public void printResultsGreaterThan(Number value) {
        System.out.println("[ "+value+"보다 큰 값"+" ]");
        System.out.println(joinToString(NumberListFilter.findAllGreaterThan(results, value)));
    }

    public void printResultsLessThan(Number value) {
        System.out.println("[ "+value+"보다 작은 값"+" ]");
        System.out.println(joinToString(NumberListFilter.findAllLessThan(results, value)));
    }

    public void printResultsEqualTo(Number value) {
        System.out.println("[ "+value+"와 같은 값"+" ]");
        System.out.println(joinToString(NumberListFilter.findAllEqualTo(results, value)));
    }

    private String joinToString(List<Double> list) {
        return list.isEmpty() ? "없습니다." :list.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}
