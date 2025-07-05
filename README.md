# 📝 Spring 게시판 프로젝트

## 📚 개요
재능대학교의 Spring MVC 실습 수업에서 진행한 프로젝트로, 게시판의 기본적인 CRUD 기능을 직접 구현해보며 백엔드 개발 기초를 다졌습니다.  
단순한 코드 작성에 그치지 않고, MVC 구조 이해, JPA 연동, Mustache 기반 View 처리 등 실무에 가까운 흐름을 경험하는 데 중점을 두었습니다.

## 🛠️ 사용 기술
- Java 17
- Spring Framework (MVC)
- Spring Boot
- Spring Data JPA
- H2 Database (또는 MySQL)
- Mustache (View Template)
- Gradle

## 🧩 주요 기능
- 게시글 목록 조회
- 게시글 작성
- 게시글 수정
- 게시글 삭제
- 게시글 검색

## 📁 프로젝트 구조
- `controller`: 웹 요청을 처리하는 컨트롤러 클래스
- `dto`: 폼 데이터 전달용 DTO 클래스
- `entity`: DB와 매핑되는 엔티티 클래스
- `repository`: JPA 기반 데이터베이스 접근 계층

## 🗃️ DB 구성 예시 (JPA 기준)

```java
@Entity
public class Article {
    @Id // 기본 키
    @GeneratedValue // 자동 증가 (AUTO_INCREMENT)
    private Long id;

    @Column
    private String title;

    @Column
    private String content;
}
```
## ✨ 향후 개선 사항
- 로그인/회원가입 기능 추가
- 페이징 처리
- 댓글 기능

## 📎 학습한 점
- MVC 아키텍처의 역할 분리
- Spring JPA의 사용법과 Entity 매핑
- Controller → Service → Repository 흐름 이해
- Mustache 템플릿 엔진의 간단한 문법 활용
