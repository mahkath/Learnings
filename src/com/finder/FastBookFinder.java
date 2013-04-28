package com.finder;

import java.util.List;

public interface FastBookFinder {
	public List<Book> findTitle(String titleParm) ;
	
	public List<Book> findLabel(String labelParm);

	public List<Book> findAny(String anystringParm) ;
}
