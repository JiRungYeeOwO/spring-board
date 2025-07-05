package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Random;

@Controller
public class SecondController {
    @GetMapping("/random-quote")
    public String randomQuote(Model mo) {
        ArrayList<String> quote = new ArrayList<>();
        quote.add("마음이 맑고 깨끗한 사람은 온 세계가 맑고 깨끗하게 보이고, 마음이 잡된 사람은 온 세계가 또한 잡되고 더럽게 보인다. - 에머슨 -");
        quote.add("인생은 교향악입니다. 인생의 각각 순간들이 합창으로 노래하고 있습니다. - 로망 롤랑 -");
        quote.add("정말로 낙숫물이 돌을 뚫는다. 사실, 정말로 낙숫물이 돌을 뚫는다. - 베토벤 -");
        quote.add("추위에 떤 사람일수록 태양의 따뜻함을 느낀다. - 휘트먼 -");
        quote.add("오랫동안 꿈을 그리는 사람은 마침내 그 꿈을 닮아 간다. - 앙드레 말로 -");
        quote.add("네 믿음은 네 생각이 된다 . 네 생각은 네 말이 된다. 네말은 네 행동이 된다 네행동은 네 습관이된다 . 네 습관은 네 가치가 된다 . 네 가치는 네 운명이 된다. - 간디 -");
        Random random = new Random();
        mo.addAttribute("randomQuote", quote.get(random.nextInt(quote.size())));
        return "quote";
    }
}
