package org.example.Code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortNumberWithoutIfElse {

    public static void main(String[] args){
        List<Integer> list = Arrays.asList(1,0,1,2,2,0,1,0,2);
        List<Integer> sortedArray = findSortedArray(list);
        System.out.println(sortedArray);
    }

    private static List<Integer> findSortedArray(List<Integer> list) {
        Map<Integer, Integer> map =new HashMap<>();
        map.put(0,0);
        map.put(1,0);
        map.put(2,0);

        for(int i=0;i<list.size();i++){
            map.put(list.get(i),map.getOrDefault(list.get(i),0)+1);
        }
        int j=0;
        int i=0;
        for(Map.Entry<Integer, Integer> m:map.entrySet()){
            int count=map.get(j);
            int loop=0;
            while(loop<count) {
                list.set(i, j);
                i++;
                loop++;
            }
            j++;
        }

        return  list;


    }
}
