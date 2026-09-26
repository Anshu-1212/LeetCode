class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String,String>map=new HashMap<>();
        for(var l:knowledge){
            map.put(l.get(0),l.get(1));
        }
        List<Integer>l=new ArrayList<>();
        int n=s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='(' || s.charAt(i)==')') l.add(i);
        }
        int m=l.size(),x,y,z,i;
        if(m==0) return s;
        String sans=s.substring(0,l.get(0));
        for(i=0;i+2<m;i+=2){
            x=l.get(i);y=l.get(i+1);z=l.get(i+2);
            sans=sans+map.getOrDefault(s.substring(x+1,y),"?")+s.substring(y+1,z);
        }
        x=l.get(i);y=l.get(i+1);
        sans=sans+map.getOrDefault(s.substring(x+1,y),"?")+s.substring(y+1);
        return sans;
    }
}