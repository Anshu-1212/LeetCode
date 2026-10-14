class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(sum>9*num) return "";
        int c=9;
        StringBuilder sb=new StringBuilder("");
        while(num>0){
            if(sum-c>=0){
                sb.append(c);
                sum-=c;
                num--;
            }
            else c--;
        }
        return sb.toString();
    }
}