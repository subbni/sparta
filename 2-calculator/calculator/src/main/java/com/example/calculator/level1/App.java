package com.example.calculator.level1;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String exitStr = "";
        while(!exitStr.equals("exit")) {
            try {
                // 입력 받기
                System.out.print("첫 번째 숫자(0 이상의 정수)를 입력해주세요 : ");
                int firstNum = Integer.parseInt(sc.nextLine());
                System.out.print("두 번째 숫자(0 이상의 정수)를 입력해주세요 : ");
                int secondNum = Integer.parseInt(sc.nextLine());
                System.out.print("연산자를 입력해주세요 (+,-,*,/ 중 하나) : ");
                String operator = sc.nextLine();
                // 연산
                double result = operate(firstNum, secondNum, operator);
                // 연산 결과 출력
                System.out.println("결과 : " + result);
            } catch (Exception e) {
                System.out.println("연산에 실패했습니다. " + e.getMessage());
            } finally {
                // exit을 입력 받는다면 반복 종료
                System.out.print("종료하시겠습니까? (exit 입력 시 종료됩니다.) : ");
                exitStr = sc.nextLine();
            }
        }
        System.out.print("종료합니다 . . .");
        sc.close();
    }

    public static double operate(int firstNum, int secondNum, String operator) {
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
}
