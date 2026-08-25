class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer>set=new HashSet<>();
        for(int a:nums) set.add(a);
        int b=k;
        while(k<200){
            if(!set.contains(b)) return b;
            b+=k;
        }
        return -1;
    }
}