class Solution {
    public List<List<String>> findMismatchedSegments(String s1, String s2) {
        List<List<String>>sans=new ArrayList<>();
        int n=s1.length();
        String a="",b="";
        for(int i=0;i<n;i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                a+=s1.charAt(i);
                b+=s2.charAt(i);
            }
            else if(s1.charAt(i)==s2.charAt(i) && a!="" && b!=""){
                List<String>l=new ArrayList<>();
                l.add(a);
                l.add(b);
                sans.add(l);
                a="";
                b="";
            }
        }
        if(a!="" && b!=""){
            List<String>l=new ArrayList<>();
            l.add(a);
            l.add(b);
            sans.add(l);
        }
        return sans;
    }
}