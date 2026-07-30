/* Node is as follows:
class Tree
{
    int data;
    Tree left,right;
    Tree(int d){
        data = d;
        left = null;
        right = null;
    }
}*/
/* Node structure provided by the platform:
class Node {
    int data;
    Node left, right;
    Node(int d) {
        data = d;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public static int treePathsSum(Node root) {
        return solve(root, 0);
    }
    private static int solve(Node node, int Sum) {
        if (node == null) {
            return 0;
        }
        Sum = Sum * 10 + node.data;
        if (node.left == null && node.right == null) {
            return Sum;
        }
        return solve(node.left, Sum) + solve(node.right, Sum);
    }
}