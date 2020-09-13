#Contest -206 https://leetcode.com/contest/weekly-contest-206/problems/count-unhappy-friends/

from collections import defaultdict
class Solution:
    def unhappyFriends(self, n: int, preferences: List[List[int]], pairs: List[List[int]]) -> int:
        pair_dict = defaultdict(int)
        unhappy = 0
        for pair in pairs:
            pair_dict[pair[0]] = pair[1]
            pair_dict[pair[1]] = pair[0]
            
        def check_unhappy(i):
            pair = pair_dict[i]
            for preferred_friend in preferences[i]:
                if preferred_friend != pair:
                    for preferred_friend_preference in preferences[preferred_friend]:
                        if preferred_friend_preference == i:
                            return 1
                        elif preferred_friend_preference == pair_dict[preferred_friend]:
                            break
                        else:
                            continue
                else:
                    return 0
        
        for i in range(n):
            unhappy += check_unhappy(i)
        
        return unhappy