package com.example.kiosk.level6;

public class Order {
    private final MenuItem item;
    private int quantity;

    public Order(MenuItem item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public void addQuantity() {
        quantity++;
    }

    public MenuItem getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getItemName() {
        return item.getName();
    }
}
