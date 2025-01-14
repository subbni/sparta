package com.example.kiosk.level4;

// 캡슐화 : 정보 은닉 적용 X
public class MenuItem {
    private final String name;
    private final double price;
    private final String description;

    public MenuItem(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    // toString 으로 print 내용을 관리
    @Override
    public String toString() {
        return String.format("%-18s | W %.1f | %s",name,price,description);
    }
}
