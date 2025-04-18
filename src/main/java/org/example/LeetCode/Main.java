package org.example.LeetCode; /******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.*;
public class Main
{
	public static void main(String[] args) {
// 		System.out.println("Hello World");
	    //find frequency
	    int[] arr={1,1,1,1,1,3,5,6,6};
	    HashMap<Integer, Integer> freqMap= new HashMap<>();
	    for(int num:arr){
	        freqMap.put(num, freqMap.getOrDefault(num,0)+1);
	    }
	    //find order
	    LinkedHashMap<Integer, Integer> linkMap=
	                new LinkedHashMap<Integer, Integer>();
	    for(int i=0;i<arr.length;i++){
	        if(!linkMap.containsKey(arr[i])){
	            linkMap.put(arr[i],i);
	        }
	    }
	    //sort it accordingly
	    List<Integer> result= new ArrayList<>(linkMap.keySet());
	    result.sort(
	        (a,b)-> {
	            int x= freqMap.get(b)- freqMap.get(a);
	            if(x!=0){
	                return x;
	            }
	            return linkMap.get(b)- linkMap.get(a);
	        });
	        for(int res: result){
	            System.out.print( res +" ");
	        }
	        
	    
	    
	}
}
