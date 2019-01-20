/*
Given an encoded string, return it's decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k
is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For 
example, there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".

*/

class Solution {
    public String decodeString(String s) {
        StringBuilder result = new StringBuilder();
        Stack<String> st = new Stack();
     
        int length = s.length();
        int open =0;
        int i=0;
        
        while(i < length){
          if(Character.isDigit(s.charAt(i))){
              StringBuilder sb = new StringBuilder();
              while(Character.isDigit(s.charAt(i))){
              sb.append(s.charAt(i));
              i++;
              }
              st.push(sb.toString());
           }
            
            else if(s.charAt(i) == '['){
                st.push("#");
                    i++;
                open++;
                
                while(open != 0){
                    
                    if(Character.isLetter(s.charAt(i))){
                        StringBuilder sb = new StringBuilder();
                        while(Character.isLetter(s.charAt(i))){
                            sb.append(s.charAt(i));
                            i++;
                        }
                        
                        st.push(sb.toString());
                    }
                    
              else if(Character.isDigit(s.charAt(i))){
              StringBuilder sb = new StringBuilder();
                  
                  while(Character.isDigit(s.charAt(i))){
                  sb.append(s.charAt(i));
                  i++;
                 }
                  st.push(sb.toString());
               }
                    
             else if(s.charAt(i) == ']'){
                 open--;
                 StringBuilder sb = new StringBuilder();
                       while(st.peek() != "#"){
                          sb.insert(0,st.pop());
                       }
                       st.pop();  // pop #
                      String rep = sb.toString();
                      int count = Integer.parseInt(st.pop()); // digit
                      while(count > 1){
                          sb.append(rep);
                          count--;
                      }
                     st.push(sb.toString());  // store result
                     i++;
                 }
              else{
                 st.push("#");  // open bracket
                  i++;
                  open++;
               }
            }
                result.append(st.pop());   // final result
          }
        else{
            result.append(s.charAt(i));
            i++;
        }
    }   
        return new String(result);
    }
}
