class Solution:
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        if s == "":
            return 0
        List = []
        Length = 0
        Max = 0
        for ch in s:
            if ch not in List:
                List.append(ch)
                Length += 1
            else:
                while ch in List:
                    del List[0]
                List.append(ch)
                Length = len(List)
            if Length > Max:
                Max = Length
        
        return Max