class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return 1;
        List<Integer> tmp = new ArrayList<>();
        tmp.add(nums[0]);
        
        for(int i=1;i<n;i++) {
            if(nums[i] > tmp.get(tmp.size()-1))
                tmp.add(nums[i]);
            else {
                int ind = binarySearch(tmp,nums[i]);
                tmp.set(ind,nums[i]);
            }
        }
        return tmp.size();
    }
    
    private int binarySearch(List<Integer> A,int ele) {
        int l = 0,h = A.size()-1,ans = -1;
        while(l<=h) {
            int mid = l+(h-l)/2;
            if(A.get(mid) >= ele) {
                ans = mid;
                h = mid-1;
            }
            else
                l = mid+1;
        }
        return ans;
    }
}
