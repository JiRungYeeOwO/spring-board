package com.example.firstproject.dto;

import com.example.firstproject.entity.Article;

public class ArticleForm {
    private Long id;
    private String title;
    private String content;

    public ArticleForm(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Article toEntity() {
        Article ar = new Article(id, title, content);
        return ar;
    }

    @Override
    public String toString() {
        return "ArticleForm{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
