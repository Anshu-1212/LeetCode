class Solution {
    public String reverseParentheses(String s) {
        Stack<Character>st=new Stack<>();
        Queue<Character>q=new ArrayDeque<>();
        int n=s.length();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch!=')'){
                st.push(ch);
            }
            // else if(ch==')'){
            else{
                while(st.peek()!='('){
                    q.add(st.pop());
                }
                st.pop();
                while(!q.isEmpty()){
                    st.push(q.remove());
                }
            }
        }
        String sans="";
        while(!st.isEmpty()) sans=st.pop()+sans;
        return sans;
    }
}