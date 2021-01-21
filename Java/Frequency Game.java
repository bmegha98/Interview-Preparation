/*
Given an array A of size N. The elements of the array consists of positive integers. You have to find the largest element with minimum frequency.
*/
class Geeks
{
    // Function to find largest number with minimum frequency
    public static int LargButMinFreq(int arr[], int n)
    {
        // Your code here
        /*
        TreeMap<Integer,Integer> m = new TreeMap<>(Collections.reverseOrder());
        
        for(int i=0;i<n;i++)
        {
            if(m.containsKey(arr[i]))
                m.put(arr[i],m.get(arr[i])+1);
            else
                m.put(arr[i],1);
        }
        
        int maxFreq = Integer.MAX_VALUE,res = -1;
        for(int k : m.keySet())
        {
            if(m.get(k) < maxFreq)
            {
                res = k;
                maxFreq = m.get(k);
            }
        }
        return res;
        */
        Arrays.sort(arr);
        
        int i =n-1;
        while(i > 0)
        {
            //System.out.println(arr[i]);
            if(arr[i] == arr[i-1])
            {
                while(i>0 && arr[i] == arr[i-1])
                    i--;
            }
            else
            {
                return arr[i];
            }
            i--;
        }
        return -1;
    }
}
