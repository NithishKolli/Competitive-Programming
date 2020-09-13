class Solution:
    def largestTimeFromDigits(self, arr: List[int]) -> str:
        h1_limit = 2
        h2_limit = 9
        s_limit = 6
        for h1 in range(2,-1,-1):
            if h1 in arr:
                arr.remove(h1)
                if h1 == 2:
                    h2_limit = 3
                else:
                    h2_limit = 9
                for h2 in range(h2_limit, -1, -1):
                    if h2 in arr:
                        arr.remove(h2)
                        for s in range(5, -1, -1):
                            if s in arr:
                                arr.remove(s)
                                return str(h1)+str(h2)+':'+str(s)+str(arr[0])
                        arr.append(h2)
                arr.append(h1)
        return ""