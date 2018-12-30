/*
297. Serialize and Deserialize Binary Tree
*/

public class Codec {

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
         sb = preorder(root,sb);
         String s = sb.toString();
        return s.substring(0,s.length()-1);
    }
    
    private StringBuilder preorder(TreeNode root,StringBuilder res){
        if(root == null){
             res.append("null,");
            return res;
        }
        res.append(root.val+",");
         preorder(root.left,res);
         preorder(root.right,res);
        
        return res;
    }

    public TreeNode deserialize(String data) {
        String[] d= data.split(",");
        int i[] = new int[1];       
        i[0] = 0;        
        return construct(null,d,i);

    }
    
    public TreeNode construct(TreeNode root, String[] d, int[] i){
        int ind = i[0];
        if(d[ind].equals("null"))
        {
            i[0]++;
            return null;
        }
        root = new TreeNode(Integer.parseInt(d[ind]));
        i[0]++;
        root.left = construct(root.left,d,i);
        root.right = construct(root.right,d,i);
        
       return root;
    }
    
}
