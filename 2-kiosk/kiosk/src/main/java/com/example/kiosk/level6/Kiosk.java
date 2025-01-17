package com.example.kiosk.level6;
import com.example.kiosk.level6.service.CartService;
import com.example.kiosk.level6.service.OrderService;

import java.util.List;
import java.util.Scanner;

/**
 * 프로그램 전체 흐름 제어 / 상&하위 카테고리 출력 담당
 */

public class Kiosk {
    private final List<Menu> menus;
    private final CartService cartService;
    private final OrderService orderService;

    public Kiosk(List<Menu> menus) {
        this.menus = menus;
        cartService = new CartService();
        orderService = new OrderService(cartService);
    }

    public void start() {
        Scanner sc = new Scanner(System.in);

        int orderIdx = menus.size()+1;
        int removeFromCartIdx = menus.size()+2;

        while(true) {
            printMenuCategory();

            int maxIdx = menus.size();
            if(!cartService.isCartEmpty()) {
                printOrderRelatedMenu(menus.size()+1);
                maxIdx+=2;
            }

            try {
                int menuIdx = getValidInputIdx(0,maxIdx);
                if(menuIdx == 0) { // 종료 조건, 키오스크 종료 처리
                    return;
                } else if(menuIdx<= menus.size()) {
                    Menu selectedMenu = menus.get(menuIdx-1);
                    processMenuItemSelectLogic(selectedMenu);
                } else if(menuIdx==orderIdx){
                    orderService.processOrderLogic();
                } else if(menuIdx==removeFromCartIdx){
                    cartService.processRemoveLogic();
                }
            } catch (NumberFormatException e) {
                System.out.println("처리에 실패했습니다. 원하는 메뉴 번호를 숫자 형식으로 입력해주세요.");
            } catch (Exception e) {
                System.out.println("처리에 실패했습니다." + e.getMessage());
            }
        }
    }

    private void processMenuItemSelectLogic(Menu selectedMenu) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            printMenuItems(selectedMenu);

            try {
                int itemIdx = getValidInputIdx(0,selectedMenu.getMenuItems().size());
                if(itemIdx == 0) { // 뒤로 가기, 메인 메뉴로 복귀
                    return;
                }

                MenuItem selectedMenuItem = selectedMenu.getMenuItems().get(itemIdx-1);
                System.out.printf("선택한 메뉴 : %s\n\n",selectedMenuItem);
                // 장바구니 추가
                cartService.processAddCartLogic(selectedMenuItem);
                return;
            } catch (NumberFormatException e) {
                System.out.println("처리에 실패했습니다. 정해진 숫자 형식으로 입력해주세요.");
            } catch (Exception e) {
                System.out.println("처리에 실패했습니다. " + e.getMessage());
            }
        }
    }

    public void printMenuCategory() {
        System.out.println("\n[ MAIN MENU ]");
        for(int i=0; i<menus.size(); i++) {
            System.out.printf("%d. %s\n",i+1,menus.get(i).getCategory());
        }
        System.out.println("0. 종료      | 종료");
    }

    public void printMenuItems(Menu menu) {
        System.out.println(menu);
        menu.printMenuItems();
        System.out.println("0. 뒤로가기");
    }

    public void printOrderRelatedMenu(int startIdx) {
        System.out.print("\n[ ORDER MENU ]\n");
        System.out.printf("%d. Orders       | 장바구니를 확인 후 주문합니다.\n",startIdx);
        System.out.printf("%d. Cancel       | 진행중인 주문을 취소합니다.\n",startIdx+1);
    }

    public List<Menu> getMenus() {
        return menus;
    }

    private int getValidInputIdx(int min, int max) {
        Scanner sc = new Scanner(System.in);
        String menuInput = sc.nextLine();
        int menuIdx = Integer.parseInt(menuInput);
        if(menuIdx<min || menuIdx>max) {
            throw new IllegalArgumentException("존재하지 않는 메뉴 번호입니다. 다시 입력해주세요.");
        }
        return menuIdx;
    }
}