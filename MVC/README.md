# MVC 패턴
<img src="https://user-images.githubusercontent.com/55652161/122243165-de359280-cefe-11eb-90cf-0a21b1b4819f.png">

1. Activity 에서 사용자 이벤트 발생
2. Controller 는 Model 로부터 데이터의 갱신을 확인함
3. 필요하다면 Model 에서 데이터를 받아옴
4. 전달받은 데이터를 기반으로 UI 를 갱신함

<br/>

## 장점
- 구현이 쉽다.
- Model 과 View 를 분리할 수 있다.
- 개발 기간이 짧다.

<br/>

## 단점
- Model 과 View 사이 의존성이 발생한다.
- 코드 분리가 제대로 이루어지지 않는다면 스파게티 코드가 된다.
- Controller 에 코드가 치중된다.

<br/>

## 개발 환경

Android Studio 4.2.1

