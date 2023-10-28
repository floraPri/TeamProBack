package com.np.wearound.service;

import org.springframework.stereotype.Service;

import com.np.wearound.dto.SearchDTO;
import com.np.wearound.entities.Search;
import com.np.wearound.repository.SearchRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SearchService {
	
	private final SearchRepository searchRepository;
	
	public void searchHistoryAdd(SearchDTO dto) {
		
		System.out.println("<<<SearchService - searchHistoryAdd()>>>");
		
		Search search = new Search();
		search.setUserno(dto.getUserno());
		search.setSearchcontent(dto.getSearchcontent());
		
		searchRepository.save(search);
		
	}
	
}

