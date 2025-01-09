package com.example.calculator.level3.util;

public class NumberParser {
    /**
     * 소수점 여부에 따라 Double 또는 Integer를 반환합니다.
     */
    public static Number parse(String number) throws NumberFormatException { // 예외 처리를 강제하지는 않지만, 해당 예외의 발생 가능성을 알림

        if(number.contains(".")) {
            return Double.parseDouble(number);
        } else {
            return Integer.parseInt(number);
        }
    }
}
