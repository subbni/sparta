package com.example.kiosk.level6.service;

import com.example.kiosk.level6.constant.DiscountGroup;

import java.util.Scanner;

/**
 * 주문, 결제와 관련된 로직 처리
 * 주문 내용 조회 / 할인 결정 / 결제
 */

public class OrderService {
    private final CartService cartService;

    public OrderService(CartService cartService) {
       this.cartService = cartService;
    }

    // 주문 로직
    public void processOrderLogic() {
        Scanner sc = new Scanner(System.in);
        while(true) {
            printCartItemsAndTotalPrice();
            System.out.println("1. 주문      2. 메뉴판");

            String inputStr = sc.nextLine();
            if("1".equals(inputStr)) {
                processOrder();
                return;
            } else if("2".equals(inputStr)) {
                return;
            } else {
                System.out.println("정해진 번호를 입력해주세요.");
            }
        }
    }

    private void processOrder() {
        DiscountGroup discountGroup = processAndGetDiscountGroup();
        double discountedPrice = getDiscountedPrice(discountGroup, cartService.getTotalPrice());
        cartService.resetCart();
        System.out.printf("주문이 완료되었습니다. 금액은 W %.1f 입니다.\n",discountedPrice);
    }

    // 할인 그룹 결정 후 반환
    private DiscountGroup processAndGetDiscountGroup() {
        Scanner sc = new Scanner(System.in);
        printDiscountGroup();

        while(true) {
            try {
                String inputStr = sc.nextLine();
                int selectedGroupId = Integer.parseInt(inputStr);
                if(selectedGroupId<1 || selectedGroupId>DiscountGroup.values().length) {
                    throw new IllegalArgumentException("존재하지 않는 번호입니다.");
                }
                return DiscountGroup.fromId(selectedGroupId);
            } catch(NumberFormatException e) {
                System.out.println("처리에 실패했습니다. 정해진 숫자 형식으로 입력해주세요.");
            } catch(Exception e) {
                System.out.println("처리에 실패했습니다. "+e.getMessage());
            }
        }
    }

    private void printCartItemsAndTotalPrice() {
        System.out.print("\n아래와 같이 주문 하시겠습니까?\n\n");
        System.out.print("[ Orders ]\n");
        cartService.printCartItems();
        System.out.print("\n[ Total ]\n");
        System.out.printf("W %.1f\n\n",cartService.getTotalPrice());
    }

    private void printDiscountGroup() {
        System.out.print("\n할인 정보를 입력해주세요.\n");
        for(DiscountGroup group : DiscountGroup.values()) {
            System.out.printf("%d. %s : %.0f%%\n",group.getId(),group.getKoreanName(),group.getDiscountRate()*100);
        }
    }

    private double getDiscountedPrice(DiscountGroup discountGroup, double price) {
        return price * (1-discountGroup.getDiscountRate());
    }
}
