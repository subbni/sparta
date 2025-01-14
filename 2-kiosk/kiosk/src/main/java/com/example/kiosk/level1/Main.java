package com.example.kiosk.level1;

import java.util.Scanner;

public class Main {
    static final String[] menu = {
            "1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거",
            "2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거",
            "3. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거",
            "4. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거"
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 메뉴 출력
        System.out.println("[ SHAKESHACK MENU ]");
        for(int i=0; i<menu.length; i++) {
            System.out.println(menu[i]);
        }
        System.out.println("0. 종료      | 종료");
        // 0번 입력시 프로그램 종료
        String inputStr = sc.nextLine();
        while(!"0".equals(inputStr)) {
            inputStr = sc.nextLine();
        }
        sc.close();
    }
}
