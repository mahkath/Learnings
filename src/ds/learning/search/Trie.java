package ds.learning.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Trie {

	private TrieNode root = new TrieNode();
	
	/**
	 * Inserting word into Trie
	 * 
	 * @param word
	 */
	public void insert(String word) {
		TrieNode node = root;
			for( int i=0; i< word.length(); i++) {
				Map<Character, TrieNode> map = node.getChildren();
				char ch = word.charAt(i);
				if(map.get(ch) != null) {
					node = map.get(ch);
					if(i==word.length()-1) {
						node.setWord(true);
					}
				} else {
					buildChildNodes(word.substring(i), node);
				}
			}
	}
	
	private void buildChildNodes(String word, TrieNode parent) {
		TrieNode temp = parent;
		for(char ch : word.toCharArray()) {
			TrieNode node = new TrieNode(ch);
			temp.getChildren().put(ch, node);
			temp = node;
		}
		temp.setWord(true);
	}
	
	/**
	 * Regular Search
	 * 
	 * @param word
	 * @return
	 */
	public boolean search(String word) {
		int i=0;
		TrieNode node = root;
		
		for( i=0; i< word.length(); i++) {
			char ch = word.charAt(i);
			if(node.getChildren().get(ch) != null) {
				node = node.getChildren().get(ch);
			} else {
				return false;
			}
		}
		if( i == word.length() && node != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public List<String> searchStartingWith(String word) {
		List<String> wordsStartingWith = new ArrayList<String>();
		
		int i=0;
		TrieNode node = root;
		
		for( i=0; i< word.length(); i++) {
			char ch = word.charAt(i);
			if(node.getChildren().get(ch) != null) {
				node = node.getChildren().get(ch);
			} else {
				return wordsStartingWith;
			}
		}
		
		return getWords(word, node);
	}
	
	private List<String> getWords(String word, TrieNode node) {
		List<String> wordsList = new ArrayList<String>();
		
		for(char ch : node.getChildren().keySet()) {
			TrieNode child = node.getChildren().get(ch);
			List<String> otherWords = getWords(word + ch, child);
			wordsList.addAll(otherWords);
		}
		
		if(node.isWord()) {
			wordsList.add(word);
		}
		
		return wordsList;
	}
	
	public static void main(String args[]) {
		Trie trie = new Trie();
		trie.insert("Mahesh");
		trie.insert("Mahi");
		trie.insert("dmk");
		
		System.out.println(trie.search("Ma"));
		
		for(String words : trie.searchStartingWith("Maha")) {
			System.out.println(words);
		}
		System.out.println("DONE");
	}
}
