//Given an array of integers and another number. Find all the unique quadruple from the given array that sums up to the given number.

class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int n = arr.length;
        if(n < 4)
            return res;
        Arrays.sort(arr);
        for(int i=0;i<n-3;i++) {
            if(i>0 && arr[i] == arr[i-1])
                continue;
            int a = arr[i];
            for(int j= i+1;j<n-2;j++) {
                if(j >i+1 && arr[j]==arr[j-1])
                    continue;
                int b = arr[j];
                int l = j+1,r = n-1;
                while(l < r) {
                    int c = arr[l],d = arr[r];
                    int s = a+b+c+d;
                    if(s < k)
                        l++;
                    else if(s > k)
                        r--;
                    else {
                        ArrayList<Integer> tmp = new ArrayList<Integer>(){{
                            add(a);
                            add(b);
                            add(c);
                            add(d);
                        }};
                        res.add(tmp);
                        while(l<r && arr[l] == c)
                            l++;
                        while(l<r && arr[r] == d)
                            r--;
                    }
                }
            }
        }
        return res;
    }
}
