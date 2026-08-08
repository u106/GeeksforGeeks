/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public int minTime(Node root, int target) {
        // code here
        // 1. Mapping (node -> parent )
        HashMap<Node,Node> map = new HashMap<>() ;
        mapping( root , map , null ) ;
    
        // 2. Search the target Node 
        Node targetNode = search( root , target ) ;
        
        // 3. Applying the BFS traversal 
        Queue<Node> q = new LinkedList<>() ;
        HashSet<Node> visited = new HashSet<>() ;
    
        q.add( targetNode ) ;
        visited.add( targetNode ) ;
        int time = 0 ;
    
        
        while( !q.isEmpty() ){
            int size = q.size() ;
            boolean burnt = false ;
            while( size-- > 0 ){
                // R - Print - (Lc, Rc, Parent)
                Node curr = q.remove() ;
                
                // Lc
                if( curr.left != null && !visited.contains(curr.left) ){
                    q.add( curr.left ) ;
                    visited.add( curr.left ) ;
                    burnt = true ;
                }
                // Rc
                if( curr.right != null && !visited.contains(curr.right ) ){
                    q.add( curr.right ) ;
                    visited.add( curr.right ) ;
                    burnt = true ;
                }
                // Parent 
                Node parent = map.get( curr ) ;
                if( parent != null && !visited.contains(parent) ){
                    q.add( parent ) ;
                    visited.add( parent ) ;
                    burnt = true ;
                }
            }
            if( burnt )
                time++ ;
        }

        return time ;
        
    }
    
    public Node search( Node root , int target ){
        if( root == null )
            return null ;
        if( root.data == target )
            return root ;
        Node ls = search( root.left , target ) ;
        if( ls != null )
            return ls ;
        return search( root.right , target ) ;
    }
    
    public void mapping(Node root , HashMap<Node,Node> map , Node parent ){
        if( root == null )
            return ;
        map.put( root , parent ) ;
        mapping( root.left , map , root ) ;
        mapping( root.right , map , root ) ;
    }
}





