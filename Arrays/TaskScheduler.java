Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks. Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.

However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are 
doing different tasks or just be idle.

You need to return the least number of intervals the CPU will take to finish all the given tasks.

 

Example:

Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.

Intuition:

We have 2 cases

when the sum of number of idle slots and number of characters is greater than length of the array
example : AAABBB k=2
we have
AB_AB_AB as the arrangement.

When the sum of number of idle slots and number of characters is equal to the length of the array, (that is no idle slot)
Example AAABBBCC k =2
ABCABCAB

If we compare both the cases we can see that in example 2 the C's occupied the idle slots in example 1. Hence we can conclude that the
answer is either the length of that input array or length of input array + idle slots

Let's understand this with one more example :

AAAABBBBCCDD  K = 2

AB_AB_AB_AB is what we get after arranging A,B
 now total number of characters of C and D is 4 which is greater than 3(number of idle slots)
  hence our answer is length of the array. Below is one of the possible final arrangement
  
  ABCABDABCABD  == length of the input array.

So all we need to do is calculate the number of idle slots formed by the characters which occur the maximum number of time. Then we can
return the answer as max of either the length of that input array or length of input array + idle slots

class Solution {
public int leastInterval(char[] tasks, int n) {
HashMap<Character,Integer> map = new HashMap();
int length = tasks.length;
for(int i=0; i<length; i++)
map.put(tasks[i],map.getOrDefault(tasks[i],0)+1 );

     Comparator<Character> comp = new Comparator<Character>(){
       public int compare(Character a, Character b){
           return map.get(b) - map.get(a);
       }  
    };
    
    PriorityQueue<Character> heap = new PriorityQueue(26,comp);
      for(char c: map.keySet())  // create max heap
        heap.offer(c);   
    int max = map.get(heap.poll());
	
     int count =(max-1)*n; // find idle slots

    while(!heap.isEmpty() && max == map.get(heap.poll()) )
           count++;  
  
     return Math.max(max+count,length);
}
}
