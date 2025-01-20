# CH 2 키오스크 과제
## 🗒️ 프로젝트 설명
### 개발 기간
`2025.01.13` ~ `2025.01.20`
### 개발 인원
1인 (개인)
### 설명
- Java의 문법을 실습하고 객체 지향 개념을 활용합니다.
- 콘솔창으로 메뉴를 출력하고 사용자의 입력을 받아 메뉴를 장바구니에 추가/삭제/조회하며 할인율을 적용하여 결제합니다.
- 필수 기능은 (levl1 ~ level5) 디렉토리에 구현되어 있으며, 도전 기능은 level6 디렉토리에 구현되어 있습니다.
### 사용 기술
![](https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=OpenJDK&logoColor=white")
![](https://img.shields.io/badge/intellijidea-000000?style=for-the-badge&logo=intellijidea&logoColor=white")
### 파일 구조
```
kiosk
├── level1
│   └── Main.java
├── level2
│   ├── Main.java
│   └── MenuItem.java
├── level3
│   ├── Kiosk.java
│   ├── Main.java
│   └── MenuItem.java
├── level4
│   ├── Kiosk.java
│   ├── Main.java
│   ├── Menu.java
│   └── MenuItem.java
├── level5
│   ├── Kiosk.java
│   ├── Main.java
│   ├── Menu.java
│   └── MenuItem.java
└── level6
    ├── Cart.java
    ├── Kiosk.java
    ├── Main.java
    ├── Menu.java
    ├── MenuItem.java
    ├── constant
    │   └── DiscountGroup.java
    └── service
        ├── CartService.java
        └── OrderService.java

```
## 🗒️ 구현 내용
## `Lv.1` 기본적인 키오스크 
#### [요구사항](https://github.com/subbni/sparta/issues/10)
#### `Main` class 내에서 아래의 기능을 수행합니다.
1. 여러 햄버거 메뉴를 출력합니다.
2. 0이 입력되면 프로그램을 종료합니다.

## `Lv.2` 햄버거 메뉴를 클래스로 관리
#### [요구사항](https://github.com/subbni/sparta/issues/10)
#### 1. `MenuItem` class가 추가되었습니다. 
- 이름(name), 가격(price), 설명(description) 필드를 갖습니다.
#### 2. `Main` class가 수정되었습니다.
- `List<MenuItem>` 리스트를 생성하여 햄버거 메뉴들을 관리하고, 출력합니다.
- 사용자가 메뉴 아이템의 번호를 입력할 시, 선택한 메뉴의 정보를 다시 한 번 출력합니다.

## `Lv.3` 순서 제어를 클래스로 관리
#### [요구사항](https://github.com/subbni/sparta/issues/10)
#### 1. `Kiosk` class가 추가되었습니다.
- `List<MenuItems>` 필드를 갖습니다.
- `start()` 메서드 내에서 이전 키오스크 로직을 모두 수행합니다.
- 유효하지 않은 입력이 들어올 경우 오류 메세지를 출력합니다.
#### 2. `Main` class가 수정되었습니다.
- `List<MenuItem>` 리스트를 생성한 뒤, 이를 필드로 가지는 Kiosk 인스턴스를 생성합니다.
- `kiosk.start()` 메서드 호출을 통해 키오스크 로직을 실행합니다.
- 

## `Lv.4` 음식 메뉴와 주문 내역을 클래스 기반으로 관리
#### [요구사항](https://github.com/subbni/sparta/issues/10)
#### 1. `Menu` class가 추가되었습니다.
- 카테고리(category), 메뉴 아이템 리스트(List<MenuItem>) 필드를 갖습니다.
- 메뉴 아이템의 상위 개념을 정의한 클래스입니다. (ex. Burgers, Drinks, Desserts)
#### 2. `Kiosk` class가 수정되었습니다.
- `List<MenuItem>`이 아닌 `List<Menu>` 필드를 갖습니다.
- `start()` 메서드에서 상위 메뉴(카테고리)를 먼저 선택한 뒤, 사용자가 선택한 카테고리의 메뉴 아이템을 출력합니다.
- 메뉴 아이템 조회 중 0을 입력할 시 `뒤로 가기`로 인해 상위 메뉴(카테고리) 조회로 돌아갑니다.
#### 실행 예시
<img width="488" alt="Screenshot 2025-01-20 at 11 02 18" src="https://github.com/user-attachments/assets/b84c93f4-be37-486f-96de-110343e4d726" />

## `Lv.5` 캡슐화 적용
#### [요구사항](https://github.com/subbni/sparta/issues/10)
#### 1. `Menu` class가 수정되었습니다.
- 필드를 private으로 설정하여 `getCategory()`, `getMenuItems()`를 통해서만 조회 가능하도록 합니다.
#### 2. `MenuItem` class가 수정되었습니다.
- 필드를 private으로 설정하여 getter를 통해서만 조회 가능하도록 합니다.
#### 3. `Main` class가 수정되었습니다. 
- Menu의 MenuItems를 `getMenuItems()`를 통해 접근합니다.
---
## `Lv.6` 장바구니 / 결제 기능 추가
#### [요구사항](https://github.com/subbni/sparta/issues/12)
#### 1. `Cart` class가 추가되었습니다.
- 필드로 `Map<MenuItem,Integer>` 장바구니 데이터를 갖습니다.
- 장바구니 데이터의 추가/삭제/조회와 같은 기능을 제공합니다.
#### 2. `CartService` class가 추가되었습니다.
- 필드로 `Cart`를 갖습니다.
- 장바구니와 관련된 비즈니스 로직과 입출력을 처리합니다.
- 사용자 입력에 따라 장바구니 추가/삭제/조회를 실제 수행합니다.
#### 3. `DiscountGroup` enum이 추가되었습니다.
- 사용자 유형에 따른 할인율을 상수로 관리합니다.
- 각 상수는 고유 id(`id`), 한글 이름(`koreanName`), 할인율(`discountRate`)을 필드로 갖습니다.
- `fromId(int id)` 메서드는 해당 id를 갖는 DiscountGroup을 반환합니다.
#### 4. `OrderService` class가 추가되었습니다.
- 필드로 `CartService`를 갖습니다.
- 주문과 관련된 비즈니스 로직과 입출력을 처리합니다.
- 주문 시 할인 유형을 선택하도록 하여, 해당 할인율이 적용된 최종 금액을 사용자에게 출력합니다.
- 주문이 끝나면 cartService를 통해 장바구니의 내용을 모두 삭제합니다.
#### 5. `Kiosk` class가 수정되었습니다.
- 필드에 `CartService`, `OrderService`가 추가되었습니다.
- '메뉴 카테고리 선택' & '메뉴 아이템 선택'의 로직만을 수행하고, 이후의 로직은 cartService와 orderService에게 책임을 위임합니다.
#### 실행 예시
- 장바구니 추가
  - <img width="520" alt="장바구니추가" src="https://github.com/user-attachments/assets/830dce2c-0941-40c4-83c3-af4b1ca059b7" />
- 장바구니에서 삭제
  - <img width="576" alt="장바구니빼기" src="https://github.com/user-attachments/assets/96a5e7ac-7062-4463-ac55-d7aa3d01fd57" />
- 장바구니에서 전부 삭제
  - <img width="574" alt="장바구니전부빼기" src="https://github.com/user-attachments/assets/f9a590e1-61a8-44b8-8d7a-de3aa13cf62e" />
- 주문
  - <img width="472" alt="주문" src="https://github.com/user-attachments/assets/d2a8f9c6-9890-4df3-ad9b-d680ea39c371" />

