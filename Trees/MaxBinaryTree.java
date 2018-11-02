
//Leetcode 654 - Maximum Binary Tree

/* Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

    The root is the maximum number in the array.
    The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
    The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.

Construct the maximum tree by the given array and output the root node of this tree. */


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int end = nums.length -1;
        TreeNode root = construct(nums,0,end);
        return root;
    }
    
    public TreeNode construct(int[] nums, int str, int end){
        if(str > end)
            return null;
        
        int ind = find(nums,str,end);
        TreeNode root = new TreeNode(nums[ind]);
        root.left = construct(nums,str,ind-1);  
        root.right = construct(nums,ind+1,end);
         return root;
    }
    
    public int find(int[] nums, int str, int end){
         int temp = Integer.MIN_VALUE;
         int high = 0;
         for(int i=str; i<=end; i++){
             if(temp < nums[i]){
                 temp = nums[i];
                 high = i;
             }
         }
        
        return high;
    }
}
