/*
Given a read only array of n + 1 integers between 1 and n, find one number that repeats in linear time using less than O(n) space and traversing the stream 
sequentially O(1) times.
Sample Input:

[3 4 1 4 1]
Sample Output:

1
If there are multiple possible answers ( like in the sample case above ), output any one.
If there is no duplicate, output -1
*/

//Using Set
public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int repeatedNumber(final List<Integer> A) {
        int n = A.size();
        if(n == 1)
            return -1;
        Set<Integer> aux = new HashSet<>();
        for(int ele : A) {
            if(aux.contains(ele))
                return ele;
            aux.add(ele);
        }
        return -1;
    }
}

//Using Floyd Cycle detecion algo
public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int repeatedNumber(final List<Integer> A) {
        int n = A.size();
        if(n == 1)
            return -1;
        int slow = A.get(0), fast = A.get(0);
        boolean isCycle = false;
        while(fast<n && A.get(fast) < n) {
            slow = A.get(slow);
            fast = A.get(A.get(fast));
            if(slow == fast) {
                isCycle = true;
                break;
            }
        }
        if(!isCycle)
            return -1;
        slow = A.get(0);
        while(slow != fast) {
            slow = A.get(slow);
            fast = A.get(fast);
        }
        return slow;
    }
}
