package com.assignment.util;

import java.util.ArrayList;
import java.util.List;

public class Node {
	
	private List<Node> childNodes = new ArrayList<Node>();
	
	private String key;
	
	private String value;
	
	private boolean isWord;
	
	public Node() {
		
	}
	
	public Node(String key, String value) {
		this.key= key;
		this.value = value;
	}

	public List<Node> getChildNodes() {
		return childNodes;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setChildNodes(List<Node> childNodes) {
		this.childNodes = childNodes;
	}

	public boolean isWord() {
		return isWord;
	}

	public void setWord(boolean isWord) {
		this.isWord = isWord;
	}

}
