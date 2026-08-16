class Solution {
    Set<String>set=new HashSet<>();
    public List<String> generateParenthesis(int n) {
        helper(n-1,"()");
        return new ArrayList<>(set);
    }
    public void helper(int n,String s){
        if(n==0){
            set.add(s);
            return;
        }
        int len=s.length();
        for(int i=0;i<len;i++){
            helper(n-1,s.substring(0,i)+"()"+s.substring(i));
        }
    }
}