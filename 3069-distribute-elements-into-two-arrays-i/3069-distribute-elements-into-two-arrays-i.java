class Solution {
    public int[] resultArray(int[] nums) {
        int n=nums.length;
        List<Integer>l1=new ArrayList<>();
        List<Integer>l2=new ArrayList<>();
        l1.add(nums[0]);
        l2.add(nums[1]);
        int a=nums[0];
        int b=nums[1];
        for(int i=2;i<n;i++){
            if(a>b){
                l1.add(nums[i]);
                a=nums[i];
            }
            else{
                l2.add(nums[i]);
                b=nums[i];
            }
        }
        int k=0;
        int x=l1.size(),y=l2.size();
        for(int i=0;i<x;i++) nums[k++]=l1.get(i);
        for(int i=0;i<y;i++) nums[k++]=l2.get(i);
        return nums;
    }
}