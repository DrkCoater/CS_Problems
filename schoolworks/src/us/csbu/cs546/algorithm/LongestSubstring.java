package us.csbu.cs546.algorithm;

public class LongestSubstring {
	static String findLongestSubstring(String word) {
		int headPointer = 0;
		int tailPointer = 0;
		String longestSubstring = "";
		while (tailPointer < word.length() - 1) {
			tailPointer++;
			char c = word.charAt(tailPointer);
			String currentStr = word.substring(headPointer, tailPointer);
			if (currentStr.indexOf(c) >= 0 ) {
				headPointer = tailPointer;
				continue;
			}
			currentStr += c;
			//TODO: maybe there is equal in length, do we need to keep this result?
			if (currentStr.length() > longestSubstring.length()) {
				longestSubstring = currentStr;
			}
		}
		return longestSubstring;
	}
	
	public static void main(String args[]){
		System.out.println("Final Result: " + LongestSubstring.findLongestSubstring("ABDEFGABEF"));
	}
}
