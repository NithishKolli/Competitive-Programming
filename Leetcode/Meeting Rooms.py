# https://leetcode.com/problems/meeting-rooms/

class Solution:
    def canAttendMeetings(self, intervals: List[List[int]]) -> bool:
        first_p = 0
        second_p = 1
        intervals = sorted(intervals, key = lambda x:x[0])
        print(intervals)
        while second_p < len(intervals):
            if intervals[second_p][0] < intervals[first_p][1]:
                return False
            else:
                first_p += 1
                second_p += 1
        return True