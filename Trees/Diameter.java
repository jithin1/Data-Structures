
Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the 
longest path between any two nodes in a tree. This path may or may not pass through the root.
     
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
    int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
             getHeight(root);
             return maxDiameter;
    }
    
      public int getHeight(TreeNode a){
          
            if(a==null)
            return 0;
            
            int lefth = getHeight(a.left);
            int righth = getHeight(a.right);
            int diameter = lefth+righth;
            maxDiameter = Math.max(maxDiameter,diameter);
            return 1+Math.max(lefth,righth);
         }
}
