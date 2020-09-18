# https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/556/week-3-september-15th-september-21st/3463/

class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        count = 0
        pos = (0,0)
        directions = [(0,1), (-1,0), (0,-1), (1,0)] # N,W,S,E
        d = 0
        for c in instructions:
            if c == 'L':
                d += 1
            elif c == 'R':
                d += 3
            else:
                pos = (pos[0]+directions[d][0],pos[1]+directions[d][1])
            d %= 4
        if d==0 and pos != (0,0):
            return False
        return True