/* Write a program to insert %20 between the words of the string
 For example Mr John Smith will be converted to Mr%20John%20Smith */
 
 
     import java.util.Arrays;

    // Starting backward will help as we have an extra buffer towards the end
  public class Insertintospace
  {
	public static void main(String[] args)
	{
	    String s="Mr John Smith    ";
	      
            String t=s;
            t.trim();
               char c[]=s.toCharArray();
               String[] words=t.split(" "); // to find wordcount

                 int wrdcount=words.length-1; // to know the spaces
                 
                 int i = s.length() - 1 - 2*(wrdcount);  // to reach the last character of the char array
               while(wrdcount>0){           // for all possible spaces
                     int space=wrdcount*2;   //2 extra spaces to insert %20
                      while(c[i]!=' '){     //trace back till we reach space
                           c[i+space]=c[i];
                          i--;
                      }
                       c[i+space]='0';     //insert the characters
                       c[i+space-1]='2';
                       c[i+space-2]='%';
                       wrdcount--;
                       i--;   //to keep track of the string
               } 
               System.out.println(new String(c));
     	}  
		
    }
