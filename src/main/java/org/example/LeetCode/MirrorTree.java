package org.example.LeetCode;

// Definition for a binary tree node
class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int item) {
        data = item;
        left = right = null;
    }
}

class MirrorTree {
    public static void main(String[] args) {
        // Example: Creating a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println("Original Tree (Inorder Traversal):");
        inorderTraversal(root);

        // Create an instance of the solution and call the mirror method
        MirrorTree solution = new MirrorTree();
        solution.mirror(root);

        System.out.println("\nMirror Tree (Inorder Traversal):");
        inorderTraversal(root);
    }

    // Helper function for inorder traversal
    public static void inorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left);
        System.out.print(node.data + " ");
        inorderTraversal(node.right);
    }
//    }
//               1
//        3           2
//   5                    4

    // Function to convert a binary tree into its mirror tree
    public static void mirror(TreeNode node) {
        // Your code here
        if(node== null){
            return ;
        }
        if(node.left!= null || node.right !=null){
            TreeNode temp= node.left;
            node.left=node.right;
            node.right=temp;
        }
        mirror(node.left);
        mirror(node.right);





    }


}


