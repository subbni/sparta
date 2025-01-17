package com.example.kiosk.level6;
import com.example.kiosk.level6.service.CartService;
import com.example.kiosk.level6.service.OrderService;

import java.util.List;
import java.util.Scanner;

// 프로그램 순서 및 흐름 제어를 담당
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

        while(true) {
            // 1. 상위 메뉴 출력
            printMainMenu();
            // 1-2. 장바구니에 담은 주문이 있을 경우 장바구니 메뉴 출력
            int maxIdx = menus.size();
            if(!cartService.isCartEmpty()) {
                printCartMenu();
                maxIdx+=2;
            }

            try {
                // 2. 상위 메뉴 번호 입력 받기
                int menuIdx = getValidInputIdx(0,maxIdx);

                if(menuIdx == 0) {
                    // 종료 조건, 키오스크 종료 처리
                    return;
                } else if(menuIdx<= menus.size()) {
                    // 3. 하위 메뉴 로직 처리
                    Menu selectedMenu = menus.get(menuIdx-1);
                    processSubMenu(sc,selectedMenu);
                } else if(menuIdx==menus.size()+1){
                    // 4. 장바구니 로직 - 주문 처리
                    orderService.processOrder();
                } else if(menuIdx== menus.size()+2){
                    // 5. 장바구니 로직 - 취소 처리
                    System.out.println("진행 중인 주문이 취소되었습니다.");
                    cartService.resetCart();
                }
            } catch (NumberFormatException e) { // 숫자 형식이 아닌 경우
                System.out.println("처리에 실패했습니다. 원하는 메뉴 번호를 숫자 형식으로 입력해주세요.");
            } catch (Exception e) {
                System.out.println("처리에 실패했습니다." + e.getMessage());
            }
        }
    }

    private void processSubMenu(Scanner sc, Menu selectedMenu) {
        while(true) {
            // 1. 하위 메뉴 출력
            printMenuItems(selectedMenu);

            try {
                // 2. 메뉴 아이템 숫자 입력 받기
                int inputIdx = getValidInputIdx(0,selectedMenu.getMenuItems().size());

                if(inputIdx == 0) {
                    // 뒤로 가기, 메인 메뉴로 복귀
                    return;
                }

                MenuItem selectedMenuItem = selectedMenu.getMenuItems().get(inputIdx-1);
                System.out.printf("선택한 메뉴 : %s\n\n",selectedMenuItem);

                // 3. 장바구니 추가 로직
                processAddCart(selectedMenuItem);
                return;
            } catch (NumberFormatException e) { // 숫자 형식이 아닌 경우
                System.out.println("처리에 실패했습니다. 정해진 숫자 형식으로 입력해주세요.");
            } catch (Exception e) {
                System.out.println("처리에 실패했습니다. " + e.getMessage());
            }
        }
    }

    private void processAddCart(MenuItem menuItem) {
        Scanner sc = new Scanner(System.in);
        System.out.println(menuItem);
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인        2. 취소");

        while (true) {
            String addCartInput = sc.nextLine();
            if("1".equals(addCartInput)) {
                cartService.addItem(menuItem);
                System.out.println();
                System.out.println(menuItem.getName()+" 이 장바구니에 추가되었습니다.");
                return;
            } else if ("2".equals(addCartInput)) {
                return;
            }
        }
    }

    private void printMainMenu() {
        System.out.println("\n[ MAIN MENU ]");
        for(int i=0; i<menus.size(); i++) {
            System.out.printf("%d. %s\n",i+1,menus.get(i).getCategory());
        }
        System.out.println("0. 종료      | 종료");
    }

    private void printCartMenu() {
        System.out.println("\n[ ORDER MENU ]");
        for(int i=0; i<cartService.getSizeOfOptions(); i++) {
            System.out.printf("%d. %s\n",menus.size()+i+1,cartService.getOption(i));
        }
    }

    private void printMenuItems(Menu menu) {
        System.out.println(menu);
        menu.printMenuItems();
        System.out.println("0. 뒤로가기");
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