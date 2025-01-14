package com.example.kiosk.level2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("ShackBurger",6.9,"토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("SmokeShack",8.9,"베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Cheeseburger",6.9,"포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Hamburger",5.4,"비프패티를 기반으로 야채가 들어간 기본버거"));

        Scanner sc = new Scanner(System.in);
        String inputStr = "";

        while(true) {
            // 출력
            System.out.println("[ SHAKESHACK MENU ]");
            for(int i=0; i<menuItems.size(); i++) {
                System.out.print(i+1 + ". ");
                System.out.println(menuItems.get(i));
            }
            System.out.println("0. 종료      | 종료");
            // 입력 받기
            inputStr = sc.nextLine();
            int inputIdx = Integer.parseInt(inputStr);
            // 종료 조건
            if(inputIdx == 0) {
                break;
            }
            // 선택 메뉴 출력
            System.out.printf("선택한 메뉴 : %s\n\n", menuItems.get(inputIdx-1));
        }
        sc.close();
    }
}
