class Solution {
    public String[] createGrid(int n, int m) {
        char[][]arr=new char[n][m];
        for(var a:arr){
            Arrays.fill(a,'#');
        }
        for(int i=0;i<n;i++){
            arr[i][m-1]='.';
        }
        for(int i=0;i<m;i++){
            arr[0][i]='.';
        }
        String[]ans=new String[n];
        for(int i=0;i<n;i++){
            String temp="";
            for(int j=0;j<m;j++){
                temp+=arr[i][j];
            }
            ans[i]=temp;
        }
        return ans;
    }
}