/*
You are given an array A of size N, and you are also given a sum. You need to find if two numbers in A exists that have sum equal to the given sum.
*/

class Geeks
{
    // function to check if any pair having specified sum
    // and return 1 if so, else 0
    public static int sumExists(int arr[], int n, int sum)
    {
        // your code here
        Arrays.sort(arr);
        int l =0,h = n-1;
        while(l < h)
        {
            int s = arr[l]+arr[h];
            if(s == sum)
                return 1;
            if(s < sum)
                l++;
            else
                h--;
        }
        return 0;
    }
    
}
