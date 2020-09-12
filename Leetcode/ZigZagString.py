class Solution:
    def convert(s: str, numRows: int) -> str:
        rs = ""
        if numRows == 1:
            return s
        for i in range(numRows):
            index = i +1
            print("for", i,numRows)
            if i == 0 or i == numRows-1:
                while index <= len(s):
                    print(index)
                    rs += s[index-1]
                    index = index + 2 * numRows - 2
                    print(rs,index)
            else:
                index1 = i + 1
                index2 = index1 + 2 *(numRows - i - 1)
                while index1 <= len(s) and index2 <= len(s):
                    if index2 == 0:
                        rs += s[index1-1]
                        # print(rs)
                    else:
                        print(rs, index1, index2)
                        rs += s[index1-1] + s[index2-1]
                    index1 = index1 + 2 * (numRows-1)
                    index2 = index1 + 2 *(numRows - i - 1)
                if index1 <= len(s):
                    rs += s[index1-1]
        return rs

if __name__ == '__main__':
    # numRows = 3
    s = "PAYPALISHIRING"
    s = 'A'
    numRows = 1
    Solution.convert(s, numRows)