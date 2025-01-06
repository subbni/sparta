package com.example.calculator.level3;

import com.example.calculator.level2.Calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String exitStr = "";
        ArithmeticCalculator<Number> calculator = new ArithmeticCalculator<Number>();
        while(!exitStr.equals("exit")) {
            try {
                // 1. 입력 받기 : int와 double 모두 가능
                System.out.print("첫 번째 숫자를 입력해주세요 : ");
                String firstNum = sc.nextLine();
                System.out.print("두 번째 숫자를 입력해주세요 : ");
                String secondNum = sc.nextLine();
                System.out.print("연산자를 입력해주세요 (+,-,*,/ 중 하나) : ");
                String operator = sc.nextLine();
                // 2. 연산
                // String -> Integer / Double로의 변환을 위해 NumberParser를 사용합니다.
                calculator.calculate(
                        NumberParser.parse(firstNum),
                        NumberParser.parse(secondNum),
                        operator
                );
                // 3. 연산 결과 출력
                System.out.println("결과 : " + calculator.getResult());
                // 4. 저장된 결과 중 사용자 입력보다 큰 결과값 출력
                System.out.print("입력보다 큰 결과값을 조회합니다. 입력 : ");
                String searchInput = sc.nextLine();
                calculator.printResultGreaterThan(NumberParser.parse(searchInput));
            } catch (NumberFormatException e) {
                System.out.println("연산에 실패했습니다. 올바른 숫자 형식으로 입력해주세요.");
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
