package adt;

public interface ADTHashmapInterface {
	
	
	
	/**
	 * To insert a word into the ADT-Hashmap
	 * @param word Word to insert
	 * @return ADTHashmap
	 */
	ADTHashmap insert(String word);
	
	/**
	 * To get a count of the word (key) in the text
	 * @param word
	 * @return Integer
	 */
	Integer find(String word);
	
}
