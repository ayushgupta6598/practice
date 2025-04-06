package org.example.LeetCode;


import java.util.ArrayList;
import java.util.List;

//493. Reverse Pairs
//Hard
//        Topics
//Companies
//        Hint
//Given an integer array nums, return the number of reverse pairs in the array.
//
//A reverse pair is a pair (i, j) where:
//
//        0 <= i < j < nums.length and
//nums[i] > 2 * nums[j].
//
//
//Example 1:
//
//Input: nums = [1,3,2,3,1]
//Output: 2
//Explanation: The reverse pairs are:
//        (1, 4) --> nums[1] = 3, nums[4] = 1, 3 > 2 * 1
//        (3, 4) --> nums[3] = 3, nums[4] = 1, 3 > 2 * 1
//Example 2:
//
//Input: nums = [2,4,3,5,1]
//Output: 3
//Explanation: The reverse pairs are:
//        (1, 4) --> nums[1] = 4, nums[4] = 1, 4 > 2 * 1
//        (2, 4) --> nums[2] = 3, nums[4] = 1, 3 > 2 * 1
//        (3, 4) --> nums[3] = 5, nums[4] = 1, 5 > 2 * 1
//
//
//Constraints:
//
//        1 <= nums.length <= 5 * 104
//        -231 <= nums[i] <= 231 - 1
public class ReversePairs {
    public static void main(String[] args) {
        ReversePairs reversePairs=new ReversePairs();
        int[] nums= {1,3,2,3,1};
        reversePairs.reversePairs(nums);
    }
    public void reversePairs(int[] nums) {
        int low=0,high=nums.length-1;
        int count = mergeSort(nums, low, high);
//        for(int num: nums){
//            System.out.println(num);
//        }
        System.out.println(count);


    }

    private int mergeSort(int[] nums, int low, int high) {
        if(low>=high) return 0;
        int mid= low +(high-low)/2;
        int count=0;
        count+=mergeSort(nums, low, mid);
        count+=mergeSort(nums, mid+1, high);
        count+=countPairs(nums, low , mid , high);
        merge(nums, low, mid, high, count);
        return  count;
    }

    private int countPairs(int[] nums, int low, int mid, int high) {
        int count=0;
        int right=mid+1;
        for(int i=low;i<=mid;i++){
            while(right<=high && nums[i]>=2*nums[right]){
                right++;
            }
            count+=right-(mid+1);

        }
        return count;
    }

    public int merge(int[] nums, int low , int mid, int high, int count){
        List<Integer> list = new ArrayList<>();

        int i=low;int j=mid+1;
        while(i<=mid && j<=high){
            if(nums[i]<= nums[j]){
                list.add(nums[i]);
                i++;
            }else{
                count+=mid-low+1;
                list.add(nums[j]);
                j++;
            }
        }
        while(i<=mid){
            list.add(nums[i]);i++;
        }
        while(j<=high){
            list.add(nums[j]);j++;
        }

        for( i = low; i<=high;i++){
            nums[i]=list.get(i-low);
        }
        return count;
    }

}

