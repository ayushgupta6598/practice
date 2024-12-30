package org.example.Code;

import java.util.*;

class SubsetsWithDuplicates {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); // Sort the array to handle duplicates
        List<List<Integer>> res = new ArrayList<>();
        generateSubsets(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void generateSubsets(int[] nums, int index, List<Integer> current, List<List<Integer>> res) {
        if (index == nums.length) {
            res.add(new ArrayList<>(current)); // Add the current subset to the result
            return;
        }

        // Include the current element
        current.add(nums[index]);
        generateSubsets(nums, index + 1, current, res);
        current.remove(current.size() - 1); // Backtrack

        // Skip duplicates
        while (index + 1 < nums.length && nums[index] == nums[index + 1]) {
            index++;
        }

        // Exclude the current element
        generateSubsets(nums, index + 1, current, res);
    }
}
