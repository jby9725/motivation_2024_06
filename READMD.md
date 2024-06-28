## 과정

- 목표 : motivation app 만들기
  - 기능구현 : CRUD
  - C : Create
  - R : Read
  - U : Update
  - D : Delete

1. 초기세팅
   - 깃허브에 생성한 프로젝트를 올려두었다.
2. motivation 종료 구현, motivation 추가 구현중
   - 사용자에게 입력받은 문자열로 'exit'가 입력되기 전까지는 프로그램을 종료하지 않도록 하였다.
   - motivation에 들어갈 원작자(source)와 내용(body)의 내용을 입력받기까지 기능을 구현하였다.
3. motivation add, motivation list 구현
   - motivation을 하나의 객체로 보고 Article 클래스를 만들었고, 이를 App에서 리스트로 저장하도록 하였다.
   - 'add' 입력할 때마다 source와 body를 Article 객체 하나가 만들어지도록 하고 이를 Article 리스트에 저장하였다.
   - 'list' 입력하면 저장되어있는 Article 객체들의 정보를 출력하도록 하였다.
4. Article class 파일 분리
   - 3번까지의 과정에서 Main.java와 App.java로 시작점 / 그 외 모든 것으로 파일을 나누어 컨트롤 한 것을 좀 더 직관적으로 바꾸기 위해 Article.java를 추가하고 Article class를 이동시켰다.
5. source의 길이가 너무 길 때 축약하여 출력
   - motivation들을 출력할 때 source의 길이가 너무 길 경우 출력이 이쁘게 되지 않는 것을 바꾸었다.
6. 모듈 분리, 패키지 이동
   - 추후에 더 발전할 코드를 위해 미리 기능과 역할 별로 모듈을 분리하여 패키지와 클래스를 틀만 만들어두었다.
7. 분리한 클래스를 기능에 따라 구현
   - Main.java : 프로그램의 시작점. App을 실행시킨다.
   - App.java : 프로그램이 무슨 기능을 할지 판별하여 전달하는 역할을 한다. 안내자.
   - Article.java : Motivation class. 하나하나가 가질 속성과 그에 따라 필요한 기능을 구현한 메소드가 있다.
   - SystemController.java : System 관련 기능이 구현된 클래스 (현재 exit만)
   - MotivationController.java : Motivation 관련 기능이 구현된 클래스 (현재 add, list만)
8. 각기 다른 클래스에서도 접근할 수 있는 Container class 생성
   - 현재까지의 기능을 구현했을 때, 이전까지는 메인에서 생성한 스캐너를 App class, MotivationController class에서 잇따라 전달받아 사용하고 있다.
   - 이 구조를 개선하여 따로 어느 클래스든 접근할 수 있는 전역 공간을 만들고(class Container) 잇따라 전달받는 것을 삭제하고 바로 전역 공간에서 접근할 수 있도록 변경하였다.
9. motivation delete 기능 추가
   - 명령어로 받은 문자열을 사전에 정의된 규칙에 따라 파싱하여 유의미한 값을 이용하여 motivation들 중 하나를 지우는 기능을 추가하였다.
   - 유의할 점 : index 값이 아니라 id 값을 넘겨받았기 때문에 id 값이 매칭하는 것이 어느 인덱스에 있는지 찾아야할 필요가 있었다.
   - 지정한 id값을 가진 motivation이 없을 경우도 처리하였다.
