//Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
//Follow-up: Could you solve the problem in linear time and in O(1) space?

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        if(n == 1) {
            res.add(nums[0]);
            return res;
        }
        
//         Map<Integer,Integer> aux = new HashMap<>();
//         for(int i=0;i<n;i++)
//             aux.put(nums[i],aux.getOrDefault(nums[i],0)+1);
        
//         for(Map.Entry<Integer,Integer> entry : aux.entrySet())
//             if(entry.getValue() > n/3)
//                 res.add(entry.getKey());
        
        int first = Integer.MAX_VALUE,second = Integer.MAX_VALUE;
        int count1 = 0,count2=0;
        
        for(int i=0;i<n;i++) {
            if(nums[i] == first)
                count1++;
            else if(nums[i] == second)
                count2++;
            else if(count1 == 0) {
                first = nums[i];
                count1 = 1;
            }
            else if(count2 == 0) {
                second = nums[i];
                count2 = 1;
            }
            else {
                count1--;
                count2--;
            }
        }
        
        count1 = 0;
        count2 = 0;
        for(int i=0;i<n;i++) {
            if(nums[i] == first)
                count1++;
            else if(nums[i] == second)
                count2++;
        }
        if(count1 > n/3)
            res.add(first);
        if(count2 > n/3)
            res.add(second);
        return res;
    }
}
