package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ArticleController {
    @Autowired
    ArticleRepository articleRepository;

    @GetMapping("/articles/{id}/delete")
    public String delete(@PathVariable("id")Long id) {
        articleRepository.deleteById(id);
        return "redirect:/articles";
    }

    @GetMapping("/articles")
    public String index(Model model) {
        List<Article> resultAr = (List<Article>) articleRepository.findAll();
        model.addAttribute("resultObject", resultAr);
        return "articles/index";
    }

    @PostMapping("/articles") // 검색 기능
    public String index(@RequestParam("boardSearch") String keyword, Model model) {
        List<Article> resultAr = null;
        if(keyword != null) { // 검색어가 있을때
            resultAr = (List<Article>) articleRepository.findByTitleContaining(keyword); // 검색어가 포함 된 게시글 목록
        } else { // 검색어가 없을때
            resultAr = (List<Article>) articleRepository.findAll(); // 모든 게시글 목록
        }
        model.addAttribute("resultObject", resultAr);
        return "articles/index";
    }

    @PostMapping("/articles/update") // 수정 기능
    public String update(ArticleForm fo) {
        Article resultEntity = fo.toEntity();
        Article resultEntity2 = articleRepository.save(resultEntity);
        return "redirect:/articles/" + resultEntity2.getId();
    }

    @GetMapping("/articles/{id}/edit") // 수정 페이지로 이동
    public String edit(@PathVariable("id")Long id, Model mo) {
        Article result = articleRepository.findById(id).orElse(null);
        mo.addAttribute("articleResult", result);
        return "articles/edit";
    }

    @GetMapping("/articles/new")
    public String newArticleForm() {
        return "articles/new";
    }

    @PostMapping("/articles/create") // 새 게시글 작성
    public String newArticleForm(ArticleForm form) {
        //System.out.println(form.toString());
        Article ar= form.toEntity();
        //System.out.println("entity: " + ar.toString());
        Article afterAr = articleRepository.save(ar);
        return "redirect:/articles/" + afterAr.getId();
    }

    @GetMapping("/articles/{id}") // 상세 페이지로 이동
    public String show(@PathVariable("id")Long id, Model mo) {
        Article result = articleRepository.findById(id).orElse(null);
        mo.addAttribute("articleResult", result);
        return "articles/show";
    }

}
