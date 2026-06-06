class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int count=0;
        int prefix_sum=0;
        map.put(0,1);

        for(int num:nums){
            prefix_sum+=num;
            int current=prefix_sum-k;
            if(map.containsKey(current)){
                count+=map.get(current);
            }
            map.put(prefix_sum,map.getOrDefault(prefix_sum,0)+1);
        }
        return count;

    }
}