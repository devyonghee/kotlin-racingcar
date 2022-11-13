# 2단계 미션 kotlin-racingcar

##  기능 요구 사항
> 사용자가 입력한 문자열 값에 따라 사칙 연산을 수행할 수 있는 계산기를 구현해야 한다.
>
문자열 계산기는 사칙 연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다.
즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
예를 들어 "2 + 3 * 4 / 2"와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.


## 기능 목록
[Operator] 사칙 연산자 담당 클래스
* Enum 클래스를 활용하여 사친연산 정의 및 연산 기호에 따른 계산

[Expression]
* Split으로 분리된 문자열을 저장하는 일급 컬렉션 클래스
* 유효한 식인지를 확인하고 계산하는 클래스

[Parser] 문자열 파싱 담당 클래스
* 문자열에서 Expression(일급 컬렉션)으로 변환

[Calculator] 계산기 클래스
* 계산을 진행하는 클래스


[요구사항]
* 더하기 기능 구현
* 빼기 기능 구현
* 곱하기 기능 구현
* 나누기 기능 구현
  * 0으로 나눌 수 없다.
* 문자열 파싱 기능 구현
  * String으로 들어오는 문자열 값을 파싱하여 계산을 진행할 수 있다.
  * 빈 값이나 null로 들어오는 값은 계산을 진행할 수 없다.
  * 연산자와 피연산자의 개수의 합은 최소 3개 이상이어야하며, 홀수 개의 연산자와 짝수 개의 피연산자로 이루어져야한다.

---

##  기능 요구 사항
> 초간단 자동차 경주 게임을 구현한다.
>
* 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다. 
* 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다. 
* 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다. 
* 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.

## 기능 목록
[MoveCondition] 이동 조건 인터페이스
* 이동할 수 있는 조건은 다양해질 수 있다는 가정하에 생성
* 현재는 랜덤하게 움직일 수 있는 케이스의 구현체만 생성

[Car] 차 객체
* 실제로 움직이는 차 객체를 생성 (이름, 위치)
* MoveCondition을 기반으로 움직일 수 있는지 확인 (현재는 만족하는 조건이 존재한다면 이동가능하다고 가정)
* 움직일 수 있다면 이동

[Cars] 차 객체를 래핑하는 일급 컬렉션
* 차의 개수를 기반으로 차를 생성
* 모든 차는 Cars의 move 메서드로 한 번에 이동할 수 있도록 구현
* 모든 차의 이동 결과를 Record로 반환

[Game] 실제 게임을 진행하는 객체
* 게임은 여러 라운드로 구성되어 있을 수 있으므로 하나의 객체로 구성
* 게임에서 입력받은 값(차의 개수, 시도 횟수)을 기반으로 게임을 진행
* 최종 결과(기록들의 리스트)를 반환

[CarApplication] 메인 함수
* 실제 입력과 출력을 담당
* 입력받은 값을 기반으로 Game을 생성해 진행하고 출력

예외는 따로 상수로 처리하였습니다.
확장함수는 별도의 프로젝트라 가정하여 새로 생성하여 추가하였습니다.

## 요구사항

[입출력]
- 입력값을 받을 수 있어야 한다. (현재는 게임이 한 번 실행된다고 가정한다.)
  - 자동차가 0대일 경우, 즉시 종료한다.
  - 시도 횟수가 0일 경우, 즉시 종료한다.
- 출력값을 내보낼 수 있어야 한다.
  - 결과 값은 한 번에 출력한다.

[자동차]
- 자동차는 이동하는 함수를 통해 이동할 수 있다.
  - 현재는 1만큼만 이동한다고 가정한다.
- 자동차는 현재 자신의 위치를 표현할 수 있어야 한다.

[전진 조건]
- 전진하는 조건에 따라, 자동차가 움직인다.
- 전진하는 조건은 여러가지일 수 있다.
  - 현재는 전진하는 조건은 하나라도 만족하면 전진 가능하다고 가정한다.
- 현재 전진 조건은 랜덤한 값을 기준으로 4이상이면 전진한다.
  - 랜덤한 값을 생성할 수 있다.
  - 4 이상을 판별할 수 있다.

## 추가 요구사항
[입출력]
- 이 전에는 자동차의 개수를 받았지만, 경주할 자동차 이름을 받는다. 
  - 자동차의 이름은 5자를 초과할 수 없다. 
  - 자동차의 이름은 쉼표를 기준으로 구분한다.
- 이에 따라, 기존에 숫자로 공통으로 입력받아 처리하던 예외를 분리해야하는 필요성이 생김 (하나는 String, 하나는 Int) 
  - Validator 객체를 추가해 각각에 대해 검증할 수 있도록 구현한다. 
- 각각의 자동차 별로 시행 횟수마다의 경주 결과를 확인할 수 있다. 
  - 자동차의 이름도 같이 확인할 수 있다.

[자동차]
- 자동차는 자신의 위치뿐 아니라, 자신의 이름도 함께 표현할 수 있다.

[게임]
- 자동차의 위치를 기준으로 우승자를 선정할 수 있다. 
  - 우승자는 여러 명일 수 있다.