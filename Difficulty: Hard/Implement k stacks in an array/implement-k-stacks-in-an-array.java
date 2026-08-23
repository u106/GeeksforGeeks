class kStacks {

    // main array to store elements
    private int[] data;
    private int[] next;
    private int[] top;
    private int free ;


    public kStacks(int n, int k) {
        // initialize data structures for k stacks
        data = new int[n] ;

        next = new int[n] ;
        // i-th cell is empty : next[i] tell next empty cell
        // i-th cell is filled : next[i] tells prev filled cell
        for( int i = 0 ; i < n-1 ; i++ )
            next[i] = i+1 ;
        next[n-1] = -1 ;

        top = new int[k] ;
        for( int i = 0 ; i < k ; i++ )
            top[i] = -1 ;

        free = 0 ;

    }

    public void push(int x, int st_id) {
        // push element x into stack i
        int i = free ;

        free = next[i] ;

        next[i] = top[st_id] ;

        top[st_id] = i ;

        data[i] = x ;

    }

    public int pop(int st_id) {
        // If stack is empty return -1 
        if( top[st_id] == -1 )
            return -1 ;

        // pop element from stack i

        int i = top[st_id] ;

        top[st_id] = next[i] ;

        next[i] = free ; 

        free = i ;

        return data[i] ; 

    }
}