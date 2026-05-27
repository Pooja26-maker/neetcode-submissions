class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int count=1;
        Arrays.sort(nums);
        int n=nums.length;
        List <Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(i > 0 && nums[i]==nums[i-1]){
                count++;
            }
            else{
                count=1;
            }
            if(count > n/3){
                if(ans.size()==0 || ans.get(ans.size()-1)!=nums[i]){
                    ans.add(nums[i]);
                }

            }
        }
        return ans;

        
    }
}