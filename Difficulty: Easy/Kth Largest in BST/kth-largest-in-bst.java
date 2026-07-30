/* Structure of a Binary Tree Node
class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int val) {
        data = val;
        left = right = null;
    }
};*/

class Solution {
    private int count = 0;
    private int result = -1;

    public int kthLargest(Node node, int k) {
        count = 0;
        result = -1;
        reverseInorder(node, k);
        return result;
    }

    private void reverseInorder(Node root, int k) {
        if (root == null || count >= k) {
            return;
        }
        reverseInorder(root.right, k);
        count++;
        if (count == k) {
            result = root.data;
            return;
        }
        reverseInorder(root.left, k);
    }
}