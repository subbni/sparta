package com.example.calculator.level2;

import java.util.LinkedList;

public class Calculator {
    private LinkedList<Double> result = new LinkedList<>();
    public double calculate(int firstNum, int secondNum, String operator) {
        // 양의 정수(0포함) 2개와 연산 기호를 매개변수로 받아 사칙연산 기능을 수행한 후 결과 값을 반환
        if (firstNum < 0 || secondNum < 0) {
            throw new IllegalArgumentException("0 이상의 정수를 입력해주세요.");
        }

        switch (operator) {
            case "+" -> {
                return firstNum+secondNum;
            }
            case "-" -> {
                return firstNum-secondNum;
            }
            case "*" -> {
                return firstNum*secondNum;
            }
            case "/" -> {
                if(secondNum == 0) {
                    throw new ArithmeticException("나눗셈 연산 시 분모(두 번째 숫자)가 0이 될 수 없습니다.");
                }
                return (double) firstNum/secondNum;
            }
            default -> {
                throw new IllegalArgumentException("올바른 연산자를 입력해주세요. (+,-,*,/ 중 하나)");
            }
        }
    }

    public double getResult() {
        return this.result.get(this.result.size()-1);
    }

    public int getSizeOfResult() {
        return this.result.size();
    }

    public void setResult(double result) {
        this.result.add(result);
    }

    public void removeResult() {
        // 가장 먼저 저장된 데이터를 삭제
        if(!result.isEmpty()) {
            this.result.removeFirst();
        }
    }
}
