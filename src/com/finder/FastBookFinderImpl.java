package com.finder;
import java.util.ArrayList;
import java.util.List;


public class FastBookFinderImpl implements FastBookFinder{
	private List<Book> books;
	
	public FastBookFinderImpl(List<Book> books) {
		if(books != null) {
			this.books = books;
		} else {
			this.books = new ArrayList<Book>();
		}
	}
	
	public List<Book> findTitle(String titleParm) {
		ArrayList<Book> booksWithSameTitle = new ArrayList<Book>();
		if(checkIfEmpty(titleParm))
			return booksWithSameTitle;
		
		for(Book book : books) {
			if(book.getTitle().contains(titleParm)) {
				booksWithSameTitle.add(book);
			}
		}
		return booksWithSameTitle;
	}
	
	public List<Book> findLabel(String labelParm) {
		ArrayList<Book> booksWithSameLabel = new ArrayList<Book>();
		if(checkIfEmpty(labelParm))
			return booksWithSameLabel;
		
		for(Book book : books) {
			if(book.getLabels().contains(labelParm)) {
				booksWithSameLabel.add(book);
			}
		}
		return booksWithSameLabel;
		
	}

	public List<Book> findAny(String anystringParm) {
		ArrayList<Book> booksWithSimilar = new ArrayList<Book>();
		if(checkIfEmpty(anystringParm))
			return booksWithSimilar;
		
		for(Book book : books) {
			if(book.getTitle().contains(anystringParm) || book.getLabels().contains(anystringParm) || book.getDescription().contains(anystringParm)) {
				booksWithSimilar.add(book);
			}
		}
		return booksWithSimilar;
	}
	
	private boolean checkIfEmpty(String s) {
		if(s == null || s.length() < 1) {
			return true;
		} else {
			return false;
		}
	}
}
