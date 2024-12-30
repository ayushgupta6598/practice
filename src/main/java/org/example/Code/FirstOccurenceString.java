package org.example.Code;


public class FirstOccurenceString {
    public static void main(String[] args) {
        // Create an instance of Solution
        FirstOccurenceString solution = new FirstOccurenceString();
        // Test case with the given haystack and needle
        String haystack = "leetcode";
        String needle = "leeto";

        // Call the strStr method and print the result
        int result = solution.strStr(haystack, needle);
        System.out.println("Index of '" + needle + "' in '" + haystack + "': " + result);

        // Additional test cases if needed
        haystack = "onionsiononions";
        needle = "onions";
        result = solution.strStr(haystack, needle);
        System.out.println("Index of '" + needle + "' in '" + haystack + "': " + result);

        haystack = "onion";
        needle = "onions";
        result = solution.strStr(haystack, needle);
        System.out.println("Index of '" + needle + "' in '" + haystack + "': " + result);
    }


        public int strStr(String haystack, String needle) {
            int first=0;
            int second=0;
            int[] lps= new int[needle.length()];
            findLpsNeedle(needle, lps);

            while(first<haystack.length() && second<needle.length()){
                if(haystack.charAt(first)==needle.charAt(second)){
                    first++;
                    second++;
                }else{
                    if(second==0){
                        first++;

                    }else{
                        second=lps[second-1];
                    }

                }
            }
            if(second==needle.length()){
                return first-second;
            }
            return -1;

        }

        public void findLpsNeedle(String needle, int[] lps){
            int pre=0;
            int suf=1;
            while(suf<needle.length()){
                if(needle.charAt(pre)==needle.charAt(suf)){
                    lps[suf]=pre+1;
                    pre++;
                    suf++;
                }else{
                    if(pre==0){
                        lps[suf]=0;
                        suf++;
                    }else{
                        pre= lps[pre-1];
                    }
                }
            }


        }

}
