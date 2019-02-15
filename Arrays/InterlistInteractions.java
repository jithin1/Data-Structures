/*
Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.

Return the intersection of these two interval lists.

(Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.  The intersection of two closed
intervals is a set of real numbers that is either empty, or can be represented as a closed interval.  For example, the intersection of
[1, 3] and [2, 4] is [2, 3].)

Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
Reminder: The inputs and the desired output are lists of Interval objects, and not arrays or lists.
 
*/
class Solution {
    public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
        List<Interval>intervals = new ArrayList();
        
        int ptr1 = 0;
        int ptr2 = 0;
        
        while(ptr1 < A.length && ptr2 < B.length){
            if(B[ptr2].start <= A[ptr1].end && A[ptr1].start <= B[ptr2].end){   // check for intersection
                
  intervals.add(new Interval(Math.max(A[ptr1].start,B[ptr2].start),Math.min(A[ptr1].end,B[ptr2].end)));  // add the overlap

                
                if(A[ptr1].end < B[ptr2].end)  /
                ptr1++;
                else if(A[ptr1].end > B[ptr2].end)
                    ptr2++;
                else{
                    if(A[ptr1].start < B[ptr2].start)
                        ptr1++;
                    else 
                        ptr2++;
                }
            }
            
            else if(A[ptr1].end < B[ptr2].start)  // non overlapping 
                ptr1++;
             else
                    ptr2++;
                
        }
        
        Interval[] result = new Interval[intervals.size()];
        for(int i=0; i< intervals.size(); i++)
            result[i] = intervals.get(i);
        
        return result;
    }
}
