// class Solution {
//     Set<String>set=new HashSet<>();
//     public List<String> generateParenthesis(int n) {
//         helper(n-1,"()");
//         // helper(n,"");
//         return new ArrayList<>(set);
//     }
//     public void helper(int n,String s){
//         if(n==0){
//             set.add(s);
//             return;
//         }
//         int len=s.length();
//         for(int i=0;i<len;i++){
//             helper(n-1,s.substring(0,i)+"()"+s.substring(i));
//         }
//     }
// }
class Solution {
    List<String> l;
    public List<String> generateParenthesis(int n) {
        l=new ArrayList<>();
        helper(n,n,"");
        return l;
    }
    public void helper(int open,int close,String s){
        if(close<open || open<0 || close<0){
            return;
        }
        if(close==0 && open==0){
            l.add(s);
            return;
        }
        helper(open-1,close,s+'(');
        helper(open,close-1,s+')');
    }
}