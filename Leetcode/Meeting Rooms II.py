# https://leetcode.com/problems/meeting-rooms-ii/

from queue import PriorityQueue
class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        intervals = sorted(intervals, key= lambda x: x[0])
        if len(intervals) < 2:
            return len(intervals)
        q = PriorityQueue()
        q.put(intervals[0][1])
        max_count = 1
        curr_count = 1
        for i in range(1, len(intervals)):
            print(q.queue)
            while not q.empty() and intervals[i][0] >= q.queue[0]:
                q.get()
                curr_count -= 1
            q.put(intervals[i][1])
            curr_count += 1
            print(curr_count)
            max_count = max(curr_count, max_count)
        return max_count