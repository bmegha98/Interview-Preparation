/*
Given an array arr[] of integers of size N that might contain duplicates, the task is to find all possible unique subsets.

Note: Each subset should be sorted.

Example 1:

Input: N = 3, arr[] = {2,1,2}
Output:(),(1),(1 2),(1 2 2),(2),(2 2)
Explanation: 
All possible subsets = (),(2),(1),(1,2),(2),(2,2),(2,1),(2,1,2)
After Sorting each subset = (),(2),(1),(1,2),(2),(2,2),(1,2),(1,2,2) 
Unique Susbsets in Lexicographical order = (),(1),(1,2),(1,2,2),(2),(2,2)
Example 2:

Input: N = 4, arr[] = {1,2,3,3}
Output: (),(1),(1 2),(1 2 3) ,(1 2 3 3),(1 3),(1 3 3),(2),(2 3),(2 3 3),(3),(3 3)
*/

//Using Bit Masking , T(n) = O(n* 2^n), Space = O(x*2^n)
class solve
{
    //Function to find all possible unique subsets.
    public static ArrayList <ArrayList <Integer>> AllSubsets(int arr[], int n)
    {
        ArrayList <ArrayList <Integer>> res = new ArrayList<>();
        Set<ArrayList<Integer>> aux = new HashSet<>();
        Arrays.sort(arr);
        
        for(int i=1;i<(1<<n);i++) {
            int count = 0;
            ArrayList<Integer> tmp = new ArrayList<>();
            int mask = i;
            
            while(mask > 0) {
                if((mask&1) != 0) 
                    tmp.add(arr[count]);
                count++;
                mask >>= 1;
            }
            if(!aux.contains(tmp)) {
                res.add(tmp);
                aux.add(tmp);
            }
        }
        
        Collections.sort(res, (o1,o2)->{
            int min = Math.min(o1.size(),o2.size());
            for(int i=0;i<min;i++)
                if(o1.get(i)!=o2.get(i))
                    return o1.get(i)-o2.get(i);
            return (o1.size()<=o2.size())? -1:1;  
            
        });
        return res;
    }
}

//Using Backtracking, T(n) = O(2^n) , Space = O(n)
class solve
{
    //Function to find all possible unique subsets.
    static ArrayList <ArrayList <Integer>> res;
    public static ArrayList <ArrayList <Integer>> AllSubsets(int arr[], int n)
    {
        res = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        Arrays.sort(arr);
        
        helper(arr,0,n,tmp);
        res.remove(0);
        return res;
    }
    
    private static void helper(int[] A,int start,int n, ArrayList<Integer> tmp) {
        res.add(new ArrayList<>(tmp));
        for(int i=start;i<n;i++) {
            if(i > start && A[i] == A[i-1])
                continue;
            tmp.add(A[i]);
            helper(A,i+1,n,tmp);
            tmp.remove(tmp.size()-1);
        }
    }
}
