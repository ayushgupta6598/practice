package org.example.LeetCode;

public class CountAndSay {
    public static void main(String[] args) {
        CountAndSay solution = new CountAndSay();
        int n = 5; // Example input
        String result = solution.countAndSay(n);
        System.out.println("The " + n + "th term in the count-and-say sequence is: " + result);
    }

    public String countAndSay(int n) {
        if(n==1) return "1";
        String s= countAndSay(n-1);
        StringBuilder rep=new StringBuilder();
            int i=1;
            int count=1;
            char element= s.charAt(0);
            while(i<s.length()){
                if(s.charAt(i)==element){
                    count++;
                }else {
                    rep.append(count).append(element);
                    element=s.charAt((i));
                    count=1;
                }
                i++;
            }
        rep.append(count).append(element);
        return rep.toString();
    }
}
