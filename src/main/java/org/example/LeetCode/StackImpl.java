package org.example.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class StackImpl {
    List<Integer> stackList;

    StackImpl() {
        stackList = new ArrayList<>();
    }

    //push
    public void push(Integer data) {
        stackList.add(data);
    }
    //pop
    public Integer pop() {
        return stackList.remove(stackList.size()-1);
    }
    //peek
    public Integer peek(){
        return stackList.get(stackList.size()-1);
    }
    public boolean isEmpty() {
        return stackList.isEmpty();
    }


    public static void main(String[] args) {
        StackImpl stack= new StackImpl();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());

    }






}
