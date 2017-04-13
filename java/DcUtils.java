/*
The MIT License (MIT)

Copyright (c) 2014 Jeremy Lu

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
*/

import java.util.Hashtable;

class DcUtils {
  
  public static void main (String[] args) {

    System.out.println("-- Test has unique characters");
    System.out.println(DcUtils.strHasAllUniqueChars("addb")); // false
    System.out.println(DcUtils.strHasAllUniqueChars("cat")); // true
    System.out.println(DcUtils.strHasAllUniqueChars("aa")); // false
    System.out.println(DcUtils.strHasAllUniqueChars("")); // true
    System.out.println(DcUtils.strHasAllUniqueChars(null)); // true
    
    System.out.println("-- Test if permutation");
    System.out.println(DcUtils.isPermutation("ab", "ba")); // true
    System.out.println(DcUtils.isPermutation("ab", "aa")); // false
    System.out.println(DcUtils.isPermutation("ab", "aaasdf")); // false
    System.out.println(DcUtils.isPermutation("Google", "oogGle")); // true
    System.out.println(DcUtils.isPermutation("apple", "apple")); // true

  }

  // test if a string has all unique character or not.
  // Time complexity is O(n), space complexity is O(1)
  // test if a string has all unique characters.
  // if it's ASCII code format, can optimize by adding:
  //  if (input.length() > 256) return false;
  public static boolean strHasAllUniqueChars(String input) {
    if (input == null) {
      return true;
    }
    Hashtable<Character, Boolean> characters = new Hashtable<Character, Boolean>();
    if (input.length() < 2) {
      return true;
    }
    for (int i=0; i<input.length(); i++) {
      char a = input.charAt(i);
      if (characters.containsKey(a)) {
        return false;
      }
      characters.put(a, true);
    }
    return true;
  }

  // test if one string is a permutation of another
  public static boolean isPermutation(String input1, String input2) {
    // Solution 1: sort two strings and see if they are exactly match or not. O(2nlog(n))
    // Solution 2: character count
    // steps:
    // 1. walk through first string, push every character in a hash table <char, int> (character to number of occurrance)
    // 2. walk through second string, use hashtable to test whether exact occurance has been used up. left over? delete the key if length reaches 0
    // if not worry able space,
    if (input1.length() != input2.length()) {
      return false;
    }

    if (input1 == input2) {
      return true;
    }

    Hashtable<Character, Integer> charset = new Hashtable<Character, Integer>(); 
    /*
    for (int i=0; i<input1.length(); i++) {
      char a = input.charAt(i);
      if (charset.containsKey(a)) {
        charset.put(a, charset.get(a) + 1);
      } else {
        charset.put(a, 0);
      }
    }
    */
    char[] charArr = input1.toCharArray();
    for (char c : charArr) {
      if (charset.containsKey(c)) {
        charset.put(c, charset.get(c) + 1);
      } else {
        charset.put(c, 0);
      }
    }
    for (int i=0; i<input2.length(); i++) {
      char a = input2.charAt(i);
      if (!charset.containsKey(a)) {
        return false;
      }
      int length = charset.get(a);
      if (length < 0) {
        return false;
      } else if (length == 0) {
        charset.remove(a);
      } else {
        charset.put(a, length - 1);
      }
    }

    if (charset.isEmpty()) {
      return true;
    }
    return false;
  }
}

