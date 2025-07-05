package com.example.firstproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity // @Table(name="users") users라는 이름의 테이블을 사용해라
public class Article {

    @Id // PK필드
    @GeneratedValue // AI
    private Long id;
    @Column // 일반 필드
    private String title;
    @Column
    private String content;

    public Article() {
    }

    public Long getId() {
        return id;
    }

    public Article(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }


    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
