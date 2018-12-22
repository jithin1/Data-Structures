/*
Given a list of strings words representing an English Dictionary, find the longest word in words that can be built one character at a 
time by other words in words. If there is more than one possible answer, return the longest word with the smallest lexicographical order.

If there is no answer, return the empty string.
Example 1:  // Trie using hashMap

Input: 
words = ["w","wo","wor","worl", "world"]
Output: "world"
Explanation: 
The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".

class Solution {
       
    public String longestWord(String[] words) {
        Trie tn = new Trie();
        tn.words = words;
        for(int i=0; i<words.length; i++)
        tn.insert(words[i],i);
           return tn.search();
    }
}  */
    
    class Node{
        int c;
        int index=-1;
        HashMap<Character,Node> children = new HashMap();
        
        public Node(char c){
            this.c=c;
        }
    }
    
   class Trie{
        Node root;
        String[]words;  
       public Trie(){
         root = new Node('0');
       }
       
       public void insert(String words,int index){
           Node cur = root;
           
               for(char c: words.toCharArray()){
                   cur.children.putIfAbsent(c,new Node(c));
                   cur=cur.children.get(c);
               }
                cur.index = index;
           }
       
       public String search(){
           String result = "";
           Stack<Node> st = new Stack();
           st.push(root);
           
           while(!st.isEmpty()){
               Node temp = st.pop();
               while(temp == root || temp.index >= 0){
                   if(temp != root){
                       String word = words[temp.index];
                    if(word.length() > result.length() || word.length() == result.length() && word.compareTo(result) < 0)
                        result = word;
                   }
               
               for(Node c : temp.children.values()){
                   st.push(c);
                 }
              }
           }
           
           return result;
       }
       
    }
    
    Time complexity for insertiion = O(n)
    Time complexity for searching a query is O(logn)
    
