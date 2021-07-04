/*
Given a non-empty array of integers, find the top k elements which have the highest frequency in the array. If two numbers have the same frequency then the larger 
number should be given preference. 

Example 1:

Input:
nums = {1,1,1,2,2,3},
k = 2
Output: {1, 2}
Example 2:

Input:
nums = {1,1,2,2,3,3,3,4},
k = 2
Output: {3, 2}
Explanation: Elements 1 and 2 have the same frequency ie. 2. Therefore, in this case, the answer includes the element 2 as 2 > 1.
*/

class Solution {
    public int[] topK(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer,Integer> freq = new HashMap<>();
        for(int ele : nums)
            freq.put(ele,freq.getOrDefault(ele,0)+1);
        
        Queue<Integer> aux = new PriorityQueue<>(1,(a,b)->{
            if(freq.get(a) == freq.get(b))
                return a-b;
            return freq.get(a)-freq.get(b);
        });
        
        for(Map.Entry<Integer,Integer> entry : freq.entrySet()) {
            aux.add(entry.getKey());
            if(aux.size() > k)
                aux.poll();
        }
        
        int i = k-1;
        while(!aux.isEmpty())
            res[i--] = aux.poll();
        return res;
    }
}
