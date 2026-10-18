class Solution {
    public boolean arrayStringsAreEqual(String[] w1, String[] w2) {
        StringBuilder s=new StringBuilder("");
        StringBuilder a=new StringBuilder("");
        for(var x:w1){
            s.append(x);
        }
        for(var x:w2){
            a.append(x);
        }
        return a.toString().equals(s.toString());
    }
}