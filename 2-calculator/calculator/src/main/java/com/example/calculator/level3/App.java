package com.example.calculator.level3;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String exitStr = "";
        ArithmeticCalculator<Number> calculator = new ArithmeticCalculator<Number>();
        while(!exitStr.equals("exit")) {
            try {
                System.out.println("=====================================");

                // 1. 입력 받기 (int와 double 모두 가능)
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

                // 4. 저장 결과 출력
                System.out.println("-------------------------------------");
                System.out.println("저장된 계산 결과를 조회합니다.");
                System.out.print("기준 값 입력 : ");
                String searchInput = sc.nextLine();
                Number inputNum = NumberParser.parse(searchInput);
                calculator.printResultGreaterThan(inputNum);
                calculator.printResultEqualTo(inputNum);
                calculator.printResultLessThan(inputNum);
            } catch (NumberFormatException e) {
                System.out.println("실패했습니다. 숫자를 올바른 형식으로 입력해주세요.");
            } catch (Exception e) {
                System.out.println("실패했습니다. " + e.getMessage());
            } finally {
                System.out.println("-------------------------------------");
                // exit을 입력 받는다면 반복 종료
                System.out.print("계속하시겠습니까? (exit 입력 시 종료됩니다.) : ");
                exitStr = sc.nextLine();
            }
        }
        System.out.println("종료합니다 . . .");
        System.out.println("=====================================");
        sc.close();
    }
}
