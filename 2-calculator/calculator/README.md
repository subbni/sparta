# CH 2 계산기 과제
## 🗒️ 프로젝트 설명
### 개발 기간
`2025.01.02` ~ `2025.01.09`
### 개발 인원
1인 (개인)
### 설명
- Java의 문법을 실습하고 객체 지향 개념을 활용합니다.
- 콘솔창으로 사용자의 입력을 받고 사칙연산`(더하기, 빼기, 곱하기,나누기)`을 수행하는 계산기를 구현합니다.
- 각 레벨의 요구사항에 따라 level1, level2, level3 디렉토리로 구분되어 구현되어 있습니다.
### 사용 기술
![](https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=OpenJDK&logoColor=white")
![](https://img.shields.io/badge/intellijidea-000000?style=for-the-badge&logo=intellijidea&logoColor=white")
### 파일 구조
```
calculator
    ├── level1
    │   └── App.java
    ├── level2
    │   ├── App.java
    │   └── Calculator.java
    └── level3
        ├── App.java
        ├── ArithmeticCalculator.java
        ├── constant
        │   └── OperatorType.java
        └── util
            ├── NumberListFilter.java
            └── NumberParser.java
```
## 🗒️ 구현 내용
## `Lv.1` 단일 클래스 계산기 구현
#### [요구사항](https://github.com/subbni/sparta/issues/1)

#### [`App`](https://github.com/subbni/sparta/blob/main/2-calculator/calculator/src/main/java/com/example/calculator/level1/App.java) class 내에서 아래의 기능을 모두 수행합니다.

1. 양의 정수(0 포함)를 입력받습니다.
2. 사칙연산 기호(+,-,*,/)를 입력받습니다. 
3. 입력 받은 정수와 사칙연산 기호를 사용하여 연산을 진행합니다.
   - 다음 내용에 해당할 경우, 오류 내용을 출력한 후 5번 내용을 수행합니다.
      - 입력받은 정수가 음수일 경우
      - 입력 받은 기호가 사칙연산 기호가 아닐 경우
      - 나눗셈 연산 기호와 함께 두 번째 정수(secondNum)로 0이 들어올 경우 (0으로 수를 나눌 수 없음)
5. 연산 결과를 출력합니다.
6. 종료 여부를 확인합니다.
   - 사용자가 `exit`을 입력하면 반복을 종료합니다.
   - 그 외의 경우 다시 1번부터 반복합니다. 
   
### 실행 예시
<img width="427" alt="Screenshot 2025-01-09 at 15 03 30" src="https://github.com/user-attachments/assets/93432914-c817-45e1-a4c6-2547c8cf5f45" />

## `Lv.2` 계산기 클래스를 사용한 계산기 구현
#### [요구사항](https://github.com/subbni/sparta/issues/2)
#### 1. [`Calculator`](https://github.com/subbni/sparta/blob/main/2-calculator/calculator/src/main/java/com/example/calculator/level2/Calculator.java) class가 추가되었습니다. 
- `LinkedList<Double> results` 필드를 갖습니다.
  - 연산 결과를 저장합니다.
  - 맨 앞에 저장된 데이터를 삭제하는 로직이 요구되어 ArrayList가 아닌 LinkedList를 사용하였습니다.
- `calculate(firstNum,secondNum,operator)`로 사칙연산을 수행한 후 결과값을 반환합니다.
   - 연산 오류가 발생할 경우 Exception이 발생합니다.
- `getLastResult()` 로 가장 최근에 저장된 결과를 가져옵니다.
- `addResult(result)`로 결과를 추가 저장합니다.
- `removeOldestResult()`로 맨 앞에 저장된(가장 처음에 저장된) 데이터를 삭제합니다.
- `getSizeOfResults()`로 현재 저장된 결과의 수를 가져옵니다.

#### 2. [`App`](https://github.com/subbni/sparta/blob/main/2-calculator/calculator/src/main/java/com/example/calculator/level2/App.java) class가 수정되었습니다.
- while 반복문을 들어가기 앞서 `Calculator` 인스턴스(calculator)를 생성합니다.
- while 반복문에서 연산 시 calculator 메서드 `calculate`를 사용하고, 즉시 calculator 메서드 `addResult`를 이용하여 결과를 저장합니다.
- 연산이 성공적으로 완료된다면 calculator에 저장된 결과의 수를 확인하여, 10 이상일 경우 맨 앞에 저장된 결과를 삭제 처리합니다.
   -  "App 클래스의 main 메서드에 삭제 메서드가 활용될 수 있도록 수정"하라는 요구사항에 맞춰 임의로 추가한 로직입니다.


##### 실행 결과는 Lv.1의 내용과 같아 예시는 생략합니다.

## `Lv.3` Enum,Generics,Lambda,Stream을 활용한 계산기 구현
#### [요구사항](https://github.com/subbni/sparta/issues/3)

#### 1. [`OperatorType`](https://github.com/subbni/sparta/blob/main/2-calculator/calculator/src/main/java/com/example/calculator/level3/constant/OperatorType.java) enum이 추가되었습니다. 
- 계산기가 수행할 수 있는 연산 로직들(`+ - * /`)을 상수로 관리합니다.
- 각 연산에 대응하는 기호 값을 멤버변수 String `symbol`로 갖습니다.
- `fromSymbol(String symbol)` 메서드는 통해 각 기호를 갖는 OperatorType를 반환합니다.
- 추상메서드 `operate(Number a, Number b)`를 모든 열거형 상수가 구현하여 자신의 연산을 수행하고 결과값을 반환합니다.
#### 2. [`NumberParser`](https://github.com/subbni/sparta/blob/main/2-calculator/calculator/src/main/java/com/example/calculator/level3/util/NumberParser.java) class가 추가되었습니다.
- `parse(String number)` 메서드는 입력 문자열의 소수점(`.`) 포함 여부에 따라 문자열을 Double 또는 Integer로 변환하여 반환합니다.
#### 3. [`NumberListFilter`](https://github.com/subbni/sparta/blob/main/2-calculator/calculator/src/main/java/com/example/calculator/level3/util/NumberListFilter.java) class가 추가되었습니다.
- 각 메서드는 Number의 자손 타입을 요소로 가지는 `List`와 `기준 값`을 매개변수로 받습니다.
- 기준 값을 사용하여 필터링 한 후, 조건에 맞는 요소들로 구성된 List를 반환합니다.
#### 4. [`ArithmeticCalculator`](https://github.com/subbni/sparta/blob/main/2-calculator/calculator/src/main/java/com/example/calculator/level3/ArithmeticCalculator.java) class가 추가되었습니다.
- Lv.2 의 Calculator 클래스에서 구현한 내용을 포함합니다.
- `<T extends Number>` 타입변수를 갖는 제네릭 클래스입니다.
- `calculate` 메서드가 변경되었습니다.
  - `(T firstNum, T secondNum, String operator)`로 Integer와 Double 타입을 모두 매개변수로 받을 수 있습니다.
  - `firstNum,secondNum`의 조합으로 `Integer,Integer`, `Integer,Double`, `Double,Double`,`Double,Integer` 모두 가능합니다.
  - `OperatorType.calculate` 메서드를 이용하여 연산을 수행합니다.
  - 연산 수행 결과를 멤버변수 `results`에 저장합니다.
- 매개변수로 받은 값을 기준으로 저장된 연산 결과를 필터링하여 출력하는 메서드가 추가되었습니다.
  - `printResultsGreaterThan` , `printResultsLessThan`, `printResultsEqualTo`
  - `NumberListFilter`의 static 메서드를 사용하여 필터링한 리스트를 받아옵니다.
- `joinToString` 메서드가 추가되었습니다.
  - 필터링 결과를 하나의 문자열로 묶어 반환합니다.
#### 5. [`App`](https://github.com/subbni/sparta/blob/main/2-calculator/calculator/src/main/java/com/example/calculator/level3/App.java) class가 변경되었습니다.
- while 반복문을 들어가기 앞서 `ArithmeticCalculator<Number>` 인스턴스(calculator)를 생성합니다.
- 사용자로부터 받아온 입력 값을 `NumberParser.parse`메서드를 사용하여 Integer/Double로 변환한 뒤, `calculate` 메서드의 매개변수로 넣어 연산합니다.
- 기준 값을 입력 받고 `ArithmeticCalculator`의 각 필터링 출력 메서드로 조회합니다.

### 실행 예시
- <img width="300" alt="Screenshot 2025-01-09 at 15 46 35" src="https://github.com/user-attachments/assets/f31f76c8-e7ac-46e0-b029-e0c75a4cffa4" />

- <img width="300" alt="Screenshot 2025-01-09 at 15 46 44" src="https://github.com/user-attachments/assets/5b0f39b5-f683-442f-aa75-a0eee7b8fdcc" />

- <img width="300" alt="Screenshot 2025-01-09 at 15 47 13" src="https://github.com/user-attachments/assets/5c027b1f-b767-477b-a4b0-24a0549b60a4" />

