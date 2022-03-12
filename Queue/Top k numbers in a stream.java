/*
Given N numbers in an array. Your task is to keep at-most K numbers at the top (According to their frequency).  We basically need to print top k numbers when
input stream has included k distinct elements, else need to print all distinct elements sorted by frequency.

Example 1:

Input:
N=5, K=4
arr[] = {5, 2, 1, 3, 2} 
Output: 5 2 5 1 2 5 1 2 3 5 2 1 3 5 
Explanation:
Firstly their was 5 whose frequency
is max till now. so print 5.
Then 2 , which is smaller than 5 but
their frequency is same so print 2 5.
Then 1, which is smallet among all the
number arrived, so print 1 2 5.
Then 3 , so print 1 2 3 5
Then again 2, which has the highest
frequency among all number so 2 1 3 5.
Example 2:

Input:
N=5, K=4
arr[] = {5, 2, 1, 3, 4} 
Output: 5 2 5 1 2 5 1 2 3 5 1 2 3 4 
Explanation:
Firstly their was 5 whose frequency is
max till now. so print 5.
Then 2 , which is smaller than 5 but
their frequency is same so print 2 5.
Then 1, Which is smallest among all the
number arrived, so print 1 2 5.
Then 3 , so print 1 2 3 5.
Then 4, so 1 2 3 4 as K is 4 so print
at-most k elements.
 

Your Task:
Since, this is a function problem. You don't need to take any input, as it is already accomplished by the driver code. You just need to complete the function
kTop() that takes array a, integer n and integer k as parameters and returns the array that contains our desired output.
*/

//Using HashMap and sorting
//T(n) = O(n^2*logn + nk) = O(n^2logn)
class Solution
{ 
    static ArrayList<Integer> kTop(int[] a, int n, int k) { 
        //code here.
        Map<Integer,Integer> freq = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int i=0;i<n;i++) {
            freq.put(a[i],freq.getOrDefault(a[i],0)+1);
            List<Integer> tmp = new ArrayList<>(freq.keySet());
            Collections.sort(tmp, (p,q)->{
                if(freq.get(q) == freq.get(p))
                    return p-q;
                return freq.get(q)-freq.get(p);
            });
            for(int j=0;j<k && j<tmp.size();j++)
                res.add(tmp.get(j));
        }
        return res;
    }
}

//Using HashMap and heap
//T(n) = O(n^2logk)
class Solution
{ 
    static ArrayList<Integer> kTop(int[] a, int n, int k) { 
        //code here.
        Map<Integer,Integer> freq = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Integer> aux = new PriorityQueue<>(1,(p,q)->{
            if(freq.get(q) == freq.get(p))
                return q-p;
            return freq.get(p)-freq.get(q);
        });
        
        for(int i=0;i<n;i++) {
            freq.put(a[i],freq.getOrDefault(a[i],0)+1);
            for(int key : freq.keySet()) {
                aux.add(key);
                if(aux.size() > k)
                    aux.poll();
            }
            List<Integer> tmp = new ArrayList<>();
            while(!aux.isEmpty())
                tmp.add(aux.poll());
            Collections.reverse(tmp);
            res.addAll(tmp);
        }
        return res;
    }
}
