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
10. 명령어 분석 기능이 들어간 RequestProcesser 클래스 추가
    - 현재 delete를 실행할 때 명령어가 'delete?id=1' 과 같이 ? 뒤에 여러가지 옵션을 더해서 프로그램에 전달하는 형태이다.
    - 앞으로 추가할 기능들이 delete 처럼 핵심 명령어 뒤에 옵션들이 붙을 것이 예상되었다.
    - 따라서 명령어 분석 기능이 들어간 RequestProcesser 클래스를 추가하여 delete 이후 다른 명령어들이 전체 명령어를 줄 경우 필요한 정보만 뽑아서 전해주는 역할을 하도록 하였다. 
11. RequestProcesser 클래스를 이용하여 다른 명령어까지 처리할 수 있도록 변경
    - 결국 RequestProcesser 클래스가 하는 일은 단순히 명령어를 처리하는 일이기 때문에, delete 명령어가 아닌 다른 명령어들도 충분히 사용할 수 있어야 한다.
    - 따라서 RequestProcesser 클래스를 다른 명령어도 사용하도록 변경하였고, 코드의 가독성을 위해 if-else 문들을 switch-case 문으로 변경하였다.
    - 또, 기존의 RequestProcesser 클래스 내부 파싱에서는 단일명령어(ex: exit, list 등)를 처리하는 코드가 없었기 때문에 추가해주었다.
12. 예외상황 처리
    - delete 명령어 뒤에 id 값을 입력하도록 되어있는데, 이때 오타가 나면 어떻게 처리할지 추가하였다.
    - id 값 뒤에 오는 값이 정수가 아닐 경우 어떻게 처리할지 추가하였다.
13. motivation delete 기능 개선
    - 기존의 delete 기능은 App에서 바로 id 값을 전달해주어야만 했다.
    - 이제 RequestProcesser 클래스가 추가됨에 따라 명령어 전체를 파싱하여 정보를 전달하는 것이 가능하게 되었다.
    - 따라서 App 클래스에서 id 값을 연산해서 줄 필요 없이 delete 할 때 명령어에서 id값을 가지고 원하는 것을 삭제할 수 있도록 하였다.
    - 세세하게는, id값을 가지고 Article을 찾는 함수를 따로 만들었고 이를 활용하여 delete 함수도 다시 구현하였다.
14. motivation edit 기능 구현
    - 기존의 Article을 불러와 수정하는 기능을 구현하였다.
    - 기존의 add()와 delete()의 함수를 참고하였다.

