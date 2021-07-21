/*
You are given an n x n 2D matrix representing an image.Rotate the image by 90 degrees (clockwise).You need to do this in place.
Note that if you end up using an additional array, you will only receive partial score.

Example:
If the array is

[
    [1, 2],
    [3, 4]
]
Then the rotated array becomes:

[
    [3, 1],
    [4, 2]
]

Transpose the matrix and reverse each row in it.
*/

public class Solution {
    public void rotate(ArrayList<ArrayList<Integer>> a) {
        int n = a.size();
        if(n == 1)
            return;
        for(int i=0;i<n;i++) 
            for(int j=i;j<n;j++)
                swap(a,i,j);
        for(int i=0;i<n;i++)
            reverse(a.get(i));
    }
    private void swap(ArrayList<ArrayList<Integer>> a,int i,int j) {
        int tmp= a.get(i).get(j);
        a.get(i).set(j,a.get(j).get(i));
        a.get(j).set(i,tmp);
    }
    private void reverse(ArrayList<Integer> A) {
        int l=0,h = A.size()-1;
        while(l<h){
            int tmp = A.get(l);
            A.set(l,A.get(h));
            A.set(h, tmp);
            l++;
            h--;
        }
    }
}
