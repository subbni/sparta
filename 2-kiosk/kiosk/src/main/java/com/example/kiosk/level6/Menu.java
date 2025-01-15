package com.example.kiosk.level6;

import java.util.List;
public class Menu {
    private final String category;
    private final List<MenuItem> menuItems;

    public Menu(String category, List<MenuItem> menuItems) {
        this.category = category;
        this.menuItems = menuItems;
    }

    // List에 들어있는 MenuItem을 순차적으로 보여주는 함수
    public void printMenuItems() {
        for(int i=0; i<menuItems.size(); i++) {
            System.out.print(i+1 + ". ");
            System.out.println(menuItems.get(i));
        }
    }

    public String getCategory() {
        return category;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }
}
