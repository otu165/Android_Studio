# MVP 패턴
<img src="https://user-images.githubusercontent.com/55652161/122255725-5ef98c00-cf09-11eb-84aa-48e6e54f58e1.png">

1. View 에서 발생한 이벤트 Presenter 로 전달
2. Presenter 에서 전달된 이벤트 처리
    - 필요하다면 Model 과 통신
3. View 로 데이터 전달
4. 전달된 데이터를 베이스로 UI 갱신

View 에서 interface 를 상속받아 구현하고, Presenter 는 구현된 interface 객체를 가진다. 이를 통해 View 와 Presenter 가 상호작용하게 된다. **(interface 가 View 와 Presenter 사이의 Listener 역할을 함)**
<br/>

## 장점
- Model 과 View 사이의 결합도가 낮다. 
- 확장성이 좋다.

<br/>

## 단점
- 어플리케이션이 복잡해지면 View 와 Presenter 사이의 의존성이 강해진다.
- Presenter 에 코드가 집중된다.

<br/>

## 개발 환경

Android Studio 4.2.1