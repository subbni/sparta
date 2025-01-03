package com.example.calculator.level2;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String exitStr = "";
        Calculator calculator = new Calculator();
        while(!exitStr.equals("exit")) {
            try {
                // 입력 받기
                System.out.print("첫 번째 숫자(0 이상의 정수)를 입력해주세요 : ");
                int firstNum = Integer.parseInt(sc.nextLine());
                System.out.print("두 번째 숫자(0 이상의 정수)를 입력해주세요 : ");
                int secondNum = Integer.parseInt(sc.nextLine());
                System.out.print("연산자를 입력해주세요 (+,-,*,/ 중 하나) : ");
                String operator = sc.nextLine();
                // 연산 & 연산 결과 저장
                calculator.setResult(calculator.calculate(firstNum, secondNum, operator));
                // 연산 결과 출력
                System.out.println("결과 : " + calculator.getResult());
                // Caculator의 removeResult() 메서드 활용 : 저장된 연산 결과를 항상 10개 이하로 유지
                if(calculator.getSizeOfResult() >= 10) {
                    calculator.removeResult();
                }
            } catch (Exception e) {
                System.out.println("연산에 실패했습니다. " + e.getMessage());
            } finally {
                // exit을 입력 받는다면 반복 종료
                System.out.print("계속하시겠습니까? (exit 입력 시 종료됩니다.) : ");
                exitStr = sc.nextLine();
            }
        }
        System.out.print("종료합니다 . . .");
        sc.close();
    }
}
