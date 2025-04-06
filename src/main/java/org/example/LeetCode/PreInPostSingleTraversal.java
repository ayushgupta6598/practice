package org.example.LeetCode;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*********************************************************

 Following is the TreeNode structure:

 class TreeNode {
 int data;
 TreeNode left;
 TreeNode right;
 TreeNode() {
 this.data = 0;
 this.left = null;
 this.right = null;
 }
 TreeNode(int data) {
 this.data = data;
 this.left = null;
 this.right = null;
 }
 TreeNode(int data, TreeNode left, TreeNode right) {
 this.data = data;
 this.left = left;
 this.right = right;
 }
 };
 ********************************************************/

public class PreInPostSingleTraversal {
    static class Pair<T, I extends Number> {
        TreeNode node;
        int hd;

        Pair(TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }
    // TreeNode class as given in the problem description
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
            this.val = 0;
            this.left = null;
            this.right = null;
        }

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public static List<List<Integer>> getTreeTraversal(TreeNode root) {
        Stack<Pair<TreeNode, Integer>> stack= new Stack<>();
        List<List<Integer>> list =new ArrayList<>();
        List<Integer> preorder =new ArrayList<>();
        List<Integer> inorder =new ArrayList<>();
        List<Integer> postorder =new ArrayList<>();
        if(root==null) return list;
        TreeNode demo= root;
        stack.add(new Pair<>(demo, 1));
        while(!stack.isEmpty()){
            Pair<TreeNode, Integer> pair=stack.pop();
            TreeNode temp= pair.node;
            Integer iter= pair.hd;

            if(iter==1){
                preorder.add(temp.val);
                stack.add(new Pair<TreeNode, Integer>(temp, iter+1));
                if(temp.left!=null){
                    stack.add(new Pair<TreeNode, Integer>(temp.left, 1));
                }

            }

            else if(iter==2){
                inorder.add(temp.val);
                stack.add(new Pair<TreeNode, Integer>(temp, iter+1));
                if(temp.right!=null){
                    stack.add(new Pair<TreeNode, Integer>(temp.right, 1));
                }
            } else if(iter==3){
                postorder.add(temp.val);

            }

        }
        list.add(preorder);
        list.add(inorder);
        list.add(postorder);
        return list;
    }

    public static void main(String[] args) {
        // Example Input: level-order traversal
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);

        // Get the tree traversals
        List<List<Integer>> result = getTreeTraversal(root);

        // Print the traversals
        System.out.println("Preorder: " + result.get(0)); // Preorder
        System.out.println("Inorder: " + result.get(1));  // Inorder
        System.out.println("Postorder: " + result.get(2)); // Postorder
    }


}