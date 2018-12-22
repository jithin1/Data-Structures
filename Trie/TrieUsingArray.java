 /*
 In English, we have a concept called root, which can be followed by some other words to form another longer word - let's call this word 
 successor. For example, the root an, followed by other, which can form another word another.

Now, given a dictionary consisting of many roots and a sentence. You need to replace all the successor in the sentence with the root
forming it. If a successor has many roots can form it, replace it with the root with the shortest length.

You need to output the sentence after the replacement.

Example 1:
Input: dict = ["cat", "bat", "rat"]
sentence = "the cattle was rattled by the battery"
Output: "the cat was rat by the bat"
*/

class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        Trie tn = new Trie(); 
            
         for(String str : dict){
             tn.insert(str);
         }
        String[] words = sentence.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        
          for(String word:words){
             stringBuilder.append(tn.search(word)+" ");
          }
        return stringBuilder.substring(0, stringBuilder.length()-1);
    }
    
}
 
    class Node{
        Node[] children;
        boolean isEnd;
        
        public Node(){
            children = new Node[26];
        }
    }
        
         class Trie{
             Node root = new Node();
             
        public void insert(String s){
            Node cur =root;
             for(int i=0; i<s.length(); i++){
            if(cur.children[s.charAt(i) - 'a'] == null)
                cur.children[s.charAt(i) - 'a'] = new Node();
                 
                 cur = cur.children[s.charAt(i) - 'a'];
            }
            cur.isEnd = true;
        }
             
         public String search(String word){
             Node cur = root;                          
             int i=0;             
              int n = word.length();
           StringBuilder stringBuilder = new StringBuilder();

             while(!cur.isEnd){
               
                 
                 if( i == n || cur.children[word.charAt(i) - 'a'] == null)
                  return word;
                 cur = cur.children[word.charAt(i) - 'a'];
                 stringBuilder.append(word.charAt(i));
                 i++;
             }
             
             return stringBuilder.toString();
         }
    }

Time complexity for insertion is O(n)
Time complexity for search is O(logn)
