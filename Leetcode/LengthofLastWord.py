# https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/556/week-3-september-15th-september-21st/3461/

class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        index = len(s)-1
        last_index = index
        end = False
        while index>=0:
            if not end and s[index] != ' ':
                end = True
                last_index = index
            if end:
                if s[index] == ' ':
                    return last_index-index
            index -= 1
        if not end:
            return 0
        return last_index+1