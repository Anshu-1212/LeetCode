class Solution {
    public int totalNumbers(int[] digits) {
        int n=digits.length;
        Set<Integer>set=new HashSet<>();
        first:for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    // if(digits[i]==0) continue first;
                    int num=digits[i]*100+digits[j]*10+digits[k];
                    if(num<100 || num%2!=0 || i==j || j==k || k==i) continue;
                    set.add(num);
                }
            }
        }
        return set.size();
    }
}