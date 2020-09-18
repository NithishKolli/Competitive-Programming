# https://leetcode.com/problems/valid-palindrome/

class Solution:
    def isPalindrome(self, s: str) -> bool:
        left_p = 0
        right_p = len(s)-1
        while left_p <= right_p:
            print(left_p,s[left_p],right_p,s[right_p])
            if not s[left_p].isalnum():
                left_p += 1
                continue
            if not s[right_p].isalnum():
                right_p -= 1
                continue
            if s[left_p].lower() != s[right_p].lower():
                return False
            left_p += 1
            right_p -= 1
        return True