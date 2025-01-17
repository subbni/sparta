package com.example.kiosk.level6.service;

import com.example.kiosk.level6.Cart;
import com.example.kiosk.level6.MenuItem;

import java.util.*;


/**
 * 장바구니와 관련된 로직 처리
 * 장바구니 추가 / 제거 / 조회
 */

public class CartService {
    private final Cart cart = new Cart();

    // 장바구니에 추가
    public void processAddCartLogic(MenuItem menuItem) {
        Scanner sc = new Scanner(System.in);
        System.out.println(menuItem);
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인        2. 취소");

        while (true) {
            String inputStr = sc.nextLine();
            if("1".equals(inputStr)) {
                cart.add(menuItem);
                System.out.println();
                System.out.println(menuItem.getName()+" 이(가) 장바구니에 추가되었습니다.");
                return;
            } else if ("2".equals(inputStr)) {
                return;
            } else {
                System.out.println("정해진 번호를 입력해주세요.");
            }
        }
    }

    // 장바구니에서  제거
    public void processRemoveLogic() {
        Scanner sc = new Scanner(System.in);
        while(true) {
            if(cart.isEmpty()) {
                System.out.print("\n장바구니가 비었습니다. 메인 화면으로 돌아갑니다.\n");
                return;
            }

            System.out.print("\n[ Orders ]\n");
            printCartItems();
            System.out.print("\n어떤 메뉴를 빼시겠습니까? 메뉴명을 입력해주세요. (cancel : 메뉴판으로 돌아가기 / all : 전부 빼기)\n");

            String inputStr =  sc.nextLine();
            if("cancel".equals(inputStr)) {
                return;
            }else if("all".equals(inputStr)) {
                cart.reset();
                continue;
            }

            try {
                System.out.printf("\n%s 이(가) 장바구니에서 제거되었습니다.\n",removeItemByName(inputStr).getName());
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private MenuItem removeItemByName(String inputName) {
        MenuItem selectedItem = cart.getMenuItemsList().stream()
                .filter((menuItem -> menuItem.getName().equalsIgnoreCase(inputName)))
                .findFirst()
                .orElseThrow(()-> {throw new IllegalArgumentException("메뉴가 존재하지 않습니다. 다시 입력해주세요.");});
        cart.remove(selectedItem);
        return selectedItem;
    }

    public void printCartItems() {
        System.out.print(cart);
    }

    public boolean isCartEmpty() {
        return cart.isEmpty();
    }

    public void resetCart() { cart.reset(); }

    public double getTotalPrice() {
        return cart.getTotalPrice();
    }
}
