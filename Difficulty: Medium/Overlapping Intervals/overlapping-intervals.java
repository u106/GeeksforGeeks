class Solution {
    public ArrayList<ArrayList<Integer>> mergeOverlap(int[][] arr) {
        // Code here
        Arrays.sort( arr , (a,b)->Integer.compare(a[0],b[0]) ) ;
 
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>() ;
        int n = arr.length ;
 
        int curr_s = arr[0][0] ;
        int curr_e = arr[0][1] ;
 
        for( int i = 1 ; i < n ; i++ ){
            int s = arr[i][0] ;
            int e = arr[i][1] ;
 
            if( s <= curr_e ){
                curr_s = Math.min( curr_s , s ) ;
                curr_e = Math.max( curr_e , e ) ;
            }
            else{
                ans.add( new ArrayList<>(Arrays.asList(curr_s,curr_e))) ;
 
                curr_s = s ;
                curr_e = e ;
 
            }
 
        }
        ans.add( new ArrayList<>(Arrays.asList(curr_s,curr_e))) ;
 
        return ans;
    }
}