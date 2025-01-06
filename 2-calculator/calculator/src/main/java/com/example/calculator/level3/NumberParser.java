package com.example.calculator.level3;

public class NumberParser {
    /**
     * 소수점 여부에 따라 Double 또는 Integer를 반환합니다.
     */
    public static Number parse(String number) {
        if(number.contains(".")) {
            return Double.parseDouble(number);
        } else {
            return Integer.parseInt(number);
        }
    }
}
