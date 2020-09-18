# https://leetcode.com/problems/add-strings/

class Solution:
    def addStrings(self, num1: str, num2: str) -> str:
        first_p = len(num1)-1
        second_p = len(num2)-1
        ans = ''
        carry = 0
        while first_p >=0 or second_p>=0:
            x1 = int(num1[first_p]) if first_p>=0 else 0
            x2 = int(num2[second_p]) if second_p>=0 else 0
            value = x1+x2 + carry
            ans += str(value%10)
            carry = value // 10
            first_p -= 1
            second_p -= 1
        if carry:
            ans+=str('1')
        return ans[::-1]