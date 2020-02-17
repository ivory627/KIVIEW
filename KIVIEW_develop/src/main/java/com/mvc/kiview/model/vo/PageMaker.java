package com.mvc.kiview.model.vo;

import org.springframework.web.util.UriComponentsBuilder;

public class PageMaker {

	private int totalCount;
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	private int displayPageNum = 5;
	private Criteria cri;

	public void setCri(Criteria cri) {
		this.cri = cri;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		calcData();
	}

	public int getTotalCount() {
		return totalCount;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public boolean isNext() {
		return next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public Criteria getCri() {
		return cri;
	}

	private void calcData() {

		// 끝 페이지 번호 = (현재 페이지 번호 / 화면에 보여질 페이지 번호의 갯수) * 화면에 보여질 페이지 번호의 갯수
		endPage = (int) (Math.ceil(cri.getPage() / (double) displayPageNum) * displayPageNum);
		startPage = (endPage - displayPageNum) + 1;

		// 마지막 페이지 번호 = 총 게시글 수 / 한 페이지당 보여줄 게시글의 갯수
		int tempEndPage = (int) (Math.ceil(totalCount / (double) cri.getPerPageNum()));
		if (endPage > tempEndPage) {
			endPage = tempEndPage;
		}

		// 이전 버튼 생성 여부 = 시작 페이지 번호 == 1 ? false : true (시작페이지가 1이 아니면 생김)
		prev = startPage == 1 ? false : true;
		// 다음 버튼 생성 여부 = 끝 페이지 번호 * 한 페이지당 보여줄 게시글의 갯수 < 총 게시글의 수 ? true: false
		next = endPage * cri.getPerPageNum() < totalCount ? true : false;
	}

	public String makeQuery(int page) {
		UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.newInstance().queryParam("page", page)
				.queryParam("perPageNum", this.cri.getPerPageNum());

		// 검색 한 경우
		if (this.cri.getSearchType() != null) {
			uriComponentsBuilder.queryParam("searchType", this.cri.getSearchType()).queryParam("keyword",
					this.cri.getKeyword());
		}
		//최신순, 조회순 선택 한 경우
		if (this.cri.getSort() != null) {
			uriComponentsBuilder.queryParam("sort", this.cri.getSort());
		}
		
		//분류 공지사항, 키뷰소식 선택 한 경우
		if(this.cri.getCat_detail() != null) {
			uriComponentsBuilder.queryParam("catd", this.cri.getCat_detail());
		}

		return uriComponentsBuilder.build().encode().toString();
	}
}