package com.example.kiosk.level4;

import java.util.List;

// 캡슐화 : 정보 은닉 적용 X
public class Menu {
    final String category;
    final List<MenuItem> menuItems;

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

    // List를 리턴하는 함수
    public List<MenuItem> getMenuItems() {
        return this.menuItems;
    }

    public String getCategory() {
        return this.category;
    }
}
