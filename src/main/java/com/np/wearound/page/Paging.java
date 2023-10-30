package com.np.wearound.page;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Paging {
	private int pageSize = 5; //1page당 게시글의 갯수를 지정
	private int count = 0;		//전체글의 갯수를 저장하는 변수
	private int number = 0;		//페이지번호
	private String pageNum;

	private int startRow;		//페이지별 시작번호
	private int endRow;			//페이지별 끝번호

	private int currentPage;		//현재페이지
	private int pageCount;
	private int startPage;
	private int pageBlock;
	private int endPage;

	private int prev;			//이전
	private int next;			//다음

	public Paging(String pageNum) {
		if(pageNum == null) {
			//맨처음 board_list.jsp를 클릭하거나, 수정 삭제 등 다른 게시글에서 페이지로 넘어올때 pageNum이 없는경우 null 처리
			pageNum="1";
		}

		this.pageNum = pageNum;

		currentPage = Integer.parseInt(pageNum);
		System.out.println("================");
		System.out.println("pageNum : " + pageNum);
		System.out.println("currentPage : " + currentPage);

	}

	public void setTotalCount(int count) {
		this.count = count;

		startRow = (currentPage - 1) * pageSize + 1;	//페이지당 시작번호
		endRow = currentPage * pageSize;//페이지당 끝번호 => end

		System.out.println("startRow" + startRow);
		System.out.println("endRow" + endRow);

		this.number = count - (currentPage - 1) * pageSize; //페이지번호

		//페이지 계산
		pageCaculator();
	}
	//페이지 계산
	public void pageCaculator() {
		if(count > 0) {
			pageCount = count / pageSize + (count % pageSize == 0 ? 0:1);
			System.out.println("pageCount : " + pageCount);

			startPage = 1;

			if(currentPage % 10 !=0) {
				startPage = (int)(currentPage / 10) * 10 + 1;
			}
			else {
				startPage = ((int)(currentPage / 10)-1)  * 10 + 1;
			}

			System.out.println("startPage" + startPage);

			pageBlock = 10;
			endPage = startPage + pageBlock -1;
			if(endPage > pageCount) endPage = pageCount;

			System.out.println("endPage" + endPage);

			//이전
			if(startPage > pageSize) prev = startPage -10;
			//다음
			if(endPage < pageCount) next = startPage +10;

			System.out.println("prev" + prev);
			System.out.println("next" + next);
			/*
				pageNum : 1
				currentPage : 1
				DAO - boardCnt
				total => 991    // 전체 건수
				startRow : 1    // start
				endRow : 10     // end
				pageCount : 100 // 10페이지의 게시글 건수
				startPage : 1   // 1페이지
				endPage : 10    // 10페이지
				prev : 0
				next : 11
			 */
		}
	}


}
