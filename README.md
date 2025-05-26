# schedule_JPA
# CH 3 일정 관리 앱 Develop

## API 명세서


## 🛠 사용한 기술
- Java 17
- Spring Boot 3.4.5
- Spring Data JPA
- MySQL 
  <br>

## 💻 개발 도구
- IntelliJ IDEA
- Git
- Postman
<br>

## 📝 단계별 요구사항
`필수 기능`
- Lv 0. API 명세 및 ERD 작성, SQL 작성
- Lv 1. 일정 CRUD (일정을 생성, 조회, 수정 삭제할 수 있습니다.)
- Lv 2. 유저 CRUD (유저를 생성, 조회, 수정, 삭제할 수 있습니다.)
- Lv 3. 회원가입 (유저에 비밀번호 필드를 추가합니다.)
- Lv 4. 로그인(인증, Cookie/Session 활용)

`도전 기능(구현 실패)`
- Lv 5. 다양한 예외처리 적용하기
- Lv 6. 비밀번호 암호화
- Lv 7. 댓글 CRUD
- Lv 8. 일정 페이징 조회
  <br>
## 폴더 구조
```bash
src/main/java/com/example
├── schedule
│  ├── controller      
│  ├── dto            
│  ├── service       
│  ├── filter          
│  ├── repository       
│  ├── entity          
│       # Valid 그룹
├── common       
    ├── config        
    ├── session
    ├── filter
```
<br>

## API 명세서
- https://documenter.getpostman.com/view/44756670/2sB2qcD1XS

## 트러블 슈팅
- https://kiiin.tistory.com/