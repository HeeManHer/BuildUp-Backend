# 필독!! 다른사람의 파일은 건드리지 말것
## 구조
 - 기본 패키지 : com.warmmingup.buildup
 - 하위 패키지
   - .config
   - .common
   - 본인 파트
     - .controller
     - .service
     - .dao
     - .dto

## 사용 규칙
   - 파일이름은 (자신이 맡은 파트 + 구조이름)으로 할 것
     - EX) IssueController, SprintService 등
   - 파일 위치는 알맞게 잘 지정할 것
   - 매퍼.xml파일은 /resource/mappers 폴더에 dao의 매퍼 파일과 같은 이름으로 작성해서 넣을 것

## Ver - 1.0.0
  - 파일 구조 설정
  - 기본 파일 작성

## Ver - 1.0.1
 - 파일 구조 변경
   - 담당 파트 별로 패키징
 - 기본 파일 추가
   - 스웨거 의존성 및 설정 파일 추가
   - Cors관련 서버 설정 파일 추가
