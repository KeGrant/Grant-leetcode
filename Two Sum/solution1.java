class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> m = new Hashmap();
        for(int i=0;i<nums.length;i++){
            m.put(nums[i], i);
        }
        for(int i=0;i<nums.length;i++){
            int complement = target - nums[i];
            if (m.containsKey(complement) && m.get(complement) != i){
                return new int[] {i, m.get(complement)};
            }
        }
        return new int[] {0, 1};
    }
}