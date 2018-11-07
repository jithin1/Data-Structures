/*
889. Construct Binary Tree from Preorder and Postorder Traversal
  Return any binary tree that matches the given preorder and postorder traversals.

Values in the traversals pre and post are distinct positive integers.

Example 1:

Input: pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
Output: [1,2,3,4,5,6,7]

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
    int i = 0;
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        int high = pre.length -1;
        return construct(pre,post,0,high);
    }
    
    public TreeNode construct(int[] pre, int[] post, int low, int high){
        if(low > high)
            return null;
        
        TreeNode root = new TreeNode(pre[i++]);
        
          if(i == pre.length)   // traversal is complete
              return root;
        
          int r = pre[i];   // new root
          int split = findRoot(r,low,high-1,post);
        
          if(split == -1)   // we cannot go any more left or element not found
          {
              root.left = null;
              root.right = null;
          }
        
        else{
         root.left= construct(pre,post,low,split);
         root.right = construct(pre,post,split+1,high-1);
        }
        
        return root;
    }
    
    public int findRoot(int root,int low,int high, int[] post){   // function to determine where to split the subarray
        
        
        for(int j= low; j<=high; j++)
            if(post[j] == root)
                return j;
        
        return -1;
   }
}
