package com.ravitiwari.PostResponse;

import java.util.List;

import clone.twitter.paylouts.PostDto;

public class PostResponse {

private List<PostDto> content;
	
	private int pageNumber;
	private int pageSize;
	private long totalElememts;
	private int Totalpages;
	private boolean lastpages;
	
	public PostResponse() {
		// TODO Auto-generated constructor stub
	}

	public List<PostDto> getContent() {
		return content;
	}

	public void setContent(List<PostDto> content) {
		this.content = content;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotalElememts() {
		return totalElememts;
	}

	public void setTotalElememts(long totalElememts) {
		this.totalElememts = totalElememts;
	}

	public int getTotalpages() {
		return Totalpages;
	}

	public void setTotalpages(int totalpages) {
		Totalpages = totalpages;
	}

	public boolean isLastpages() {
		return lastpages;
	}

	public void setLastpages(boolean lastpages) {
		this.lastpages = lastpages;
	}
	
	
	
	

}
