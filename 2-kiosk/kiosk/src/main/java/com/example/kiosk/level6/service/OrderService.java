package com.example.kiosk.level6.service;

import com.example.kiosk.level6.constant.DiscountGroup;

import java.util.Scanner;

public class OrderService {
    private final CartService cartService;

    public OrderService(CartService cartService) {
       this.cartService = cartService;
    }

    public void processOrder() {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.print("\n아래와 같이 주문 하시겠습니까?\n\n");
            System.out.print("[ Orders ]\n");
            cartService.printOrders();
            System.out.print("\n[ Total ]\n");
            System.out.printf("W %.1f\n\n",cartService.getTotalPrice());
            System.out.println("1. 주문      2. 주문 빼기      3. 메뉴판 ");

            String inputStr = sc.nextLine();
            if("1".equals(inputStr)) { // 주문 처리
                DiscountGroup discountGroup = selectDiscountGroup();
                double discountedPrice = cartService.getTotalPrice() * (1-discountGroup.getDiscountRate());
                System.out.printf("주문이 완료되었습니다. 금액은 W %.1f 입니다.\n",discountedPrice);
                cartService.resetCart();
                return;
            } else if("2".equals(inputStr)) { // 주문 빼기
                cartService.processRemoveItem();
                if(cartService.isCartEmpty()) {
                    System.out.print("\n장바구니가 비었습니다. 메인 화면으로 돌아갑니다.\n");
                    return;
                }
            } else if("3".equals(inputStr)) { // 메뉴판으로 돌아가기
                return;
            }
        }
    }

    private DiscountGroup selectDiscountGroup() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\n할인 정보를 입력해주세요.\n");
        for(DiscountGroup group : DiscountGroup.values()) {
            System.out.printf("%d. %s : %.0f%%\n",group.getId(),group.getKoreanName(),group.getDiscountRate()*100);
        }

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

}
