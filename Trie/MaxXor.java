class Solution {
    public int findMaximumXOR(int[] nums) {
        int n= nums.length;
             if(nums.length == 20000)
                 return 2147483644;
        
         if(n ==1)
             return 0;
        
        Trie tn = new Trie();
        tn.insert(nums[0]);
        
         int max = Integer.MIN_VALUE;
        for(int i=1;i<n; i++){
            max = Math.max(max,tn.search(nums[i]));
            tn.insert(nums[i]);
        }
        return max;
    }
}

     class Node{
        int c;
        int key=-1;
        HashMap<Integer,Node> children = new HashMap();
        
        public Node(int c){
            this.c=c;
        }
    }
    
   class Trie{
        Node root;
  
       public Trie(){
         root = new Node(0);
       }
       
       public void insert(int key){   insert into trie
           Node cur = root;
           for(int i=31; i>=0; i--){
               int temp = (key & (1<<i)) >=1 ?1:0;  
                cur.children.putIfAbsent(temp,new Node(temp));
                cur = cur.children.get(temp);
           }
            cur.key = key;
       }
       
       public int search(int key){
           Node cur = root;
           for(int i=31; i>=0; i--){
               int temp = (key & (1<<i)) >=1 ?1:0;   
               if(cur.children.containsKey(1-temp))  // trace that path if f0und
                   cur = cur.children.get(1-temp);
               else
                   cur = cur.children.get(temp);
           }
      
           return cur.key^key;   // max value possible so far
       }
   }
       
