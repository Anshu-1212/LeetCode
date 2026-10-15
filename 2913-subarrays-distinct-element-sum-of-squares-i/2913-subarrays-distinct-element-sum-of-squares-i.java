class Solution {
    public int sumCounts(List<Integer> nums) {
        int n=nums.size(),sans=0;
        Set<Integer>set;
        for(int i=0;i<n;i++){
            set=new HashSet<>();
            for(int j=i;j<n;j++){
                set.add(nums.get(j));
                int a=set.size();
                sans+=(a*a);
            }
        }
        return sans;
    }
}