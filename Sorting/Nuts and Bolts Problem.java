/*
Given a set of N nuts of different sizes and N bolts of different sizes. There is a one-one mapping between nuts and bolts. Match nuts and bolts efficiently.
Comparison of a nut to another nut or a bolt to another bolt is not allowed. It means nut can only be compared with bolt and bolt can only be compared with nut to
see which one is bigger/smaller.
The elements should follow the following order ! # $ % & * @ ^ ~ .
*/

//Using Quick Sort, T(n) = O(nlogn)
class Solution {
    private void quickSort(char[] nuts,char[] bolts, int l, int h) {
        if(l >= h)
            return;
        int pivot = Partition(nuts, l, h, bolts[h]);
        Partition(bolts,l,h,nuts[pivot]);
        quickSort(nuts,bolts,l,pivot-1);
        quickSort(nuts,bolts,pivot+1,h);
    }
    private int Partition(char A[], int l,int h,int pivot) {
        int i=l;
        for(int j=l;j<h;j++) {
            if(A[j] < pivot)
            {
                swap(A,i,j);
                i++;
            }
            else if(A[j]==pivot) {
                swap(A,j,h);
                j--;
            }
        }
        swap(A,i,h);
        return i;
    }
    private void swap(char[] A,int i,int j) {
        char temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    void matchPairs(char nuts[], char bolts[], int n) {
        if(n == 1)
            return;
        quickSort(nuts, bolts, 0, n-1);
    }
}

//Using HashMap
void matchPairs(char nuts[], char bolts[], int n) {
        if(n == 1)
            return;
        //quickSort(nuts, bolts, 0, n-1);
        Map<Character,Integer> aux = new LinkedHashMap<Character,Integer>(){{
            put('!',0);
            put('#',0);
            put('$',0);
            put('%',0);
            put('&',0);
            put('*',0);
            put('@',0);
            put('^',0);
            put('~',0);
        }};
        
        for(char nut : nuts)
            aux.put(nut,aux.get(nut)+1);
            
        int i=0;
        
        for(Map.Entry<Character,Integer> entry : aux.entrySet()) {
            if(entry.getValue()>0)
            {
                nuts[i] = entry.getKey();
                bolts[i] = entry.getKey();
                i++;
            }
        }
        
    }
