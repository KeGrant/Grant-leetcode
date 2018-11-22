class Solution:
    def convert(self, s, numRows):
        """
        :type s: str
        :type numRows: int
        :rtype: str
        """
        if numRows == 1:
            return s
        strlen = len(s)
        cycleLen = 2 * numRows - 2
        ret = ""
        for i in range(numRows):
            for j in range(0, strlen - i, cycleLen):
                ret += s[j+i]
                if (i != 0  and i != numRows - 1 and j + cycleLen - i < strlen):
                    ret += s[j + cycleLen - i]
        
        return ret