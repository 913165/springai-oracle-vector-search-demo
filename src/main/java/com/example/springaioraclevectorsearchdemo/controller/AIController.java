package com.example.springaioraclevectorsearchdemo.controller;


import com.example.springaioraclevectorsearchdemo.service.AIService;
import org.springframework.ai.document.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AIController {

    @Autowired
    com.example.springaioraclevectorsearchdemo.service.AIService aiService;

    @GetMapping("/load")
    public String load() {
         aiService.loaddata();
         return "Data loaded";
    }

    @GetMapping("/search")
    public List<String> search() {
        List<Document> docs = aiService.search();
        List<String> docContents = docs.stream()
                               .map(Document::getContent)
                               .collect(Collectors.toList());
        return docContents;
    }

}
