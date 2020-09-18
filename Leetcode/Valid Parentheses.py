# https://leetcode.com/problems/valid-parentheses/

class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        for c in s:
            if c== '(' or c == '[' or c=='{':
                stack.append(c)
            elif c==')':
                if not stack or stack.pop() != '(':
                    return False
            elif c==']':
                if not stack or stack.pop() != '[':
                    return False
            elif c=='}' and stack:
                if not stack or stack.pop() != '{':
                    return False
        return len(stack)==0