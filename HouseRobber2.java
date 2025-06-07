import java.util.Arrays;

public class HouseRobber2 {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 0) return 0; // Handle empty array case
        if (n == 1) return nums[0];

        // Subproblem 1: Rob houses from index 0 to n-2 (excluding the last house)
        // Create a new dp array for this subproblem, sized for the subproblem's length
        int[] dp1 = new int[n - 1]; // Size N-1 for subarray of length N-1
        Arrays.fill(dp1, -1);
        int res1 = solve(nums, 0, n - 2, dp1); // Pass original nums, start/end indices, and dp1

        // Subproblem 2: Rob houses from index 1 to n-1 (excluding the first house)
        // Create a new dp array for this subproblem
        int[] dp2 = new int[n - 1]; // Size N-1 for subarray of length N-1
        Arrays.fill(dp2, -1);
        int res2 = solve(nums, 1, n - 1, dp2); // Pass original nums, start/end indices, and dp2

        return Math.max(res1, res2);
    }

    
    public int solve(int[] nums, int current_index, int end_index, int[] dp) {

        // Base cases
        if (current_index > end_index) {
            return 0;
        }
        if (current_index == end_index) {
            return nums[current_index]; // This base case is correct for the logic.
        }

       

        if (dp[current_index] != -1) {
            return dp[current_index];
        }

        int pick = nums[current_index] + solve(nums, current_index + 2, end_index, dp);
        int notPick = 0 + solve(nums, current_index + 1, end_index, dp);

        return dp[current_index] = Math.max(pick, notPick);
    }
}
