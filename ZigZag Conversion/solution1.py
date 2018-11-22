class Solution(object):
    def convert(self, s, numRows):
        """
        :type s: str
        :type numRows: int
        :rtype: str
        """
        if numRows == 1:
            return s
        rows = ["" for i in range(numRows)]
        curRow = 0
        goingDown = False
        for i in range(len(s)):
            rows[curRow] += s[i]
            if (curRow == 0 or curRow == numRows - 1):
                goingDown = ~goingDown
            curRow += 1 if goingDown else -1
        
        ret = ""
        for row in rows:
            ret += row

        return ret