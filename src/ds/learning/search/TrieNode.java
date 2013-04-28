package ds.learning.search;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

	private char data;
	
	private Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
	
	private boolean isWord;
	
	public TrieNode() {
		
	}
	
	public TrieNode(char data) {
		this.data = data;
	}

	public boolean isWord() {
		return isWord;
	}

	public void setWord(boolean isWord) {
		this.isWord = isWord;
	}

	public char getData() {
		return data;
	}

	public void setData(char data) {
		this.data = data;
	}

	public Map<Character, TrieNode> getChildren() {
		return children;
	}

	public void setChildren(Map<Character, TrieNode> children) {
		this.children = children;
	}

}
