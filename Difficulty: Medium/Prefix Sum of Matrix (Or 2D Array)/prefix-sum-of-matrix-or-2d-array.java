class Solution{
    ArrayList<Long> submatrixSum(long[][] a, int n, int m, int[][] query, int q){ 
        ArrayList<Long> res=new ArrayList<>();
        for(int k=0;k<query.length;k++){
            int x1=query[k][0];
            int y1=query[k][1];
            int x2=query[k][2];
            int y2=query[k][3];
            long sum=0;
            for(int i=x1;i<=x2;i++){
                for(int j=y1;j<=y2;j++){
                    sum+=a[i][j];
                }
            }
            res.add(sum);
        }
        return res;                 
    }
}