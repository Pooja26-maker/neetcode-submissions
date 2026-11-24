class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n == 1){
            return nums[0];
        }
        int case1=rangeSum(nums,0,n-2);
        int case2=rangeSum(nums,1,n-1);
        return Math.max(case1,case2);
        
        
    }
    private int rangeSum(int[]nums,int start,int end){
        if(start == end)  {
            return nums[start];
        }
        int n=end-start+1;
        int[] dp=new int[n];
        dp[0]=nums[start];
        dp[1]=Math.max(nums[start],nums[start+1]);
        for(int i=2;i<n;i++){
            int currentSum=nums[start+i];
            int rob=currentSum+dp[i-2];
            int skip=dp[i-1];
            dp[i]=Math.max(rob,skip);
        }
        return dp[n-1];

    }
}
