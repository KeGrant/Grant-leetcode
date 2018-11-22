import numpy as np

class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        if len(s) <= 0:
            return ""
        strlen = len(s)
        matrix = np.zeros((strlen, strlen))
        maxlen = 0
        left = 0
        right = 0
        for i in range(strlen):
            for j in range(i+1):
                if i == j:
                    matrix[i, j] = 1
                elif i - j == 1:
                    matrix[i, j] = s[i] == s[j]
                else:
                    matrix[i, j] = (s[i] == s[j]) and (matrix[i - 1, j + 1])
                if matrix[i, j] and maxlen < (i - j + 1):
                    maxlen = i - j + 1
                    left = j
                    right = i + 1
        return s[left:right]