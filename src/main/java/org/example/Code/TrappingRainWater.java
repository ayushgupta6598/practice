package org.example.Code;

/*
*
*
42. Trapping Rain Water
Hard

32840

552

Add to List

Share
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it
*  can trap after raining.
Example 1:
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:
Input: height = [4,2,0,3,2,5]
Output: 9
Constraints:

n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105
Accepted
2,455,983
Submissions
3,865,617
Seen this question in a real interview before?

1
class Solution {
2
    public int trap(int[] height) {
    }
}
*/



public class TrappingRainWater {

    public static void main(String[] args){
        int[] height=new int[]{1,1,0,1,1,1};
        int trap = trap(height);
        System.out.println(trap);


    }
    public static int trap(int[] nums) {

            int maxOne=0,count=0;
            for(int i=0;i<nums.length;i++){
                if(nums[i]== 1){
                    count++;
                }else{
                    if(count>maxOne){
                        count=maxOne;
                    }
                    count=0;
                }
            }
            return maxOne;
        }






}
