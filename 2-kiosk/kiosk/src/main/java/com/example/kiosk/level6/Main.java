package com.example.kiosk.level6;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Burgers 메뉴 생성
        Menu burgerMenu = new Menu("Burgers", new ArrayList<>());
        burgerMenu.getMenuItems().add(new MenuItem("ShackBurger",6.9,"토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgerMenu.getMenuItems().add(new MenuItem("SmokeShack",8.9,"베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgerMenu.getMenuItems().add(new MenuItem("Cheeseburger",6.9,"포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgerMenu.getMenuItems().add(new MenuItem("Hamburger",5.4,"비프패티를 기반으로 야채가 들어간 기본버거"));

        // Drinks 메뉴 생성
        Menu drinksMenu = new Menu("Drinks", new ArrayList<>());
        drinksMenu.getMenuItems().add(new MenuItem("Coke", 2.5, "탄산이 톡 쏘는 콜라"));
        drinksMenu.getMenuItems().add(new MenuItem("Diet Coke", 2.5, "칼로리를 줄인 다이어트 콜라"));
        drinksMenu.getMenuItems().add(new MenuItem("Sprite", 2.5, "상큼한 레몬 라임 맛의 탄산음료"));
        drinksMenu.getMenuItems().add(new MenuItem("Iced Tea", 2.8, "얼음과 함께 제공되는 시원한 아이스 티"));

        // Desserts 메뉴 생성
        Menu dessertsMenu = new Menu("Desserts", new ArrayList<>());
        dessertsMenu.getMenuItems().add(new MenuItem("Vanilla Shake", 4.9, "진한 바닐라 맛의 쉐이크"));
        dessertsMenu.getMenuItems().add(new MenuItem("Chocolate Shake", 4.9, "달콤한 초콜릿 맛의 쉐이크"));
        dessertsMenu.getMenuItems().add(new MenuItem("Strawberry Shake", 4.9, "상큼한 딸기 맛의 쉐이크"));
        dessertsMenu.getMenuItems().add(new MenuItem("Custard", 3.9, "부드럽고 달콤한 커스터드 디저트"));

        // Kiosk 객체 생성
        Kiosk kiosk = new Kiosk(new ArrayList<>());
        kiosk.getMenus().add(burgerMenu);
        kiosk.getMenus().add(drinksMenu);
        kiosk.getMenus().add(dessertsMenu);

        kiosk.start();
    }
}
