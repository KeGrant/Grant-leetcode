class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        l1 = len(nums1)
        l2 = len(nums2)
        if(l1 == 0):
            if (l2 % 2 == 1):
                return nums2[(l2 - 1) / 2]
            else:
                return (nums2[l2 / 2] + nums2[l2 / 2 - 1]) / 2.0
        elif(l2 == 0):
            if (l1 % 2 == 1):
                return nums1[(l1 - 1) / 2]
            else:
                return (nums1[l1 / 2] + nums1[l1 / 2 - 1]) / 2.0
        p = 0
        q = 0
        newl = []
        while(p < l1 and q < l2):
            if(nums1[p] < nums2[q]):
                newl.append(nums1[p])
                p += 1
            else:
                newl.append(nums2[q])
                q += 1
        while(p < l1):
            newl.append(nums1[p])
            p += 1
        while(q < l2):
            newl.append(nums2[q])
            q += 1
        l = l1 + l2
        if (l % 2 == 1):
            return newl[(l - 1) / 2]
        else:
            return (newl[l / 2] + newl[l / 2 - 1]) / 2.0