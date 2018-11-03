/*
LeetCode :  19 Remove Nth Node From End of List
Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.

Note:

Given n will always be valid.

Follow up:

Could you do this in one pass?

*/



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prev= null;
        ListNode cur = null;
        ListNode fast = head;
        int count = 1;
        while(fast != null){
            
            if(count < n){   // move n positions
                count ++;
                fast = fast.next;
                continue;
            }
            
            // when the faster poin ter reaches the end, the slower pointer behind the faster pointer by n nodes, and
             // we reach n nodes from the end of the list
            
              if(cur == null){
                  cur = head;  
              }
            
             else{
                     prev = cur;
                  cur = cur.next;
             }
            
            fast = fast.next;
        
            
        }
           if(prev != null)   // change the nodes when previous exists
        prev.next = cur.next;
        
        // when prev is null that means we are removing the first element in the list
        
          else if(prev == null && cur.next!=null){  // we removed the first node, so we need to increment head
              head = head.next;
              return head;
          }
        
           else         // we have only one node so we return null
               return null;
        
        return head;
    }
}


// Time complexity is O(n)
