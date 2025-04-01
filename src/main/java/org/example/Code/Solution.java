package org.example.Code;

import java.util.Arrays;

class LargestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[][] dp= new int[nums.length+1][nums.length+1];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        return findLis(0,-1, nums, dp);
        
    }
    public int findLis(int idx, int prev_idx, int[] nums, int[][] dp){
        if(idx==nums.length) return 0;
        // int notTake= findLis(idx+1, prev_idx, nums);
        //NotTake
        if(dp[idx][prev_idx+1]!=-1) return dp[idx][prev_idx+1];

        int len= findLis(idx+1, prev_idx, nums, dp);

        if(prev_idx ==-1 || nums[idx]> nums[prev_idx]){
            // int take= 1+ findLis(idx+1, idx, nums);
            //Take and then find max of it
            len= Math.max(len, 1+ findLis(idx+1, idx, nums, dp));
        }
        return dp[idx][prev_idx+1]=len;


    }
}