package com.example.kiosk.level6.service;

import com.example.kiosk.level6.MenuItem;
import com.example.kiosk.level6.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


// 장바구니 추가 / 삭제 담당
public class CartService {
    // <아이템 이름, 주문 내용>
    private Map<String, Order> cart = new HashMap<>();
    private List<String> options = new ArrayList<>();

    public CartService() {
        options.add("Orders       | 장바구니를 확인 후 주문합니다.");
        options.add("Cancel       | 진행중인 주문을 취소합니다.");
    }

    public void addItem(MenuItem menuItem) {
        if(cart.containsKey(menuItem.getName())) {
            cart.get(menuItem.getName()).addQuantity();
        } else {
            cart.put(menuItem.getName(), new Order(menuItem,1));
        }
    }

    public boolean isCartEmpty() {
        return cart.isEmpty();
    }

    public void printOrders() {
        cart.values().forEach(order -> {
            System.out.printf("%s [%d개]\n",order.getItem(),order.getQuantity());
        });
    }

    public double getTotalPrice() {
        return cart.values().stream().mapToDouble(o->o.getQuantity()*o.getItem().getPrice()).sum();
    }

    public void resetCart() {
        cart.clear();
    }

    public String getOption(int index) {
        return options.get(index);
    }

    public int getSizeOfOptions() {
        return options.size();
    }
}
