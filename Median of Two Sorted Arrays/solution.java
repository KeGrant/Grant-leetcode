class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int p = 0, q = 0, r = 0;
        int[] newnums = new int[nums1.length + nums2.length];
        if (nums1.length == 0){
            if (nums2.length % 2 == 1)
                return nums2[(nums2.length - 1) / 2];
            else
                return (nums2[nums2.length / 2] + nums2[nums2.length / 2 - 1]) / 2.0;
        }
        else if (nums2.length == 0){
            if (nums1.length % 2 == 1)
                return nums1[(nums1.length - 1) / 2];
            else
                return (nums1[nums1.length / 2] + nums1[nums1.length / 2 - 1]) / 2.0;
        }
        while(p<nums1.length && q<nums2.length){
            if (nums1[p] < nums2[q]){
                newnums[r++] = nums1[p++];
            }
            else{
                newnums[r++] = nums2[q++];
            }
        }   
        if (p<nums1.length)
            for(;p<nums1.length;p++)
                newnums[r++] = nums1[p];
        else
            for(;q<nums2.length;q++)
                newnums[r++] = nums2[q];
        r = nums1.length + nums2.length;
        if (r % 2 == 1)
            return (float) newnums[(r - 1) / 2];
        else
            return ((float) newnums[r / 2] + (float) newnums[r / 2 - 1 ]) / 2.0;   
    }
}
