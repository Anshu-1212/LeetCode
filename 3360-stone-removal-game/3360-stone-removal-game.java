class Solution {
    public boolean canAliceWin(int n) {
        int ch=10;
        boolean t=true;
        while(n-ch>=0){
            n-=ch;
            t=!t;
            ch--;
        }
        return !t;
    }
}