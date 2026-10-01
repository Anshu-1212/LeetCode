class Solution {
    public boolean isValid(String s) {

        Stack<Character> st = new Stack<>();
        int n = s.length();
        if (n % 2 != 0) {
            return false;
        }
        int i = 0;
        while (i < n) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else if (ch == ')' || ch == '}' || (ch == ']')) {
                if (st.isEmpty()) {
                    return false;
                }
                char sh = st.peek();
                if (sh == '(' && (ch != ')') || (sh == '{' && ch != '}') || (sh == '[' && ch != ']')) {
                    return false;
                } else
                    st.pop();

            }
            i++;
        }
        return st.isEmpty();

    }
}