package us.csbu.cs546.algorithm;

/**
 * 
 */
public class Anagram
{
	/* 
	 * Assume both arguments are not null and in lower case. 
	 *  
	 * @return true, if both String are anagram */ 
	public static boolean isAnagram(String word, String anagram)
	{ 
		if(word.length() != anagram.length())
		{ 
			return false; 
		} 
		char[] chars = word.toCharArray(); 
		for(char c : chars)
		{ 
			int index = anagram.indexOf(c); 
			if(index != -1)
			{ 
				anagram = anagram.substring(0,index) + anagram.substring(index +1, anagram.length()); 
				
			}
			else
			{ 
				return false; 
			} 
		} 
		return anagram.isEmpty(); 
	}
	
	public static void main(String args[]){
		System.out.println (isAnagram("stae", "rats"));
	}

}