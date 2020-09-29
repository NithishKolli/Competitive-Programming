// https://leetcode.com/problems/longest-substring-without-repeating-characters/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> charecterMap = new HashMap<Character, Integer> ();
        int leftPointer = 0;
        int rightPointer = 0;
        int maxLength = 0;
        while (rightPointer<s.length()){
            if(charecterMap.containsKey(s.charAt(rightPointer))){
                int newLeft = charecterMap.get(s.charAt(rightPointer))+1;
                while(leftPointer<newLeft){
                    charecterMap.remove(s.charAt(leftPointer));
                    leftPointer++;
                }
            }
            charecterMap.put(s.charAt(rightPointer),rightPointer);
            // int length = rightPointer-leftPointer;
            maxLength = Math.max(maxLength, rightPointer-leftPointer+1);
            rightPointer++;
        }
        return maxLength;
    }
}