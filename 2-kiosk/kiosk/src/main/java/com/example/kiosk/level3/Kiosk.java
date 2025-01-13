package com.example.kiosk.level3;

import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private final List<MenuItem> menuItems;

    public Kiosk(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        String inputStr = "";

        while(true) {
            // 메뉴 출력
            System.out.println("[ SHAKESHACK MENU ]");
            for(int i=0; i<menuItems.size(); i++) {
                System.out.print(i+1 + ". ");
                System.out.println(menuItems.get(i));
            }
            System.out.println("0. 종료      | 종료");

            // 입력 받기
            try {
                inputStr = sc.nextLine();
                int inputIdx = Integer.parseInt(inputStr);

                if(inputIdx == 0) { // 0 : 종료 조건, 종료 처리
                    return;
                } else if(inputIdx>0 && inputIdx<=menuItems.size()){ // 1 ~ menuItems.size() : 해당 메뉴 선택 처리
                    System.out.printf("선택한 메뉴 : %s\n", menuItems.get(inputIdx-1));
                } else { // 그 외 : 잘못된 인덱스 오류 처리
                    System.out.println("처리에 실패햇습니다. 존재하지 않는 메뉴 번호입니다.");
                }
            } catch (NumberFormatException e) { // 숫자 형식이 아닌 경우
                System.out.println("처리에 실패했습니다. 원하는 메뉴 번호를 숫자 형식으로 입력해주세요.");
            } catch (Exception e) {
                System.out.println("실패했습니다." + e.getMessage());
            }
            System.out.println();
        }
    }
}
