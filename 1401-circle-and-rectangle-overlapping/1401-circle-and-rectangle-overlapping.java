class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int xclose=-1,yclose=-1;
        if(x1>xCenter) xclose=x1;
        else if(x2<xCenter) xclose=x2;
        else xclose=xCenter;
        if(y1>yCenter) yclose=y1;
        else if(y2<yCenter) yclose=y2;
        else yclose=yCenter;
        int dx=xclose-xCenter;
        int dy=yclose-yCenter;
        if(dx*dx+dy*dy<=radius*radius) return true;
        return false;
    }
}