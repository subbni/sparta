package com.example.kiosk.level5;


import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private final List<Menu> menus;

    public Kiosk(List<Menu> menus) {
        this.menus = menus;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);

        while(true) {
            // List와 Menu 클래스 활용하여 상위 카테고리 메뉴 출력
            System.out.println("[ MAIN MENU ]");
            for(int i=0; i<menus.size(); i++) {
                System.out.printf("%d. %s\n",i+1,menus.get(i).getCategory());
            }
            System.out.println("0. 종료      | 종료");

            try {
                // 상위 메뉴 숫자 입력 받기
                String menuInput = sc.nextLine();
                int menuIdx = Integer.parseInt(menuInput);

                if(menuIdx == 0) { // 0 : 종료 조건, 종료 처리
                    return; // 키오스크 종료
                } else if(menuIdx<0 || menuIdx>menus.size()){ // 잘못된 인덱스 오류 처리
                    throw new IllegalArgumentException("존재하지 않는 메뉴 번호입니다.");
                }

                while(true) {
                    // 입력 받은 숫자가 올바르다면 인덱스로 활용하여 List에 접근하기
                    // Menu가 가진 List<MenuItem>을 반복문을 활용하여 햄버거 메뉴 출력
                    Menu selectedMenu = menus.get(menuIdx-1);
                    System.out.println();
                    System.out.printf("[ %s MENU ]\n",selectedMenu.getCategory().toUpperCase());
                    selectedMenu.printMenuItems();
                    System.out.println("0. 뒤로가기");

                    try {
                        // 메뉴 아이템 숫자 입력 받기
                        String menuItemInput = sc.nextLine();
                        int menuItemIdx = Integer.parseInt(menuItemInput);

                        if(menuItemIdx == 0) { // 0 : 뒤로 가기, 메인 메뉴로 복귀
                            break;
                        } else if(menuItemIdx<0 || menuItemIdx>selectedMenu.getMenuItems().size()){ // 잘못된 인덱스 오류 처리
                            throw new IllegalArgumentException("존재하지 않는 메뉴 번호입니다.");
                        }

                        System.out.printf("선택한 메뉴 : %s\n",selectedMenu.getMenuItems().get(menuItemIdx-1));
                        break; // 메인 메뉴로 복귀
                    } catch (NumberFormatException e) { // 숫자 형식이 아닌 경우
                        System.out.println("처리에 실패했습니다. 원하는 메뉴 번호를 숫자 형식으로 입력해주세요.");
                    } catch (Exception e) {
                        System.out.println("처리에 실패했습니다. " + e.getMessage());
                    }
                }
            } catch (NumberFormatException e) { // 숫자 형식이 아닌 경우
                System.out.println("처리에 실패했습니다. 원하는 메뉴 번호를 숫자 형식으로 입력해주세요.");
            } catch (Exception e) {
                System.out.println("처리에 실패했습니다." + e.getMessage());
            }
            System.out.println();
        }
    }

    public List<Menu> getMenus() {
        return menus;
    }
}