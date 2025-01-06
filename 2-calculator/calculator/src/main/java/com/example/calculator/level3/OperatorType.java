package com.example.calculator.level3;

public enum OperatorType {
    ADD("+") {
        @Override
        public double operate(Number a, Number b) {
            return a.doubleValue() + b.doubleValue();
        }
    }, SUBTRACT("-") {
        @Override
        public double operate(Number a, Number b) {
            return a.doubleValue() - b.doubleValue();
        }
    }, MULTIPLY("*") {
        @Override
        public double operate(Number a, Number b) {
            return a.doubleValue() * b.doubleValue();
        }
    }, DIVIDE("/") {
        @Override
        public double operate(Number a, Number b) {
            if(b.doubleValue() == 0) {
                throw new ArithmeticException("나눗셈 연산 시 분모(두 번째 숫자)가 0이 될 수 없습니다.");
            }
            return a.doubleValue() / b.doubleValue();
        }
    };
    private final String symbol;
    OperatorType(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public static OperatorType fromSymbol(String symbol) {
        for(OperatorType type : values()) {
            if(type.getSymbol().equals(symbol)) {
                return type;
            }
        }
        throw new IllegalArgumentException("지원하지 않는 연산입니다.");
    }
    public abstract double operate(Number a, Number b);
}
