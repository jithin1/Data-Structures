/*
 LeetCode 814. Binary Tree Pruning

We are given the head node root of a binary tree, where additionally every node's value is either a 0 or a 1.

Return the same tree where every subtree (of the given tree) not containing a 1 has been removed.

(Recall that the subtree of a node X is X, plus every node that is a descendant of X.)

Example 1:
Input: [1,null,0,0,1]
Output: [1,null,0,null,1]
*/

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
    public TreeNode pruneTree(TreeNode root) {
        if(root == null)
            return root;
        
         root.left = pruneTree(root.left);
         root.right = pruneTree(root.right);

          if((root.val == 0) && (root.left == null) && (root.right == null))  // remove the 0 node when both children are having null or
                                                                                       // when both children are not equal to one
               return null;
                       
        else 
            return root;            
        
    }
}
