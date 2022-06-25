/*
You are given an array target of n integers. From a starting array arr consisting of n 1's, you may perform the following procedure :

let x be the sum of all elements currently in your array.
choose index i, such that 0 <= i < n and set the value of arr at index i to x.
You may repeat this procedure as many times as needed.
Return true if it is possible to construct the target array from arr, otherwise, return false.

 

Example 1:

Input: target = [9,3,5]
Output: true
Explanation: Start with arr = [1, 1, 1] 
[1, 1, 1], sum = 3 choose index 1
[1, 3, 1], sum = 5 choose index 2
[1, 3, 5], sum = 9 choose index 0
[9, 3, 5] Done
Example 2:

Input: target = [1,1,1,2]
Output: false
Explanation: Impossible to create target array from [1,1,1,1].
Example 3:

Input: target = [8,5]
Output: true
 

Constraints:

n == target.length
1 <= n <= 5 * 104
1 <= target[i] <= 109
*/

//start from target array, select largest element and sub it from remaining sum. Continue this until all elemnts become 1
class Solution {
    public boolean isPossible(int[] target) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        long totalSum =0L;
        
        for(int el:target){
            pq.add(el);
            totalSum +=el;
        }
        
        while(!pq.isEmpty()){
            int max = pq.poll();
            long remainingSum = totalSum -max;
            
            if(max==1 || remainingSum ==1)
                return true;
            
            if(remainingSum ==0 || remainingSum>max  )
                return false;
            
            int update =(int)(max%remainingSum); //repetitive subtraction
            if(update==0)  // no element can be 0
                return false;
        
            max=update;
            pq.offer(max);
            totalSum = remainingSum+update;
        }
        return true;
    }
}
