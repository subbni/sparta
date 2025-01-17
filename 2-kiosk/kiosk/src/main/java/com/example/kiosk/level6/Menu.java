package com.example.kiosk.level6;

import java.util.List;
import java.util.stream.IntStream;

public class Menu {
    private final String category;
    private final List<MenuItem> menuItems;

    public Menu(String category, List<MenuItem> menuItems) {
        this.category = category;
        this.menuItems = menuItems;
    }

    // Lambda & Stream 사용
    public void printMenuItems() {
        IntStream.range(0,menuItems.size())
                .forEach(idx -> System.out.printf("%d. %s\n",idx+1,menuItems.get(idx)));
    }

    public String getCategory() {
        return category;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n").append("[ ").append(category.toUpperCase()).append(" MENU ]");
        return sb.toString();
    }
}
