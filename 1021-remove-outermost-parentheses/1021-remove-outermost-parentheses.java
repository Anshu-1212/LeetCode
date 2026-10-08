class Solution {
    public String removeOuterParentheses(String s) {
        int n=s.length(),bal=0,k=0;
        // Stack<Character>st=new Stack<>();
        StringBuilder sb=new StringBuilder("");
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(k==0){
                k++;
                continue;
            } 
            if(ch=='(') bal++;
            else bal--;
            k++;
            if(bal>=0){
                sb.append(ch);
            }
            else{
                bal=0;
                k=0;
            } 
        }
        return sb.toString();
    }
}