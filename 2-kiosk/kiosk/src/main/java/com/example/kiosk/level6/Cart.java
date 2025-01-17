package com.example.kiosk.level6;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    private final Map<MenuItem, Integer> cartItems = new HashMap<>();

    public void add(MenuItem menuItem) {
        cartItems.put(menuItem, cartItems.getOrDefault(menuItem,0)+1);
    }

    public void remove(MenuItem menuItem) {
        cartItems.remove(menuItem);
    }

    public boolean isEmpty() {
        return cartItems.isEmpty();
    }

    public void reset() {
        cartItems.clear();
    }

    public List<MenuItem> getMenuItemsList() {
        return cartItems.keySet().stream().toList();
    }

    public double getTotalPrice() {
        return cartItems.keySet().stream()
                .mapToDouble(item -> item.getPrice() * cartItems.get(item))
                .sum();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        cartItems.keySet()
                .forEach((item)-> sb.append(item.toString()).append(" [").append(cartItems.get(item)).append("개]\n"));
        return sb.toString();
    }
}
