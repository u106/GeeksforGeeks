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
    public int distCandy(Node root) {
        int[] moves=new int[1];
        moves[0]=0;
        fun(root,moves);
        return moves[0];
    }
    public int fun(Node root,int[] moves){
        if(root==null) return 0;
        int lsb=fun(root.left,moves);
        int rsb=fun(root.right,moves);
        int current=root.data+lsb+rsb-1;
        moves[0]+=Math.abs(current);
        return current;
    }
}