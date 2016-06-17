package com.study.springrest.domain;

public class PageMaker {
	
	int totalArticles = 175;			//�� �Խñ�
	int startPage;
	int endPage;
	
	int pagePerBlock = 10;			//paging�� 10������....
	
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
		// ��ü ������ ����
		int totalPages = (int)Math.ceil(totalArticles /  (double)pagePerBlock);			//�� �Խñ��� ���� 10���� ���� �� ��������� ������ �������� �ϳ� �� ���� �� �ֵ��� Math.ceil�� �ø�ó��
		
		// ��û�� ������
		int currentPage = criteria.getPage();				//11
		
		//������ ��ȣ�� ������ ����
		endPage = (int)Math.ceil(currentPage / (double) pagePerBlock) * pagePerBlock; 
		
		//������ ��ȣ�� ���۵Ǵ� ����
		startPage =  endPage - pagePerBlock + 1;		// 1, 11, 21, 31, 41 ......
	
		if(endPage >= totalPages){
			endPage = totalPages;
		}
	
		//���� ������ ���� ��ư
		if(startPage > 1){
			prev = true;
		}	
	
		// ���� ������ ���� ��ư
		if(endPage < totalPages)
			next = true;
		}
	

}