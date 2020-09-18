# https://leetcode.com/problems/rotate-string/

class Solution:
    def rotateString(self, A: str, B: str) -> bool:
        return True if len(A)==len(B) and B in A+A else False
        
        # if len(A)!=len(B):
        #     return False
        # n = len(A)
        # if n ==0:
        #     return True
        # for i in range(n):
        #     if B[i]==A[0]:
        #         check = True
        #         for j in range(1,n):
        #             if A[j]!=B[(i+j)%n]:
        #                 check = False
        #         if check:
        #             return check
        # return False