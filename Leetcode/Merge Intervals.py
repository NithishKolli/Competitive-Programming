# https://leetcode.com/problems/merge-intervals/

class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        left_pointer = 0
        right_pointer = 1
        #sort the list based [0]
        intervals = sorted(intervals,key= lambda x:x[0])
        while left_pointer<len(intervals) and right_pointer<len(intervals):
            if intervals[right_pointer][0] <= intervals[left_pointer][1]:
                new_end = max(intervals[right_pointer][1], intervals[left_pointer][1])
                print(new_end)
                intervals[left_pointer][1] = new_end
                
                intervals.pop(right_pointer)
            else:
                left_pointer += 1
                right_pointer += 1
        return intervals
                