class Solution {
    public static int minCost(int[] arr) {
        // code here
        // 1. Insert all elements in PQ
        int n = arr.length ;
        PriorityQueue<Integer> pq = 
            new PriorityQueue<>() ;
        
        for( int i = 0 ; i < n ; i++ ){
            pq.add( arr[i] ) ;
        }
        
        // 2. Get two smallest element from pq 
        int ans = 0 ;
        while( pq.size() > 1 ){
            int ele1 = pq.remove() ;
            int ele2 = pq.remove() ;
            
            int length = ele1 + ele2 ;
            
            ans += length ;
            
            pq.add( length ) ;

        }
        return ans ;
        
    }
}