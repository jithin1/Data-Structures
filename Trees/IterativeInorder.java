/** Solution to 94). Binary Tree Inorder Traversal  
 Link : https://leetcode.com/problems/binary-tree-inorder-traversal/description/      */


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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list= new ArrayList<Integer>();
        Stack<TreeNode> st = new Stack<TreeNode>();
        
        if(root == null)
            return list;
        
        TreeNode temp = root;
         st.push(temp);
        
        while(temp.left != null){
            temp=temp.left;
            st.push(temp);
        }
        
        while(!st.isEmpty()){
            
            temp = st.pop();
            list.add(temp.val);
            
            if(temp.right != null){
                temp=temp.right;
                st.push(temp);
                while(temp.left != null){
                    temp = temp. left;
                    st.push(temp);
                }
            }
        }
        
        return list;
    }
}
