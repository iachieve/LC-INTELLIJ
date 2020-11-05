//Given an array of integers nums and an integer k, return the total number of c
//ontinuous subarrays whose sum equals to k. 
//
// 
// Example 1: 
// Input: nums = [1,1,1], k = 2
//Output: 2
// Example 2: 
// Input: nums = [1,2,3], k = 3
//Output: 2
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 2 * 104 
// -1000 <= nums[i] <= 1000 
// -107 <= k <= 107 
// 
// Related Topics Array Hash Table 
// 👍 5847 👎 195


//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // from intellij
        // 2-30
        public int subarraySum(int[] nums, int k) {
            int count = 0;
            int sums[] = new int[nums.length + 1];
            sums[0] = 0;
            for (int i = 1; i <= nums.length; i++) {
                sums[i] = nums[i-1] + sums[i-1];
            }
            for (int start = 0; start < nums.length; start++) {
                for (int end = start + 1; end <= nums.length ; end++) {
                    if(sums[end] - sums[start] == k) count++;
                }
            }
            return  count;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)
