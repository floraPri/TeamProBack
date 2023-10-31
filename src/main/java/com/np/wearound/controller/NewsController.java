package com.np.wearound.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.np.wearound.entities.News;
import com.np.wearound.service.NewsService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor   //생성자에 멤버변수를 주입
@RestController
@RequestMapping(value="/news")
public class NewsController {
	
   private static final Logger logger = LoggerFactory.getLogger(NewsController.class);
   
   
   @Autowired
   private NewsService service;
   
   @GetMapping("/news")
   public List<News> newsList(){
	   logger.info(" news - newsList");
	   
	   return service.NewsList();
   }
   
   @GetMapping("/news_")
   public List<News> getLatestNews(@RequestParam(required = false, defaultValue = "5") int limit) {
       return service.getLatestNews(limit).getContent();
   }
	   
	   

}
