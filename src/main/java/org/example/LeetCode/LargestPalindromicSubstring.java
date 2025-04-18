package org.example.LeetCode;

/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
public class LargestPalindromicSubstring
{
	public static void main(String[] args) {
		System.out.println("Hello World");
		String str="XyABCDDCBAzx";
// 		"XyABCDDCBAzxyz";
        int start=0; 
        int end= 0;
        
        for(int i=0;i<str.length();i++){
            int len1= expandFromCenter(str,i,i);
            int len2= expandFromCenter(str,i,i+1);
            int len= Math.max(len1, len2);
            if(len>end-start){
                start=i-(len-1)/2;
                end=i+ (len/2);
            }
        }
        System.out.println(str.substring(start,end+1));
        
	}
	public static int expandFromCenter(String str,int left
	   ,int right){
	       while(left>=0 && right< str.length()
	                && str.charAt(left)==str.charAt(right)){
	                    left--;
	                    right++;
	                }
	                return right-left-1;
	   }
	   
}
