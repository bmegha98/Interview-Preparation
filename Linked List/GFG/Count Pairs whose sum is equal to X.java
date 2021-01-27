/*
Given two linked list of size N1 and N2 respectively of distinct elements, your task is to complete the function countPairs(), which returns the count of all pairs 
from both lists whose sum is equal to the given value X.
Note: The 2 numbers of a pair should be parts of different lists.
*/

class GfG {

    public static int countPairs(LinkedList<Integer> head1, LinkedList<Integer> head2,
                          int sum) {
        //add your code here
        Set<Integer> s = new HashSet<Integer>();
        for(Integer ele : head1)
            s.add(ele);
        int c = 0;
        for(Integer x : head2)
        {
            int rem = sum-x;
            if(s.contains(rem))
                c++;
        }
        return c;
    }
}
