package com.study.springrest.domain;

public class PageMaker {
	
	int totalArticles = 175;			//총 게시글
	int startPage;
	int endPage;
	
	int pagePerBlock = 10;			//paging은 10개까지....
	
	boolean next = false;
	boolean prev = false;
	
	Criteria criteria;
	
	public PageMaker(Criteria cri, int total){
		criteria = cri;
		totalArticles = total;
		process();
	}
	
	

	public int getTotalArticles() {
		return totalArticles;
	}



	public void setTotalArticles(int totalArticles) {
		this.totalArticles = totalArticles;
	}



	public int getStartPage() {
		return startPage;
	}



	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}



	public int getEndPage() {
		return endPage;
	}



	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}



	public int getPagePerBlock() {
		return pagePerBlock;
	}



	public void setPagePerBlock(int pagePerBlock) {
		this.pagePerBlock = pagePerBlock;
	}



	public boolean isNext() {
		return next;
	}



	public void setNext(boolean next) {
		this.next = next;
	}



	public boolean isPrev() {
		return prev;
	}



	public void setPrev(boolean prev) {
		this.prev = prev;
	}



	public Criteria getCriteria() {
		return criteria;
	}



	public void setCriteria(Criteria criteria) {
		this.criteria = criteria;
	}



	private void process(){
		// 전체 페이지 개수
		int totalPages = (int)Math.ceil(totalArticles /  (double)pagePerBlock);			//총 게시글의 수를 10개로 나눈 후 나머지들로 구성된 페이지가 하나 더 생길 수 있도록 Math.ceil로 올림처리
		
		// 요청한 페이지
		int currentPage = criteria.getPage();				//11
		
		//페이지 번호가 끝나는 숫자
		endPage = (int)Math.ceil(currentPage / (double) pagePerBlock) * pagePerBlock; 
		
		//페이지 번호가 시작되는 숫자
		startPage =  endPage - pagePerBlock + 1;		// 1, 11, 21, 31, 41 ......
	
		if(endPage >= totalPages){
			endPage = totalPages;
		}
	
		//이전 페이지 블럭 버튼
		if(startPage > 1){
			prev = true;
		}	
	
		// 다음 페이지 블럭 버튼
		if(endPage < totalPages)
			next = true;
		}
	

}
