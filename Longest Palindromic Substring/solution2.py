class Solution:
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        if len(s) <= 0:
            return ""
        left = 0
        right = 0
        for i in range(len(s)):
            len1 = self.expandAroundCenter(s, i, i)
            len2 = self.expandAroundCenter(s, i, i+1)
            maxlen = max(len1, len2)
            if maxlen > right - left:
                left = i - (maxlen - 1) // 2
                right = i + maxlen // 2
        
        return s[left:right+1]
    
    def expandAroundCenter(self, s, left, right):
        L = left
        R = right
        while(L >= 0 and R < len(s) and s[L] == s[R]):
            L -= 1
            R += 1
        return R - L - 1 