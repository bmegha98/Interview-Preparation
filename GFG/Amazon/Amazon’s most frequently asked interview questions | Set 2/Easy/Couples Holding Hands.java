/*
There are n couples sitting in 2n seats arranged in a row and want to hold hands.
The people and seats are represented by an integer array row where row[i] is the ID of the person sitting in the ith seat. The couples are numbered in order, the
first couple being (0, 1), the second couple being (2, 3), and so on with the last couple being (2n - 2, 2n - 1).
Return the minimum number of swaps so that every couple is sitting side by side. A swap consists of choosing any two people, then they stand up and switch seats.

 

Example 1:

Input: row = [0,2,1,3]
Output: 1
Explanation: We only need to swap the second (row[1]) and third (row[2]) person.
Example 2:

Input: row = [3,2,0,1]
Output: 0
Explanation: All couples are already seated side by side.
 

Constraints:

2n == row.length
2 <= n <= 30
n is even.
0 <= row[i] < 2n
All the elements of row are unique.
*/

class Solution {
    public int minSwapsCouples(int[] row) {
        int numOfPeople = row.length;
        
        int[] index = new int[numOfPeople];
        for(int i=0;i<numOfPeople;i++)
            index[row[i]] = i;
        
        
            
        int swaps = 0;
        for(int i=0;i<numOfPeople;i+=2) {
            int partner = row[i]%2 == 0?row[i]+1:row[i]-1;
            if(row[i+1] == partner)
                continue;
            int ind = index[partner];
            index[row[i+1]] = ind;
            index[partner] = i+1;
            swap(row,i+1,ind);
            // for(int ele : row)
            //     System.out.print(ele +" ");
            // System.out.println();
            
            swaps++;
        }
        return swaps;
    }
    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
