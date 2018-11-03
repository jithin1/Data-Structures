/* Binary seach to solve the problem */
// time complexity = O(nlogn)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        Arrays.sort(nums);
        int end = nums.length-1;
         int r1 = 0; int r2 = 0;
        
        for(int i=0; i<end-1; i++){
            int mid = findSum(nums,i,i+1,end,target);
            if(mid == -1)
                continue;
            else{
                r1 = i;
                r2 = mid;
                break;
               }
            }  
        int[] result = {r1,r2};
        return result;
    }
    
    public int findSum(int[] a, int p1,int str, int end, int target){
        if(str > end)
            return -1;
        
        int mid = (str+end)/2;
        
        if(a[p1]+a[mid] == target )
            return mid;
        
        else if(a[p1] + a[mid] < target)
            return findSum(a,p1,mid+1,end,target);
        
        else
            return findSum(a,p1,str,mid-1,target);
             
    }
}
