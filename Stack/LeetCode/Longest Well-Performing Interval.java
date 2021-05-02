/*
We are given hours, a list of the number of hours worked per day for a given employee.

A day is considered to be a tiring day if and only if the number of hours worked is (strictly) greater than 8.

A well-performing interval is an interval of days for which the number of tiring days is strictly larger than the number of non-tiring days.

Return the length of the longest well-performing interval.
*/

class Solution {
    public int longestWPI(int[] hours) {
        int n = hours.length;
        if(n == 1)
        {
            if(hours[0] > 8)
                return 1;
            return 0;
        }
        // int ans = 0;
        // for(int i=0;i<n;i++) {
        //     for(int j = n-1;j>=i;j--) {
        //         int sum = 0;
        //         for(int k = i;k<=j;k++)
        //             sum += hours[k] > 8?1:-1;
        //         if(sum > 0 && ans < j-i+1)
        //             ans = j-i+1;
        //     }
        // }
        // return ans;
        
        int maxLen = 0, currSum = 0;
        Map<Integer, Integer> aux = new HashMap<>();
        for(int i = 0;i<n;i++) {
            currSum += hours[i]>8?1:-1;
            if(!aux.containsKey(currSum))
                aux.put(currSum, i);
            if(currSum > 0)
                maxLen = i+1;
            else if(aux.containsKey(currSum-1))
                maxLen = Math.max(maxLen, i-aux.get(currSum-1));
        }
        return maxLen;
    }
}
