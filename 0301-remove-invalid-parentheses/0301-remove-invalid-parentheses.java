// class Solution {
//     public List<String> removeInvalidParentheses(String s) {
//         int n=s.length(),i=0,c=0;
//         Stack<Character>st=new Stack<>();
//         while(i<n){
//             char ch=s.charAt(i);
//             if(ch!='(' && ch!=')'){
//                 i++;
//                 continue;
//             }
//             if(st.isEmpty()) st.push(ch);
//             else if(ch=='('){
//                 st.push(ch);
//             }
//             else if (st.peek()=='(') st.pop();
//             else st.push(ch);
//             i++;
//         }
//         c=st.size();
//         Set<String>set=new HashSet<>();
//         helper(s,0,c,"",set);
//         return new ArrayList<>(set);
//     }
    
//     public void helper(String s,int i,int c,String temp,Set<String>set){
//         if(c<0) return;
//         if(i==s.length()){
//             if(c==0 && valid(temp)){
//                 set.add(temp);
//             }
//             return;
//         }
//         char ch=s.charAt(i);
//         if(ch=='(' || ch==')'){
//             helper(s,i+1,c-1,temp,set);
//             helper(s,i+1,c,temp+ch,set);
//         }
//         else helper(s,i+1,c,temp+ch,set);
        
//     }

//     public boolean valid(String s){
//         int n=s.length(),i=0;
//         Stack<Character>st=new Stack<>();
//         while(i<n){
//             char ch=s.charAt(i);
//             if(ch!='(' && ch!=')'){
//                 i++;
//                 continue;
//             }
//             if(st.isEmpty()) st.push(ch);
//             else if(ch=='('){
//                 st.push(ch);
//             }
//             else if (st.peek()=='(') st.pop();
//             else st.push(ch);
//             i++;
//         }
//         return st.isEmpty();
//     }
// }
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int n=s.length(),i=0,c=0;
        Stack<Character>st=new Stack<>();
        while(i<n){
            char ch=s.charAt(i);
            if(ch!='(' && ch!=')'){
                i++;
                continue;
            }
            if(st.isEmpty()) st.push(ch);
            else if(ch=='('){
                st.push(ch);
            }
            else if (st.peek()=='(') st.pop();
            else st.push(ch);
            i++;
        }
        c=st.size();
        Set<String>set=new HashSet<>();
        helper(new StringBuilder(s),0,c,"",set);
        return new ArrayList<>(set);
    }
    
    public void helper(StringBuilder s,int i,int c,String temp,Set<String>set){
        if(c<0) return;
        if(i==s.length()){
            if(c==0 && valid(temp)) set.add(temp);
            return;
        }
        char ch=s.charAt(i);
        if(ch!='(' && ch!=')') helper(s,i+1,c,temp+ch,set);
        else{
            helper(s,i+1,c-1,temp,set);
            helper(s,i+1,c,temp+ch,set);
        }
    }

    public boolean valid(String s){
        int n=s.length();
        int bal=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='(') bal++;
            else if(ch==')') bal--;
            if(bal<0) return false;
        }
        return bal==0;
    }
}