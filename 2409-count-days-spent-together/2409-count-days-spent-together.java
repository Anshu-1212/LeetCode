class Solution {
    int[] days={0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int aa=convert(arriveAlice);
        int la=convert(leaveAlice);
        int ab=convert(arriveBob);
        int lb=convert(leaveBob);
        if(la<ab || lb<aa) return 0;
        if(aa<=ab && la>=lb) return lb-ab+1;
        if(aa>=ab && la<=lb) return la-aa+1;
        if(aa<=ab) return la-ab+1;
        if(ab<=aa) return lb-aa+1;
        return 0;
    }
    public int convert(String date){
        int day=10*(date.charAt(3)-'0')+(date.charAt(4)-'0');
        int mon=10*(date.charAt(0)-'0')+(date.charAt(1)-'0');
        int ans=day;
        for(int i=0;i<mon;i++) ans+=days[i];
        return ans;
    }
}