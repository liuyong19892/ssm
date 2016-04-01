package com.raistudies.domain;

import java.util.List;

public class CommonBean {
	
	private List<?> results;
	private int count;
	private int cacheStart;
	
	public final int getCount() {
		return count;
	}
	public final void setCount(int count) {
		this.count = count;
	}
	public final int getCacheStart() {
		return cacheStart;
	}
	public final void setCacheStart(int cacheStart) {
		this.cacheStart = cacheStart;
	}
	public final List<?> getResults() {
		return results;
	}
	public final void setResults(List<?> results) {
		this.results = results;
	}
}
