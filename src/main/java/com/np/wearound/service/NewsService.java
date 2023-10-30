package com.np.wearound.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.np.wearound.entities.News;
import com.np.wearound.repository.NewsRepository;

@Service
public class NewsService {
	
	@Autowired
	private NewsRepository news;
	
	public List<News> NewsList(){
		System.out.println("service - newslist");
		
		return news.findAll();
	}
	
	public Page<News> getLatestNews(int limit) {
	    System.out.println("sort latest");
		return news.findAllByOrderByNewsnoDesc(PageRequest.of(0, limit));
	}

}
