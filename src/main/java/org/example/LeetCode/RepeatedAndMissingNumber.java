package org.example.LeetCode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepeatedAndMissingNumber {
    public static void main(String[] args) {
        RepeatedAndMissingNumber repeatedAndMissingNumber = new RepeatedAndMissingNumber();
        List<Integer> list = Arrays.asList(3, 1, 2, 5, 3);
        ArrayList<Integer> integers = repeatedAndMissingNumber.repeatedNumber(list);
        System.out.println(integers);
    }

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> repeatedNumber(final List<Integer> list) {
        int n = list.size();
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i) - 1);
        }
        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i) % n;
            list.set(num, list.get(num) + n);
        }
        int miss = -1;
        int rep = -1;
        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            if (num / n == 0) {
                rep = i+1;
            }
            if (num / n == 2) {
                miss = i+1;
            }
        }
        return new ArrayList<>(Arrays.asList(rep, miss));
    }
}