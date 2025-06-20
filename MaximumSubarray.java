public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int currmax =nums[0];
        int maxsum =nums[0];

        if(nums.length == 1)
        {
            return nums[0];
        }

        for(int i=1;i<nums.length;i++)
        {
            //decide to expand or start a new subarray
            currmax = Math.max(nums[i], currmax+nums[i]);

            //see if its greater than prev sum
            maxsum = Math.max(maxsum, currmax);
        }

        return maxsum;
    }
}
